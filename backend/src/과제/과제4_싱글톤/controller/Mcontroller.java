package 과제.과제4_싱글톤.controller;

import java.util.ArrayList;


import 과제.과제4_싱글톤.model.Member;

// * 객체가 1개만 있어도 되는지 생각

public class Mcontroller { // 멀티다대다,멀티채팅 아니라면 1개만 있으면 됨
	
	// * 싱글톤 : 다른곳에서 해당 객체를 공유 메모리 [ 멤버(필드,메소드) 동일한 1개로 사용 ]
	// 1. 본인 객체 미리 만들기
	private static Mcontroller mc = new Mcontroller();
	// 2. 외부에서 객체 못만들게
	private Mcontroller() { }
	// 3. 객체는 외부로부터 차단하고 
	// 4. getInstance 함수를 통해 객체를 내보낸다 . [ 유효성검사 위해 ]
	public static Mcontroller getInstance () {
		return mc; // 정적멤버는 인스턴스멤버를 못쓰기 때문에 mc도 정적멤버로 만들기
	}
	//외부에서 getInstance 함수를 사용하려면 객체가 필요한데 객체 못만들게 막아둠
	// 정적멤버로 사용해서 객체없이 사용하게함.
	
	//DB 대신 ArrayList
	private ArrayList<Member> memberDB = new ArrayList<>();
	
	// 세션...!! 전역변수!!!!!!!!!!!!
	//로그인 한 회원의 객체를 저장 [ *동시접속 문제점 발생 DB가 아니라서 ]
		// 사용목적 : 페이지가 바뀌더라도 정보 저장 [ * 메소드가 종료되더라도 정보는 저장 ] 전역변수같은
	private Member logSession = null;
	public Member getLogSession() {
		return logSession;
	}
	
	
	// 1. 회원가입 처리 /////////////////////////////////////////////////////////////
	public int signup( String id , String pw , String confirmpw , String name , String phone ) {
		
		// 1. 유효성검사 ( 스크립트에서 웬만한 유효성검사 하고 들어오는 편 , JSP )
		if ( !pw.equals(confirmpw) ) {	return 1;	}
		// 2. DB에 저장
				// 객체화 [ 입력받은 데이터 4개와 , 회원마다 글을 저장할 리스트 메모리 초기화 ]
		Member m = new Member(id, pw, name, phone, new ArrayList<>() );
			// id , pw , name , phone : 스택영역에 저장된 힙주소 전달
			// new ArrayList<>() : 방금 생성된 힙영역에 생성된 힙주소 전달
		
		// 2. 리스트저장
		memberDB.add(m);
		return 0;
	} // end
	
	// 2. 로그인 처리 /////////////////////////////////////////////////////////////
	public int login( String id , String pw ) {
		
		for( int i = 0 ; i < memberDB.size() ; i++ ) {
			if ( memberDB.get(i).getId().equals(id)) { // i번째 인덱스의 아이디와 입력받은 아이디와 같으면
				if ( memberDB.get(i).getPw().equals(pw)) {
					
					// 로그인 성공했을음 식별가능한 흔적 남기기!!
					// 지역변수라서 로그인한 아이디가 사라지기 때문에 전역변수logSession에 저장
					logSession = memberDB.get(i); // 로그인 성공한 회원객체주소를 필드에 저장
					
					return i;
				}else{
					return -1;
				}
			}
		}
		
		return -2;
	}
	
	// 3. 아이디찾기 /////////////////////////////////////////////////////////////
	public String fineId( String name , String phone ) {
		//인덱스가 필요없으니까 향상된 for문 쓰면 됨 효율적임
		// memberDB에는 Member객체가 여러개 들어있기 때문에 Member하나씩 꺼내기 때문에 'Member'자료형 m객체변수명 을 적는것.
		for ( Member m : memberDB ) {
			if ( m.getName().equals(name) && m.getPhone().equals(phone)) {
				return m.getId(); // 조건이 일치할 경우 아이디 반환
			}
		}
		return null;
	}
	
	// 4. 비밀번호찾기 /////////////////////////////////////////////////////////////
	public String finePw( String id , String phone ) {
		for ( Member m : memberDB ) {
			if ( m.getId().equals(id) && m.getPhone().equals(phone)) {
				return m.getPw(); // 조건이 일치할 경우 비번 반환
			}
		}
		
		return null;
	}
	
	// 5. 로그아웃
	public boolean logOut() {
		
		// 필드에 저장된 로그인 성공한 회원 객체를 지우기 [ null 대입하면 GarbegeColletor가 메모리를 자동제거 ]
		// 스택은 안사라지고 힙만 지웠다 만들었다 하는것임.
		logSession = null;
				
		return true;
	}
}
