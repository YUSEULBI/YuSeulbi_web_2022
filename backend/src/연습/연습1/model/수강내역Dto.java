package 연습.연습1.model;

public class 수강내역Dto {
	
	/*
	수강내역번호 int auto_increment primary key , 
    회원번호_fk int ,   -- 누가 
    스케줄번호_fk int ,   -- 어떤 스케줄~
    foreign key( 회원번호_fk ) references 회원( 회원번호_pk ) ,
    foreign key( 스케줄번호_fk ) references 스케줄( 스케줄번호_pk )
	*/
	
	int 수강내역번호; 
	int 회원번호_fk; 
	int 스케줄번호_fk;
	
	public 수강내역Dto() { 	}
	
	public 수강내역Dto(int 수강내역번호, int 회원번호_fk, int 스케줄번호_fk) {
		super();
		this.수강내역번호 = 수강내역번호;
		this.회원번호_fk = 회원번호_fk;
		this.스케줄번호_fk = 스케줄번호_fk;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public int get수강내역번호() {
		return 수강내역번호;
	}

	public void set수강내역번호(int 수강내역번호) {
		this.수강내역번호 = 수강내역번호;
	}

	public int get회원번호_fk() {
		return 회원번호_fk;
	}

	public void set회원번호_fk(int 회원번호_fk) {
		this.회원번호_fk = 회원번호_fk;
	}

	public int get스케줄번호_fk() {
		return 스케줄번호_fk;
	}

	public void set스케줄번호_fk(int 스케줄번호_fk) {
		this.스케줄번호_fk = 스케줄번호_fk;
	}
	
	
    
	
}
