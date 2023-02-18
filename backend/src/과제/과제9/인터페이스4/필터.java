package 과제.과제9.인터페이스4;

public class 필터 extends 샤워기 { //필터 공통 모델링
	//1.필드
	private int 필터누적사용횟수;
	private int 필터교체주기;
	
	//2.생성자
	public 필터() {	}
	
	public 필터(int 필터교체주기) {
		this.필터교체주기 = 필터교체주기;
	}

	
	
	//메소드
	public int get필터누적사용횟수() {
		return 필터누적사용횟수;
	}

	public void set필터누적사용횟수(int 필터누적사용횟수) {
		this.필터누적사용횟수 = 필터누적사용횟수;
	}

	public int get필터교체주기() {
		return 필터교체주기;
	}

	public void set필터교체주기(int 필터교체주기) {
		this.필터교체주기 = 필터교체주기;
	}
	
	
}
