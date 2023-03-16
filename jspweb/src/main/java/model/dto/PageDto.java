package model.dto;

import java.util.ArrayList;

public class PageDto {
	
	private int page; // 현재페이지
	private int listsize; // 한페이지당 게시물수
	private int startrow; // 선택페이지의 시작게시물 인덱스
	private int totalsize; // 총 게시물 개수
	private int totalpage; // 총 페이지 개수
	// !! 추가
	private int btnsize; // 페이지당 버튼수
	private int startbtn; // 페이지당 시작버튼
	private int endbtn;	// 페이지당 마지막버튼
	// !! : 게시물목록
	private ArrayList<BoardDto> boardList; // 출력할 데이터 게시물 리스트
	
	
	
	public PageDto() {	}



	public PageDto(int page, int listsize, int startrow, int totalsize, int totalpage, int btnsize, int startbtn,
			int endbtn, ArrayList<BoardDto> boardList) {
		super();
		this.page = page;
		this.listsize = listsize;
		this.startrow = startrow;
		this.totalsize = totalsize;
		this.totalpage = totalpage;
		this.btnsize = btnsize;
		this.startbtn = startbtn;
		this.endbtn = endbtn;
		this.boardList = boardList;
	}



	@Override
	public String toString() {
		return "PageDto [page=" + page + ", listsize=" + listsize + ", startrow=" + startrow + ", totalsize="
				+ totalsize + ", totalpage=" + totalpage + ", btnsize=" + btnsize + ", startbtn=" + startbtn
				+ ", endbtn=" + endbtn + ", boardList=" + boardList + "]";
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



	public int getBtnsize() {
		return btnsize;
	}



	public void setBtnsize(int btnsize) {
		this.btnsize = btnsize;
	}



	public int getStartbtn() {
		return startbtn;
	}



	public void setStartbtn(int startbtn) {
		this.startbtn = startbtn;
	}



	public int getEndbtn() {
		return endbtn;
	}



	public void setEndbtn(int endbtn) {
		this.endbtn = endbtn;
	}



	public ArrayList<BoardDto> getBoardList() {
		return boardList;
	}



	public void setBoardList(ArrayList<BoardDto> boardList) {
		this.boardList = boardList;
	}

	
	
	
}
