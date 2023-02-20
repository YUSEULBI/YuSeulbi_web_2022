package Day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Ex4_DB연동 {
	
	public static void main(String[] args) {
		try {
			// 1. DB연동 연결 인터페이스
			Connection con = DriverManager.getConnection( // con <- DB객체
						"jdbc:mysql://localhost:3306/java" ,	//java에서 DB생성불가 DB생성후 자바에서연동
						"root" , 
						"1234");
			
			System.out.println(" [DB 연동 성공]");
			
			// 2. 테이블 생성하는 sql 구문을 문자열 변수에 저장
			String sql = "create table member( mno int , mid varchar(20) , password varchar(20) )";
			
			// 3. DML DDL 조작 인터페이스에 연결된 DB연결구현객체에 SQL매개변수대입 , ps객체를 새로만듦
			PreparedStatement ps = con.prepareStatement(sql);
			
			// 4. SQL 실행
			ps.execute();	
			
			
		}
		catch ( Exception e ) {
			System.out.println(" [DB연동실패] 사유 : " + e);
		}
	}
	
}


/*

	JDBC : 자바와 DB 연결 드라이브
		- 해당 DBMS 마다 라이브러리[.JAR]파일 필요
		- 보관장소 : C://
		
	- 라이브러리 추가
		1. 프로젝트 오른쪽 클릭 -> bulid path -> configure bulid path 
			-> javaSE-17 -> edit -> 버전 1.8로 변경 -> apply -> 
	
			
	 2. 
	 	Connection : DB연결 인터페이스로 다양한 객체를 제공
	 	DriverManager : DB연결 클래스 구현객체 제공
	 		DriverManager.getConnection( db주소 , 계정 , 비밀번호 );
	 			// *일반예외 발생 -> 
	 			- mysql기준 server주소 : 
	 					jdbc:mysql://ip주소:포트번호/DB명
	 			- 로컬pc 기준 : jdbc:mysql://localhost:3306/DB명
	 			- mysql 워크벤치 생성한 db : create database java;
	 		
*/