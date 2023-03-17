package model.dto;

import java.util.ArrayList;

public class MemberPageDto {
	private int page; // 현재페이지
	private int listsize; // 페이지당 게시물수
	private int startrow; // 선택페이지 첫회원인덱스(레코드의 인덱스)
	private int totalsize; // 총게시물수
	private int totalpage; // 총페이지수
	private int endrow; // 선택페이지 마지막회원인덱스(레코드의 인덱스)
	ArrayList<MemberDto> memberlist;
	
	public MemberPageDto() {  }

	public MemberPageDto(int page, int listsize, int startrow, int totalsize, int totalpage, int endrow,
			ArrayList<MemberDto> memberlist) {
		super();
		this.page = page;
		this.listsize = listsize;
		this.startrow = startrow;
		this.totalsize = totalsize;
		this.totalpage = totalpage;
		this.endrow = endrow;
		this.memberlist = memberlist;
	}

	@Override
	public String toString() {
		return "MemberPageDto [page=" + page + ", listsize=" + listsize + ", startrow=" + startrow + ", totalsize="
				+ totalsize + ", totalpage=" + totalpage + ", endrow=" + endrow + ", memberlist=" + memberlist + "]";
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getListsize() {
		return listsize;
	}

	public void setListsize(int listsize) {
		this.listsize = listsize;
	}

	public int getStartrow() {
		return startrow;
	}

	public void setStartrow(int startrow) {
		this.startrow = startrow;
	}

	public int getTotalsize() {
		return totalsize;
	}

	public void setTotalsize(int totalsize) {
		this.totalsize = totalsize;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getEndrow() {
		return endrow;
	}

	public void setEndrow(int endrow) {
		this.endrow = endrow;
	}

	public ArrayList<MemberDto> getMemberlist() {
		return memberlist;
	}

	public void setMemberlist(ArrayList<MemberDto> memberlist) {
		this.memberlist = memberlist;
	}

	

	
	
	 
	
}
