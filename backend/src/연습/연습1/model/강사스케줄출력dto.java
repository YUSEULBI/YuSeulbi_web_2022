package 연습.연습1.model;

import java.time.LocalDateTime;

public class 강사스케줄출력dto {
	String 강사;
	int 스케줄번호_pk;
	LocalDateTime 수강일시;
	
	public 강사스케줄출력dto() {
		// TODO Auto-generated constructor stub
	}

	public 강사스케줄출력dto(String 강사, int 스케줄번호_pk, LocalDateTime 수강일시) {
		super();
		this.강사 = 강사;
		this.스케줄번호_pk = 스케줄번호_pk;
		this.수강일시 = 수강일시;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public String get강사() {
		return 강사;
	}

	public void set강사(String 강사) {
		this.강사 = 강사;
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
	
	
}
