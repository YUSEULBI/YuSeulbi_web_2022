package Day13.ex3_p362;

public class 실행 {
	
	public static void main(String[] args) {
		
		// 1. 구현객체
		RemoteControl rc = new SmartTelevision();
		
		rc.turnOn();
		rc.turnOff();
		
		
		// 2. 구현객체 교체
		Searchable sc = new SmartTelevision();
		
		sc.search("유튜브");
		
		
		// 자식이 부모를 선택 , 자식은 부모를 안다 (자동타입변환 ) / 
		// 부모는 자식을 모름 (부모클래스는 자식에대한 기록이 없음) 자식을 찾기위해 instendsOf 또는 강제형변환
		
	}
	
}
