package Day09.Ex3_236p;

public class Car { // 클래스 [ JVM 메소드 영역에 로드 ]
	
	// 1. return 메소드 실행을 강제 종료하고 호출한 곳으로 돌아감
	
	// 1. 필드
	int gas;
	
	// 2. 생성자
	Car(){}
	Car( int gas ){ this.gas = gas;}
	
	// 3. 메소드
		// 1. 리턴타입X 인수O [ int형 매개변수 ]				
		void setGas ( int gas ) { // gas를 저장하는 함수 // 필드에 간접접근 함수
			this.gas = gas;
		}
		
		
		// 리턴타입O boolean 인수X 
		boolean isLeftGas() { // 가스 유무 확인 함수
			if ( gas == 0 ) {
				System.out.println("gas가 없습니다");
				return false;
			}
			System.out.println("gas가 있습니다");
			return true;
		}
		
		
		// 리턴타입X 인수X
		void run() { // 가스가 0일때까지 달리는 함수
			while ( true ) { // 무한루프 [ 종료조건 : gas가 0이면 return ]
				if ( gas > 0 ) { // gas가 0보다 크면 달림
					System.out.println("달립니다. gas잔량 : " + gas );
					gas--;
				}else { // gas가 0이면 멈춤
					System.out.println("멈춥니다. gas잔량 : " + gas);
					return; // 함수종료 ( while도 종료 )
				}
			}
		}
		

}
