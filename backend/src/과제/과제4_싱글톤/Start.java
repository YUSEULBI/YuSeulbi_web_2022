package 과제.과제4_싱글톤;

import 과제.과제4_싱글톤.view.Front;

public class Start {

	public static void main(String[] args) {
		
		Front.getInstance().index();
		
	}
	
}

/*


	V : 아이디 , 비밀번호 입력만 -> html
	C : 입력받은 데이터를 유효성검사후 저장 -> 자바
	M : 컨트롤이 데이터를 저장할 때 사용되는 모델링 -> DB


*/