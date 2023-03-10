package Day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex5_DB연동2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Connection con = null; // 여러 if{}안에서 사용하려고
		
		while (true ) {
			try { // 1. 예외 발생할 것 같은 코드 [ 예상 : nextInt() 인데 문자열 입력시 예외 발생 ]
				System.out.println("1. DB연결 2.SQL구문삽입 3.매개변수");
				int ch = scanner.nextInt();
				if ( ch == 1) {	
					System.out.print("-- 연동할 DB명 선택 : ");
					String dbname = scanner.next();
					System.out.println(dbname + "에 연결합니다.");
					
					//* 입력받은 DB와 연결
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbname , "root","1234");
					System.out.println("**연결 성공");
				}
				else if ( ch == 2) {	
					System.out.println("-- 생성할 table sql 입력 : ");
					scanner.nextLine(); // *scanner.nextLine(); 앞에 다른 .next() 있을 때 오류 방지
					String sql = scanner.nextLine();
					
					//* 연결된 DB객체에 SQL대입 [ PreparedStatement ps <- ps로 매개변수 처리할 수 있음 ] 
					PreparedStatement ps = con.prepareStatement(sql);

					//* sql실행
					ps.execute();
					
				}else if ( ch==3 ) {
					System.out.println("번호 : "); 		int mno = scanner.nextInt();
					System.out.println("아이디 : ");		String mid = scanner.next();
					System.out.println("비밀번호 : ");		String mpw = scanner.next();
					
					//* sql 구문 작성 [ ? 변수가 들어갈 자리 ]
					String sql = "insert into member values( ? , ? , ? );";
					PreparedStatement ps = con.prepareStatement(sql);
					
					// *? 매개변수에 데이터변수를 대입
					ps.setInt(1, mno); // 1. : sql 구문에서 첫번째 ?자리
					ps.setString(2, mid);
					ps.setString(3, mpw);
					
					// *
					ps.executeUpdate();
					
				}
				
			}
			catch (InputMismatchException e) { // 2. try{} 에서 예외 발생하면 실행되는 코드
				System.out.println("[알수없는] 번호 입니다.");
				scanner = new Scanner(System.in); // 기존에 입력된 데이터 제거
			}
			catch (SQLException e) {
				System.out.println("[SQL 오류] : "+e);
			}
		}
		
		
	}//main end
}
