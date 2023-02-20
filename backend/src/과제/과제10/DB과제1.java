package 과제.과제10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DB과제1 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Connection con = null;
		
		while (true) {
			try {
				
					System.out.println("1. DB연결 2.SQL구문 작성 3.매개변수 입력");
					int ch = scanner.nextInt();
					if ( ch == 1 ) {	
						System.out.println("연결할 DB명 : ");
						String dbname = scanner.next();
						System.out.println(dbname + "DB를 연결합니다.");
							
						con = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/"+dbname,
								"root",
								"1234"
								);
						System.out.println("DB연결 성공했습니다.");
						
					}
					else if ( ch == 2 ) {	
						scanner.nextLine();
						String sql = scanner.nextLine();
						PreparedStatement pc = con.prepareStatement(sql);
						pc.execute();
					}
					else if ( ch == 3 ) {	
						System.out.println("제품번호 : "); 	int pno = scanner.nextInt();
						System.out.println("제품명 : ");	String pname = scanner.next();
						System.out.println("제품설명 : ");	String pcontent = scanner.next();
						System.out.println("제품가격 : ");	int pprice = scanner.nextInt();
						
						String sql = "insert into product(pno,pname,pcontent,pprice) values( ? , ? , ? , ? )";
						PreparedStatement pc = con.prepareStatement(sql);
						pc.setInt(1, pno);
						pc.setString(2, pname);
						pc.setString(3, pcontent);
						pc.setInt(4, pprice);
						
						pc.executeUpdate();
					}
					
			}
			catch (InputMismatchException e) {
				System.out.println("번호를 다시 입력하세요.");
				scanner = new Scanner(System.in);
			}
			catch( SQLException e) {
				System.out.println("[SQL 오류] : " + e);
			}
			
		}
		
	}
	
}
