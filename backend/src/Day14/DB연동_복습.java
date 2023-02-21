package Day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DB연동_복습 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Connection con = null;
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/java",
					"root",
					"1234"
				);
			System.out.println("DB연결 성공");
			
			while ( true ) {
				System.out.println("SQL구문 입력 : ");
				scanner.nextLine();
				
				String sql = scanner.nextLine();
				PreparedStatement pc = con.prepareStatement(sql);
				pc.execute();
				System.out.println("워크벤치에서 확인");
			}
		}
		catch (SQLException e) {
			System.out.println("DB연결 실패");
			System.out.println("SQL예외 : "+e);
		}
		
		
		
	}
	
	
}
