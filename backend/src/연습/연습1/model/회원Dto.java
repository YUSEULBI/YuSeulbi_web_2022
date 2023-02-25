package 연습.연습1.model;

public class 회원Dto {
	
	/*
	 
	회원번호_pk int auto_increment primary key , 
    아이디 varchar(20) ,
    비밀번호 varchar(20) ,
    전화번호 varchar(20) ,
    이름 varchar(20) ,
    등급  int
	 
	 */
	
	private int 회원번호_pk; 
	private String 아이디;
	private String 비밀번호;
	private String 전화번호;
	private String 이름;
	private int 등급;
    
    public 회원Dto() {	}
    
	public 회원Dto(int 회원번호_pk, String 아이디, String 비밀번호, String 전화번호, String 이름, int 등급) {
		super();
		this.회원번호_pk = 회원번호_pk;
		this.아이디 = 아이디;
		this.비밀번호 = 비밀번호;
		this.전화번호 = 전화번호;
		this.이름 = 이름;
		this.등급 = 등급;
	}

		
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public int get회원번호_pk() {
		return 회원번호_pk;
	}

	public void set회원번호_pk(int 회원번호_pk) {
		this.회원번호_pk = 회원번호_pk;
	}

	public String get아이디() {
		return 아이디;
	}

	public void set아이디(String 아이디) {
		this.아이디 = 아이디;
	}

	public String get비밀번호() {
		return 비밀번호;
	}

	public void set비밀번호(String 비밀번호) {
		this.비밀번호 = 비밀번호;
	}

	public String get전화번호() {
		return 전화번호;
	}

	public void set전화번호(String 전화번호) {
		this.전화번호 = 전화번호;
	}

	public String get이름() {
		return 이름;
	}

	public void set이름(String 이름) {
		this.이름 = 이름;
	}

	public int get등급() {
		return 등급;
	}

	public void set등급(int 등급) {
		this.등급 = 등급;
	}
    
	
}
