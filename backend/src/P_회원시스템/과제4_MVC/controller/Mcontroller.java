package P_회원시스템.과제4_MVC.controller;

//ArrayList 클래스 import
import java.util.ArrayList;

//Member 클래스 import
import P_회원시스템.과제4_MVC.model.Member;




public class Mcontroller { // 클래스 시작 /////////////////////////////////////
	
	// Member클래스의 List객체 새로 만들기
	ArrayList<Member> memberList = new ArrayList<>();
	
	//메소드////////////////////////////////////////////////////////////////
	// 유효성 검사후 Member 객체생성 , Db에 객체 저장
	public int signUpSave( String id , String pw , String rePw , String name , String phone ) {
		
		if ( pw.equals(rePw) ) { // 비밀번호와 비밀번호확인이 같으면
			// 매개변수 id , pw , name , phone 생성자 객체 만들기
			Member member = new Member(id, pw, name, phone);
			// List객체에 member객체 추가
			memberList.add(member);
			return 0; // 회원가입성공
			
		}else { return -1; 	} // 회원가입실패 , 비밀번호가 서로 다릅니다.
			
	} // signUpSave 메소드 end 
	
	/////////////////////////////////////////////////////////////////////////
	
	public int login( String id , String pw ) {
		
		// 멤버리스트의 모든 Memeber객체들을 처음부터 끝까지 Member m 객체에 대입
		for ( Member m : memberList ) {
			if ( m.id == id ) {
				
			}
		}
		
		return 0;
	}
	
	
	
	
} // 클래스 end
