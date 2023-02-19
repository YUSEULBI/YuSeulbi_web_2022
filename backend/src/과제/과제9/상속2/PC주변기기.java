package 과제.과제9.상속2;

public class PC주변기기 extends PC주변기기서비스 {
	private String 제품명; // 무선 유선
	private int 제품가격; // 무선 유선
	private String 연결방식; // 무선 유선
	private int pno;
	
	public PC주변기기() {	}

	public PC주변기기(String 제품명, int 제품가격, String 연결방식) {
		this.제품명 = 제품명;
		this.제품가격 = 제품가격;
		this.연결방식 = 연결방식;
	}

	public String get제품명() {
		return 제품명;
	}

	public void set제품명(String 제품명) {
		this.제품명 = 제품명;
	}

	public int get제품가격() {
		return 제품가격;
	}

	public void set제품가격(int 제품가격) {
		this.제품가격 = 제품가격;
	}

	public String get연결방식() {
		return 연결방식;
	}

	public void set연결방식(String 연결방식) {
		this.연결방식 = 연결방식;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}
	
	
	
	
}
