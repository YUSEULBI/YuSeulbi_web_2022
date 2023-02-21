package Day15.Ex8_DB연동;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.cj.protocol.Resultset;

public class DB연동 {
	
	// 준비물
		// 1. DB서버주소 [ localhost vs 개인ip vs AWS ]
		// 2. 해당 DB서버의 계정
		// 3. 해당 계정의 비밀번호
	
	
	// 자바에서 DB 조작 클래스 및 인터페이스
	// java.sql 패키지 import
		// 1. DriverManager.getConnection("DB서버주소","계정명","비밀번호") 연결성공시 DB구현객체 반환
				//***예외처리필수
	//인터페이스
	private Connection conn;		// 1. DB에 연결된 구현객체를 받아서 DB와 관련된 다양한 메소드 제공
	private PreparedStatement ps; 	// 2. 연결된 SQL조작 메소드 제공 [ ? 매개변수 사용 ] ***예외처리필수
	private Resultset rs;			// 3. SQL 결과 조작 메소드
	
	public DB연동() {
		
		try {
			conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/java", "root", "1234" 	);
			System.out.println("[연동성공]");
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void main(String[] args) {
		
		DB연동 db연동 = new DB연동();
	}
	
}
