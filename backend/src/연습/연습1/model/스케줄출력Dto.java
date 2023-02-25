package 연습.연습1.model;

import java.time.LocalDateTime;

public class 스케줄출력Dto {
	int 스케줄번호_pk;
	LocalDateTime 수강일시;
	int 금액;
	String 이름;
	
	public 스케줄출력Dto() { 	}

	
	public 스케줄출력Dto(int 스케줄번호_pk, LocalDateTime 수강일시, int 금액, String 이름) {
		super();
		this.스케줄번호_pk = 스케줄번호_pk;
		this.수강일시 = 수강일시;
		this.금액 = 금액;
		this.이름 = 이름;
	}

	
	@Override
	public String toString() {
		return "스케줄출력Dto [스케줄번호_pk=" + 스케줄번호_pk + ", 수강일시=" + 수강일시 + ", 금액=" + 금액 + ", 이름=" + 이름 + "]";
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

	public String get이름() {
		return 이름;
	}

	public void set이름(String 이름) {
		this.이름 = 이름;
	}
	
	
	
}


