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
		int count = 0;
		
		// 멤버리스트의 모든 memberList객체들을 처음부터 끝까지 Member m 객체에 대입
		// memberList의 인덱스 반환해야해서 for문
		for ( int i = 0 ; i < memberList.size() ; i++ ) {
			
			// id가 memberList i번째 객체의 id필드와 같고
			if ( id.equals(memberList.get(i).id)  ) { count++;
				// id가 memberList i번째 객체의 pw필드와 같으면
				if ( pw.equals(memberList.get(i).pw) ) { count++; return i;	} // if 2 end
			} // if end
			
			
			
		} // for end
		// for문 다 돌리고 count 확인
		if ( count == 1 )return -1; // 비번 틀림		
		
		return -2;	 // 없는 아이디
		 
	}
	
	
	/// memberList 리턴해주는 메소드
	public ArrayList<Member> memberList(){
		return memberList;
	}
	
	// 아이디 찾아주는 로직
	public String findId( String name , String phone ) {
		
		// 향상된 for문 // 리스트에 있는 Member객체들을 하나씩 Member m에 대입
		for ( Member m : memberList ) {
			if ( m.name.equals(name) ) {
				if ( m.phone.equals(phone) ) { return m.id; } // 아이디찾기 성공
			}// if end
		
		}// for end
		
		return null;
	}
	
} // 클래스 end
