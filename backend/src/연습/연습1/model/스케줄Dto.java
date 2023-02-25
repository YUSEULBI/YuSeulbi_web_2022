package 연습.연습1.model;

import java.time.LocalDateTime;

public class 스케줄Dto {

	/*
	스케줄번호_pk  int auto_increment primary key,
   	수강일시 datetime ,
    금액 int ,
    회원번호_fk int ,
    foreign key( 회원번호_fk ) references 회원( 회원번호_pk )
	 */
	
	int 스케줄번호_pk;
	LocalDateTime 수강일시; 
	int 금액;
	int 회원번호_fk;
	
	public 스케줄Dto() {
		// TODO Auto-generated constructor stub
	}

	public 스케줄Dto(int 스케줄번호_pk, LocalDateTime 수강일시, int 금액, int 회원번호_fk) {
		super();
		this.스케줄번호_pk = 스케줄번호_pk;
		this.수강일시 = 수강일시;
		this.금액 = 금액;
		this.회원번호_fk = 회원번호_fk;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	public int get스케줄번호_pk() {
		return 스케줄번호_pk;
	}
	

	public void set스케줄번호_pk(int 스케줄번호_pk) {
		this.스케줄번호_pk = 스케줄번호_pk;
	}

	public LocalDateTime get수강일시() {
		return 수강일시;
	}

	public void set수강일시(LocalDateTime 수강일시) {
		this.수강일시 = 수강일시;
	}

	public int get금액() {
		return 금액;
	}

	public void set금액(int 금액) {
		this.금액 = 금액;
	}

	public int get회원번호_fk() {
		return 회원번호_fk;
	}

	public void set회원번호_fk(int 회원번호_fk) {
		this.회원번호_fk = 회원번호_fk;
	}
	
	
}
