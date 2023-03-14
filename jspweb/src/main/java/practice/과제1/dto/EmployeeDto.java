package practice.과제1.dto;

public class EmployeeDto {
	private int eno;
	private String ename;
	private String erank;
	private String etype;
	private String dept;
	private String edate;
	private String epic;
	private String rdept;
	private String dedate;
	private String dereason;
	
	
	public EmployeeDto() { 	}


	public EmployeeDto(int eno, String ename, String erank, String etype, String dept, String edate, String epic,
			String rdept, String dedate, String dereason) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.erank = erank;
		this.etype = etype;
		this.dept = dept;
		this.edate = edate;
		this.epic = epic;
		this.rdept = rdept;
		this.dedate = dedate;
		this.dereason = dereason;
	}


	@Override
	public String toString() {
		return "EmployeeDto [eno=" + eno + ", ename=" + ename + ", erank=" + erank + ", etype=" + etype + ", dept="
				+ dept + ", edate=" + edate + ", epic=" + epic + ", rdept=" + rdept + ", dedate=" + dedate
				+ ", dereason=" + dereason + "]";
	}


	public int getEno() {
		return eno;
	}


	public void setEno(int eno) {
		this.eno = eno;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getErank() {
		return erank;
	}


	public void setErank(String erank) {
		this.erank = erank;
	}


	public String getEtype() {
		return etype;
	}


	public void setEtype(String etype) {
		this.etype = etype;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public String getEdate() {
		return edate;
	}


	public void setEdate(String edate) {
		this.edate = edate;
	}


	public String getEpic() {
		return epic;
	}


	public void setEpic(String epic) {
		this.epic = epic;
	}


	public String getRdept() {
		return rdept;
	}


	public void setRdept(String rdept) {
		this.rdept = rdept;
	}


	public String getDedate() {
		return dedate;
	}


	public void setDedate(String dedate) {
		this.dedate = dedate;
	}


	public String getDereason() {
		return dereason;
	}


	public void setDereason(String dereason) {
		this.dereason = dereason;
	}

	
	
	
	
	
}
