package 과제.과제3;

import java.util.ArrayList;

public class Member {
	
	String id;
	String password;
	String name;
	String phone;
	ArrayList<Book> rentList = new ArrayList<>();
	
}

/*

- 추가 요구사항 
아이디 , 비밀번호 , 이름 , 전화번호 , 대여도서목록
1. 회원제 변경 [ Member 클래스  추가 ] 
	1. 초기메뉴 : 1.로그인 2.회원가입
2. 로그인 성공시 도서 초기 메뉴 
3. 도서대여시 도서객체에 대여한 회원 아이디 등록 , 회원 객체에 대여한 도서목록

*/