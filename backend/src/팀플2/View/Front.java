package 팀플2.View;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import 팀플2.Controller.수업Controller;
import 팀플2.Controller.회원Controller;
import 팀플2.model.DbDAO;
import 팀플2.model.스케줄Dto;
import 팀플2.model.스케줄출력Dto;

public class Front {
	
	Scanner scanner = new Scanner(System.in);
	
	private static Front front = new Front();
	private Front() {	}
	public static Front getInstance() {
		return front;
		
	}
	
	public void index() {
		while ( true ) {
			System.out.println("1.관리자페이지 2.회원페이지");
			try {
				int ch = scanner.nextInt();
				if ( ch == 1 ) {	}
				else if ( ch == 2 ) { 회원_page();	}
				else { System.out.println("다시 입력해주세요");	}
			}catch (Exception e) {
				System.out.println("[예외]다시 입력해주세요");
				scanner = new Scanner(System.in);
			}
		}
	}
	
	public void 회원_page() {
		while (true) {
			System.out.println("1.로그인 2.회원가입");
			int ch = scanner.nextInt();
			if ( ch == 1 ) { 로그인_page();	}
			else if  ( ch == 2 ) {  회원가입_page();	}
		}
	}
	public void 회원가입_page() {
		
		try {
			System.out.print("아이디: "); 		String 아이디 = scanner.next(); 
	 		System.out.print("비밀번호: "); 	String 비밀번호 = scanner.next();
			System.out.print("전화번호: "); 	String 전화번호 = scanner.next();
			System.out.print("이름: "); 	String 이름 = scanner.next();
				
		int 등급 = 1;
		boolean result = 회원Controller.getInstance().회원가입(아이디, 비밀번호, 전화번호, 이름, 등급);
		if ( result ) { System.out.println("[회원가입 성공]");	}
		else { System.out.println("[회원가입 실패]");	}
		}catch (Exception e) {
			System.out.println("다시 입력해주세요");
		}
		
	}
	
	public void 로그인_page() {
		try {
			System.out.println("아이디 : "); String 아이디 = scanner.next();
			System.out.println("비밀번호 : "); String 비밀번호 = scanner.next();
			boolean result = 회원Controller.getInstance().로그인(아이디, 비밀번호);
			if ( result ) { System.out.println("[로그인 성공]"); member_Page();	}
			else { System.out.println("[로그인 실패] 다시 입력하세요.");	}
		}catch (Exception e) {
			System.out.println("[로그인 실패] 다시 입력하세요.");
		}
	}
	
	public void member_Page() {
		try {
			System.out.println("1.수업예약 2.예약내역");
			int ch = scanner.nextInt();
			if (  ch == 1 ) {  수업예약();	}
			else if ( ch == 2 ) {	}
		}catch (Exception e) {
			System.out.println("다시 입력하세요.");
			
		}
		
	}
	
	public void 수업예약() {
		전체수업목록();
	}
	
	public void 전체수업목록() {
		
		ArrayList<스케줄출력Dto> 전체스케줄 = 수업Controller.getInstance().전체수업목록();
		System.out.println("=============== 예약페이지 ===============");
		System.out.printf("%s\t|%-10s \t  |%s \t |%s\n","스케줄번호","수업일시","금액","강사");
		if ( 전체스케줄 == null ) { System.out.println("[스케줄목록 불러오기 실패]");	}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy.MM.dd aHH:mm");
		for ( 스케줄출력Dto 스케줄1개 : 전체스케줄 ) {
			String time = 스케줄1개.get수강일시().format(dtf);
			System.out.printf("%d\t|%s |%d  |%s\n",
					스케줄1개.get스케줄번호_pk(),time,스케줄1개.get금액(),스케줄1개.get이름());
			//System.out.println(스케줄1개.get스케줄번호_pk()+"\t"+스케줄1개.get수강일시().format(dtf)+"\t"+스케줄1개.get금액()+"\t"+스케줄1개.get이름());

		}
	}
	
	//관리자페이지////////////////////////////////////////////////
	public void admin_page() { /////////미완성
		System.out.println("비밀번호 : ");
		try {
			String 비밀번호 = scanner.next();
		}catch (Exception e) {
			System.out.println("[예외] 다시 입력해주세요");
		}
		
	}
	
	
	// 1. 관리자페이지 2. 회원페이지
	
	// 회원페이지
	// 1. 로그인 2.획원가입
	
	// 회원가입페이지
	
	// 로그인페이지 (일반회원)
	// 1. 수업예약 2. 예약내역
	
	// 1. 수업예약
	// 관리자가 등록한 수업목록 보여주기  원하는 수업번호를 입력하면 예약
	
	// 2. 예약내역
	// 내가 예약한 수업목록 보기
	   
	// 로그인페이지 (강사)
	// 강사의 수업목록 출력
	
	//////////////////////////////////////////////////////
	// 관리자페이지
	// 1. 수업목록보기
			// 수업수정(날짜,강사) , 수업삭제
	// 2. 수업등록 
	
	// 3. 회원삭제
	
}
