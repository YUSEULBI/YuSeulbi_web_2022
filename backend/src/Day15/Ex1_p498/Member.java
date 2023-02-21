package Day15.Ex1_p498;

public class Member {
	
	//필드
	public String id;
	
	//생성자
	public Member( String id ) {	
		this.id = id;
	}
	
	//메소드
	// 주소번지 비교가 아닌 내부 값 비교로 재정의[오버라이딩]
	@Override
	public boolean equals(Object obj) {
		
		//if ( obj instanceof Member target ) { //JDK16이상버전
			// 부모객체 instanceof 자식클래스 변환객체명
			// obj -> target
		//Object의 equals를 오버라이드 했기 때문에
		//인수를 원래 equals처럼 똑같이 Object로 받아야함.
		//Object로 받고 원래 Member타입이었으면 instanceof가 true가 나옴
		// true이면 Object -> Member로 타입 변경
		if ( obj instanceof Member ) {
			Member target = (Member)obj;
			if ( id.equals(target.id)) {
				return true;
			}
		}
		return false;
		
	}
}
