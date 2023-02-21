package 과제.과제9.상속3_List출력;

public class 악기 {
	private String 대분류;
	private String 중분류;
	private String 악기이름;
	
	public 악기() {	}

	
	
	//대분류 정해졌을 때 객체생성
	public 악기(String 대분류) {
		super();
		this.대분류 = 대분류;
	}
	
	public void 세부분류안내() {
		System.out.println(">>생각하신 악기는 현악기 입니다!");
		System.out.println();
		System.out.println("-세부분류로 들어가볼까요?");
	}


	public String get대분류() {
		return 대분류;
	}

	public void set대분류(String 대분류) {
		this.대분류 = 대분류;
	}

	public String get중분류() {
		return 중분류;
	}

	public void set중분류(String 중분류) {
		this.중분류 = 중분류;
	}

	public String get악기이름() {
		return 악기이름;
	}

	public void set악기이름(String 악기이름) {
		this.악기이름 = 악기이름;
	}

	
	
	

	

	
	
	
	
	
}
