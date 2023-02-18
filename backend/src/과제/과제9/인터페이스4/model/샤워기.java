package 과제.과제9.인터페이스4.model;

public class 샤워기 implements 수전 {
	@Override
	public void 수도꼭지를튼다() {
		 System.out.println("샤워기에서 물이 나옵니다.");
	}
	
	//필터사용함수 공통
	public 필터 필터누적횟수추가(  ) {
		필터 필터 =(필터)this;
		필터.set필터누적사용횟수(필터.get필터누적사용횟수()+1);
		//System.out.println("필터사용횟수 : " + 필터.get필터누적사용횟수() +"회");
		System.out.println("남은 필터사용횟수 : "+(필터.get필터교체주기()-필터.get필터누적사용횟수())+"회");
		return 필터;
	}
	
	//필터소진확인용
	public boolean 필터확인함수() {
		필터 필터 =(필터)this;
		if ( 필터.get필터누적사용횟수() >= 필터.get필터교체주기() ) {return true;}
		return false;
	}
	//소진시 횟수 초기화
	public void 누적횟수초기화() {
		필터 필터 =(필터)this;
		필터.set필터누적사용횟수(0);
	}
}
