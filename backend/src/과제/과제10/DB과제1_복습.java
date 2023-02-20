package 과제.과제10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DB과제1_복습 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Connection con = null;
		while ( true ) {
			try {
			
				
				System.out.println("1.DB연결 2.SQL구문 작성 3.매개변수 입력");
				int ch = scanner.nextInt();
				if ( ch == 1 ) {
					System.out.println("연결할 DB명 : "); String dbname = scanner.next();
					//DB연결
					con = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/"+dbname,
								"root",
								"1234"
							); //con은 DB객체
					System.out.println("DB연결성공");
				}
				else if ( ch == 2 ) {	
					System.out.println("sql구문 입력 : ");
					scanner.nextLine();
					String sql = scanner.nextLine();
					PreparedStatement pc = con.prepareStatement(sql);
					pc.execute();
				}
				else if ( ch == 3 ) {	
					System.out.println("제품번호 : ");	int pno = scanner.nextInt();
					System.out.println("제품명 : ");	String pname = scanner.next();
					scanner.nextLine();
					System.out.println("제품설명 : ");	String pcontent = scanner.nextLine();
					System.out.println("제품가격 : ");	int pprice = scanner.nextInt();
					PreparedStatement pc = con.prepareStatement("insert into product(pno,pname,pcontent,pprice) values( ? , ? , ? , ? );");
					pc.setInt(1, pno);
					pc.setString(2, pname);
					pc.setString(3, pcontent);
					pc.setInt(4, pprice);
					pc.executeUpdate();
					
				}
				
			
			}
			catch (InputMismatchException e) {
				System.out.println("다시 입력해주세요.[입력형식오류]");
				scanner = new Scanner(System.in); 
				//scanner객체에 잘못된 값이 남아있으면 while문이 잘못된 값을 계속 인식해서 catch를 계속 실행시킴. 무한루프
				//무한루프를 해결하기위해 scanner변수에 새로운 스캐너객체로 변경.
			}
			catch (SQLException e) {
				System.out.println("DB연결실패.[SQL오류] : "+e);
			}
			
		}//while end
		
		
		
	}//main end
	
}//class end

