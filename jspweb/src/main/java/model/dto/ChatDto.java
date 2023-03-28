package model.dto;

public class ChatDto {
	private int nno;
	private String ncontent;	// 보낸컨텐츠
	private String ndate;	//보낸날짜
	private int pno; // 제품번호
	private int frommno; // 보낸사람
	private int tomno;	// 받는사람
	//추가필드
	
	public ChatDto() {
		// TODO Auto-generated constructor stub
	}

	public ChatDto(int nno, String ncontent, String ndate, int pno, int frommno, int tomno) {
		super();
		this.nno = nno;
		this.ncontent = ncontent;
		this.ndate = ndate;
		this.pno = pno;
		this.frommno = frommno;
		this.tomno = tomno;
	}

	// 보내는용 생성자
	public ChatDto(String ncontent, int pno, int frommno, int tomno) {
		super();
		this.ncontent = ncontent;
		this.pno = pno;
		this.frommno = frommno;
		this.tomno = tomno;
	}
	
	@Override
	public String toString() {
		return "ChatDto [nno=" + nno + ", ncontent=" + ncontent + ", ndate=" + ndate + ", pno=" + pno + ", frommno="
				+ frommno + ", tomno=" + tomno + "]";
	}

	

	public int getNno() {
		return nno;
	}

	public void setNno(int nno) {
		this.nno = nno;
	}

	public String getNcontent() {
		return ncontent;
	}

	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	public String getNdate() {
		return ndate;
	}

	public void setNdate(String ndate) {
		this.ndate = ndate;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public int getFrommno() {
		return frommno;
	}

	public void setFrommno(int frommno) {
		this.frommno = frommno;
	}

	public int getTomno() {
		return tomno;
	}

	public void setTomno(int tomno) {
		this.tomno = tomno;
	}
	
	
}
