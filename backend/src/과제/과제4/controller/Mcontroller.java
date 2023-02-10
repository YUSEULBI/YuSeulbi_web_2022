package 과제.과제4.controller; // JAVA

import java.util.ArrayList;

import 과제.과제4.model.Member;



// *처리/제어 담당 / 로직담당 비지니스로직
public class Mcontroller {
	// DB 대신할 [ 데이터 저장소 ]
	ArrayList<Member> memberDb = new ArrayList<>();
	
	// 1. 회원가입 로직
	public int signup( String id , String pwd , String confirmpwd , String name , String phone) {
		// 1. 유효성검사 // 정규표현식?
		if ( !pwd.equals(confirmpwd)) { return 1; } // 회원가입 실패 1
		// 2. 객체 만들어서
		Member member = new Member( id , pwd , name , phone );
		// 3. db처리
		memberDb.add(member);
		
		
		return 0; // 회원가입 성공 반환
	}
	
	// 2. 로그인 로직
	public int login( String loginId , String loginPwd ){
		
		int count = 0;
		// id와 pwd가 DB데이터의 id,pwd와 같으면
		for ( int i = 0 ; i < memberDb.size() ; i++ ) {
			if ( loginId.equals(memberDb.get(i).id)) {
				if ( loginPwd.equals(memberDb.get(i).pwd) ) {
					return i; //회원인덱스
				}
			}else {
				return -1; // 비밀번호 틀림
			}// if end
		} // for end
		return -2; // for문 다돌렸는데 맞는게 없어~ 아이디가 없음
	}
	
	
	// 3. 아이디 찾기 로직
	public String findId( String findName , String findPhone ) {	
		for ( int i = 0 ; i < memberDb.size() ; i++ ) {
			if ( findName.equals(memberDb.get(i).name)) {
				//이름이 같으면
				if ( findPhone.equals(memberDb.get(i).phone)) {
					//전화번호같으면
					// 찾은 아이디 반환
					return memberDb.get(i).id;
				}else { return "1";} // 맞는 전화번호가 없음
			}
		}
		return "0" ;// 맞는 이름이 없음
	};
	
	
	// 4. 비밀번호 찾기 로직
		//비밀번호를 반환 , 인수 : 아이디, 전화번호
	public String findpw(String findId ,String findphone ) {
		for ( int i = 0 ; i < memberDb.size() ; i++ ) {
			if ( findId.equals(memberDb.get(i).id)) {
				//아이디가 같으면
				if ( findphone.equals(memberDb.get(i).phone)) {
					//전화번호가 같으면
					//비밀번호 반환
					return memberDb.get(i).pwd;
				}else { return "1";} // 맞는 전화번호가 없음
			}
		}
		return "0"; // 맞는 아이디가 없음
	}
	
}
