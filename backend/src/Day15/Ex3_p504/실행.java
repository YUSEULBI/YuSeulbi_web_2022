package Day15.Ex3_p504;

public class 실행 {

	public static void main(String[] args) {
		
		Smartphone myPhone = new Smartphone("삼성전자", "안드로이드");
		
		System.out.println( myPhone.toString() );
		
		System.out.println( myPhone ); // 객체출력하면 기본 toString 됨
		
	}
	
}
