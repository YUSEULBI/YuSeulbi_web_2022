package 과제.과제9.인터페이스4;

public class 카본필터 extends 필터 {
	
	//1.필드
		
	
	//2.생성자
		public 카본필터() {		}
	
		
		public 카본필터(int 필터교체주기) {
			super(필터교체주기);

		}

		//3.메소드
		@Override
		public void 수도꼭지를튼다() {
			System.out.println("샤워기에서 '염소와 물냄새를 제거한' 물이 나옵니다.");
		}
		
	
	
}
