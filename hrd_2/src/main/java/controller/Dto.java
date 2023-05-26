package controller;

public class Dto {
	private String sno;
	private String sname;
	private String sphone;
	private String sgender;
	private String saddreess;
	private int ekor;
	private int emath;
	private int eeng;
	private int ehist;
	
	private int sum;
	private double avg;
	private int rank;
	
	private String sno1;
	private String sno2;
	private String sno3;
	
	// 빈생성자
	public Dto() {
		// TODO Auto-generated constructor stub
	}

	public Dto(String sno, String sname, String sphone, String sgender, String saddreess) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sphone = sphone;
		this.sgender = sgender;
		this.saddreess = saddreess;
	}
	
	
	// 학생 점수 등록시 사용하는 생성자
	public Dto(String sno, int ekor, int emath, int eeng, int ehist) {
		super();
		this.sno = sno;
		this.ekor = ekor;
		this.emath = emath;
		this.eeng = eeng;
		this.ehist = ehist;
	}
	
	// 학생들 점수 출력용 생성자
		public Dto(String sname, int ekor, int emath, int eeng, int ehist, int sum, double avg, int rank, String sno1,
			String sno2, String sno3) {
		super();
		this.sname = sname;
		this.ekor = ekor;
		this.emath = emath;
		this.eeng = eeng;
		this.ehist = ehist;
		this.sum = sum;
		this.avg = avg;
		this.rank = rank;
		this.sno1 = sno1;
		this.sno2 = sno2;
		this.sno3 = sno3;
	}

	public String getSno() {
		return sno;
	}



	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public String getSgender() {
		return sgender;
	}

	public void setSgender(String sgender) {
		this.sgender = sgender;
	}

	public String getSaddreess() {
		return saddreess;
	}

	public void setSaddreess(String saddreess) {
		this.saddreess = saddreess;
	}

	public int getEkor() {
		return ekor;
	}

	public void setEkor(int ekor) {
		this.ekor = ekor;
	}

	public int getEmath() {
		return emath;
	}

	public void setEmath(int emath) {
		this.emath = emath;
	}

	public int getEeng() {
		return eeng;
	}

	public void setEeng(int eeng) {
		this.eeng = eeng;
	}

	public int getEhist() {
		return ehist;
	}

	public void setEhist(int ehist) {
		this.ehist = ehist;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getSno1() {
		return sno1;
	}

	public void setSno1(String sno1) {
		this.sno1 = sno1;
	}

	public String getSno2() {
		return sno2;
	}

	public void setSno2(String sno2) {
		this.sno2 = sno2;
	}

	public String getSno3() {
		return sno3;
	}

	public void setSno3(String sno3) {
		this.sno3 = sno3;
	};
	
	
		
}
