package Day11.ex1;

public class 실행 {
	
	public static void main(String[] args) {
		// 1. phone 객체
		Phone phone = new Phone();
		
		// 2. phone 객체의 인스턴스멤버 호출
		phone.color = "빨강";
		System.out.println( phone.color );
		phone.bell();
		phone.sendVoice("안녕하세요");
		// 3. phone 클래스는 spmarPhone 멤버 호출
		// phone.wifi // 부모객체는 자식객체의 멤버 호출 할 수 없다.
		
		
		// 1
		Smartphone smartPhone = new Smartphone();
		// 2 SmartPhone 클래스는 phone  멤버 호출
		// * 자식클래스는 부모클래스의 멤버 호출 할 수 있다. 
		smartPhone.color = "은색";
		System.out.println( smartPhone.color );
		smartPhone.bell();
		smartPhone.sendVoice("안녕하세요");
		
		// 1.
		Smartphone myphone = new Smartphone("갤럭시", "은색");
		
		// 2. 자식클래스로 부모클래스 멤버 호출
		System.out.println("모델 : " + smartPhone.model );
		System.out.println("모델 : " + smartPhone.color );
		
		// 3. 자식클래스가 본인멤버 호출
		System.out.println("와이파이 상태 : " + myphone.wifi );
		
		// 4. 자식클래스로 부모클래스 멤버 호출
		myphone.bell();
		myphone.sendVoice("여보세요");
		myphone.receiveVoice("안녕하세요! 저는 홍길동인데요!");
		myphone.sendVoice("아~네 반갑습니다.");
		myphone.handUp();
		
		// 5. 자식클래스 본인 멤버 호출
		myphone.setWifi(true);
		myphone.internet();
		
	}
	
	
}

/*


	자동완성메뉴
	필드 : 필드명 자료형 클래스
	메소드 : 함수명(매개변수) , 반환타입 , 클래스명

*/
