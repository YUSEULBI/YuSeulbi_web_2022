package Day11.ex7_타입변환;

import java.util.ArrayList;

import Day11.ex6.HanKookTire;
import Day11.ex6.KumHoTire;
import Day11.ex6.Tire;

public class 실행2 {

	public static void main(String[] args) {
		
		

		Tire tire = new Tire();
		KumHoTire kumHoTire = new KumHoTire();
		HanKookTire hanKookTire = new HanKookTire();
		
		// 1. 참조타입 자동타입 변환 / 자식 -> 부모 
		Tire temp = tire;
			Tire temp2 = kumHoTire;
				Tire temp3 = hanKookTire;
					Object temp4 = temp3;
		
		
		// 2. 강제타입 변환	/ 부모 -> 자식
		Tire tire2 = (Tire)temp4; 
			KumHoTire kumHoTire2 = (KumHoTire)tire2;
				HanKookTire hanKookTire2 = (HanKookTire)tire2;
		
		
		// 3. 매개변수 , 리턴타입
		Tire result = 함수1( kumHoTire2 );
		KumHoTire result2 = (KumHoTire)함수2( (KumHoTire)temp2 );		
		
		// 4. 배열
		ArrayList<KumHoTire> kumHoList = new ArrayList<>();
		kumHoList.add(kumHoTire);	// O
		kumHoList.add(hanKookTire); // X
		kumHoList.add(tire);		// X
		
		// ----> 리스트 자료형을 슈퍼클래스로 설정하면 자식참조형을 담을 수 있다.
		ArrayList<Tire> TireList = new ArrayList<>();
		TireList.add(kumHoTire);	// O
		TireList.add(hanKookTire);	// O
		TireList.add(tire);			// O
		
	} // main end
	
	public static KumHoTire 함수1 ( Tire tire ) {	return new KumHoTire(); }
	public static Tire 함수2( KumHoTire kumHoTire ) {return new Tire(); }
	
}
