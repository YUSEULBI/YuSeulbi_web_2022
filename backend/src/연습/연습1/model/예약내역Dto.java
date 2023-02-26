package 연습.연습1.model;

import java.time.LocalDateTime;

public class 예약내역Dto {
	private int 수강내역번호;
	private LocalDateTime 수강일시;
	private String 강사;
	private int 금액;
	
	public 예약내역Dto() {
		// TODO Auto-generated constructor stub
	}

	public 예약내역Dto(int 수강내역번호, LocalDateTime 수강일시, String 강사, int 금액) {
		super();
		this.수강내역번호 = 수강내역번호;
		this.수강일시 = 수강일시;
		this.강사 = 강사;
		this.금액 = 금액;
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

	public LocalDateTime get수강일시() {
		return 수강일시;
	}

	public void set수강일시(LocalDateTime 수강일시) {
		this.수강일시 = 수강일시;
	}

	public String get강사() {
		return 강사;
	}

	public void set강사(String 강사) {
		this.강사 = 강사;
	}

	public int get금액() {
		return 금액;
	}

	public void set금액(int 금액) {
		this.금액 = 금액;
	}
	
	
	
}
