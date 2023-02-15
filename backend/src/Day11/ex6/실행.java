package Day11.ex6;

public class 실행 {
	
	public static void main(String[] args) {
		// * 타이어
		Tire tire = new Tire();
		
		// 1. 자동차객체 만들기
		Car myCar = new Car();
			// 자동차 객체에 타이어 객체 1개가 포함
		// 2. 기본 타이어 장착
		myCar.tire = new Tire();
		myCar.run();
			Tire result = myCar.parking(tire);
		// 3. 한국타이억체
		myCar.tire = new HanKookTire();
		myCar.run();
		
		HanKookTire hanKookTire = new HanKookTire();
			
		// 부모는 자식이 될 수 없다. -> 강제타입변환
			HanKookTire result2 = (HanKookTire)myCar.parking(hanKookTire);
			
			// Tire클래스가 result2의 부모클래스인가 -> true
			System.out.println( result2 instanceof Tire );
			System.out.println( result2 instanceof Object );
			
		// 4. 금호타이어 교체
		myCar.tire = new KumHoTire();
		myCar.run();
		
		KumHoTire kumHoTire = new KumHoTire();
			KumHoTire result3 = (KumHoTire) myCar.parking(kumHoTire);
			
	}
	
}
