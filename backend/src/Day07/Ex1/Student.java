package Day07.Ex1; // 현재 클래스가 위치한 패키지명

public class Student { // 클래스 [ 클래스는 첫글자 영문대문자 ] // 클래스 시작
	// 설계목적 클래스 - 실행불가 (  ///////////////////////////
	
	// 필드[저장소] , 생성자[객체초기화] , 메소드[동작] 구성
	// Constructor 생성자
	// - 생성자 생략시 기본생성자 자동으로 들어감 , 매개변수가 없는 Student()
	
	
} // 클래스 끝

////////////////////////////////////////////////////////////////////
/*
		객체(object) : 식별 가능한 형태 [ 상태=필드/변수 , 행동=메소드/함수 ]
		객체자향프로그래밍 [ Object Oriented Programing ] : 부품[객체]들 먼저 만들고 부품들을 조립해서 하나의 제품[프로그램] 생성
		
		클래스 : 설계도 ( 객체의 설계도 )
			인스턴스화 ( new )
		인스턴스 : 
		객체 : 
		
		JVM 관점 ( 변수 , 인스턴스 , 객체 )
		
			스택영역			힙영역
			클래스명 변수명 	= 	new 생성자();
			String str 	= 	new	String("유재석")
					<---주소값----
			스택에서 힙영역으로 찾아가기위한 주소값
			
			String str2 = 	null
			null이지만 객체임
			
			변수 			=	인스턴스(구현된실체,메모리가존재)
			[   객체 : 구현할대상 , 인스턴스화안해도 객체    ]
							new : 인스턴스화
							
			
							
*/