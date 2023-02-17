package Day13.ex3_p362;

public class SmartTelevision implements RemoteControl , Searchable {
				// 다중 인터페이스 : 클래스명 implements 인터페이스명1 , 인터페이스명2
		
		// 오버라이드 먼저하기!!!!구현 해야함!!!!!!!!!!!
		@Override
		public void turnOn() {
			System.out.println("TV를 켭니다");
			
		}
		@Override
		public void turnOff() {
			System.out.println("TV를 끕니다");
				
		}
		@Override
		public void search(String url) {
			System.out.println(url+"을 검색합니다.");
				
		}
	
}
