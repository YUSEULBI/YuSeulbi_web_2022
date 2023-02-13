package Day09.ex10_게시판;

import Day09.ex10_게시판.view.Front;

public class Start {

	public static void main(String[] args) {
		
		// 이전 방법 // 객체 새로 만들기
		// Front front = new Front();
		// front.index();
		
		Front.getInstance().index();
		// new Front().index(); 와 동일 
		
		
		
	}
	
}
