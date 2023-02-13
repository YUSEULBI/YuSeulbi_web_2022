package Day09.Ex7_p252;

public class Korean {
	
	// 1. final : 수정불가 , 공유메모리X
	final String nation = "대한민국";
	final String ssn;	// final 무조건 초기화 존재해야함.
	
	String name;
	
	//생성자 ( 매개변수 2개 )
	public Korean( String ssn , String name ) {	
		this.ssn = ssn; // final 초기화
		this.name = name;
	}
	
	
	// 2. static final : 수정불가 , 공유메모리O
	static final double EARTH_RADIUS = 6400;
	static final double EARTH_SURFACE_AREA;
	static {
		EARTH_SURFACE_AREA = 4*Math.PI * EARTH_RADIUS * EARTH_RADIUS;
	}
}


/*


	final 필드 : 최종적 뜻
		- 수정 불가 만들기
		- 무조건 초기화!
		- 필드에 직접 초기화 or 생성자 이용한 초기화
	
	static final 필드 : 상수
		- 수정 불가능 , 공유 메모리
		- 상수 이름 : 관례적으로 대문자
		


*/