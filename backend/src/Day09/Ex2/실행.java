package Day09.Ex2;

public class 실행 { // JVM 메소드 영역에 저장

		public static void main(String[] args) { // main start
			
			
			// 1. 붕어빵 객체 = 지역변수
			// 스택영역 = 힙영역주소
			붕어빵틀 붕어빵1 = new 붕어빵틀();
			System.out.println(붕어빵1); // 변수 이름을 호출하면 힙영역에 저장된 객체의 주소값이 나옴 ( 주소값은 변수명과 함께 스택영역에 저장)
			붕어빵1.굽기();
			
			//
			붕어빵틀 붕어빵2 = new 붕어빵틀("반죽");
			System.out.println(붕어빵2);
			붕어빵2.변경("반죽", "슈크림");
			
			//
			붕어빵틀 붕어빵3 = new 붕어빵틀("반죽", "팥");
			System.out.println(붕어빵3);
			System.out.println("붕어빵 판매가 : " + 붕어빵3.판매가());
			
			//
			System.out.println("붕어빵4 판매 : " + 붕어빵3.판매());
			
			//
			붕어빵3.확인(붕어빵3);
			
			
			// 리스트 호출
			System.out.println( 붕어빵3.여러개판매(5) );
			
			
			
		} // main end
		
}
