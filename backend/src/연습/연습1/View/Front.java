package 연습.연습1.View;


import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.jdbc.SuspendableXAConnection;

import 연습.연습1.Controller.수업Controller;
import 연습.연습1.Controller.회원Controller;
import 연습.연습1.model.강사스케줄출력dto;
import 연습.연습1.model.스케줄출력Dto;
import 연습.연습1.model.예약내역Dto;
import 연습.연습1.model.회원Dao;
import 연습.연습1.model.회원Dto;



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
				if ( ch == 1 ) { 관리자로그인_page();	}
				else if ( ch == 2 ) { 회원_page();	}
				else { System.out.println("다시 입력해주세요");	}
			}catch (Exception e) {
				System.out.println("[예외] 잘못된 입력형식 입니다.");
				scanner = new Scanner(System.in);
			}
		}
	}
	
	public void 회원_page() {
		while (true) {
			System.out.println("1.로그인 2.회원가입");
			int ch = scanner.nextInt();
			if ( ch == 1 ) { 로그인_page();	}
			else if  ( ch == 2 ) {  회원가입_page(1);	}
		}
	}
	
	// 회원,강사 회원가입 ( 회원-회원페이지 / 강사-관리자페이지 에서등록 )
	public void 회원가입_page( int 등급 ) {
		
		try {
			System.out.print("아이디: "); 		String 아이디 = scanner.next(); 
	 		System.out.print("비밀번호: "); 	String 비밀번호 = scanner.next();
			System.out.print("전화번호: "); 	String 전화번호 = scanner.next();
			System.out.print("이름: "); 	String 이름 = scanner.next();
				
		
		boolean result = 회원Controller.getInstance().회원가입(아이디, 비밀번호, 전화번호, 이름, 등급);
		if ( result ) { System.out.println("[회원가입 성공]");	}
		else { System.out.println("[회원가입 실패]");	}
		}catch (Exception e) {
			System.out.println("[예외] 잘못된 입력형식 입니다.");
			scanner = new Scanner(System.in);
		}
		
	}
	
	public void 로그인_page() {
		try {
			System.out.println("아이디 : "); String 아이디 = scanner.next();
			System.out.println("비밀번호 : "); String 비밀번호 = scanner.next();
			int result = 회원Controller.getInstance().로그인(아이디, 비밀번호);
			if ( result == 1 ) { System.out.println("[회원 로그인 성공]"); member_Page();	}
			else if (result == 2 ) { System.out.println("[강사 로그인 성공]"); teacher_page();	}
			else { System.out.println("[로그인 실패] 다시 입력하세요.");	}
		}catch (Exception e) {
			System.out.println("[로그인 실패] [예외] 잘못된 입력형식 입니다.");
			scanner = new Scanner(System.in);
		}
	}
	
	public void teacher_page() {
		
		ArrayList<강사스케줄출력dto> 강사스케줄리스트 = 수업Controller.getInstance().강사스케줄출력();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy.MM.dd aHH:mm");
		System.out.println("=============== 강사 스케줄 ===============");
		System.out.printf("%s\t%s\t%-10s\n","강사명","스케줄번호","수강일시");
		for ( 강사스케줄출력dto dto : 강사스케줄리스트 ) {
			String time = dto.get수강일시().format(dtf);
			System.out.printf("%s\t%s\t%-10s\n",dto.get강사(),dto.get스케줄번호_pk(),time);
		}
		System.out.println("========================================");
	}
	
	public void member_Page() {
		
		while ( true ) {
			System.out.println("=============== 회원 페이지 ===============");
			try {
				System.out.println("1.수업예약(유효성검사추후에) 2.예약내역 3.수강취소");
				int ch = scanner.nextInt();
				if (  ch == 1 ) {  수업예약();	}
				else if ( ch == 2 ) { 예약내역 ();	}
				else if ( ch == 3 ) { 수강취소();	}
			}catch (Exception e) {
				System.out.println("[예외] 잘못된 입력형식 입니다.");
				scanner = new Scanner(System.in);
				
			}
		}
		
	}
	
	public void 수강취소() {
		System.out.println("=============== 예약 취소 ===============");
		예약내역();
		System.out.println("취소하실 수업의 수강내역번호를 입력하세요.");
		try {
			int no = scanner.nextInt();
			boolean result = 수업Controller.getInstance().수강취소(no);
			if ( result ) {	System.out.println("[예약이 취소되었습니다.]");}
			else { System.out.println("[예약취소실패 - 관리자문의 ]");}
		}catch (Exception e) {
			System.out.println("[예외] 잘못된 입력형식 입니다.");
			scanner = new Scanner(System.in);
		}
		
	}
	
	public void 수업예약() {
		System.out.println("=============== 예약페이지 ===============");
		전체수업목록();
		System.out.println("스케줄번호를 선택하시면 예약이 됩니다.");
		try {
			int sc = scanner.nextInt();
			예약( sc );
		}catch (Exception e) {
			System.out.println("[예외] 잘못된 입력형식 입니다.");
			scanner = new Scanner(System.in);
		}
	}
	
	
	public void 전체수업목록() {
		
		ArrayList<스케줄출력Dto> 전체스케줄 = 수업Controller.getInstance().전체수업목록();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy.MM.dd aHH:mm");
		
		System.out.printf("%s\t|%-10s \t  |%s \t |%s\n","스케줄번호","수업일시","금액","강사");
		if ( 전체스케줄 == null ) { System.out.println("[스케줄목록 불러오기 실패]");	}
		for ( 스케줄출력Dto 스케줄1개 : 전체스케줄 ) {
			String time = 스케줄1개.get수강일시().format(dtf);
			System.out.printf("%d\t|%s |%d  |%s\n",
					스케줄1개.get스케줄번호_pk(),time,스케줄1개.get금액(),스케줄1개.get이름());
			//System.out.println(스케줄1개.get스케줄번호_pk()+"\t"+스케줄1개.get수강일시().format(dtf)+"\t"+스케줄1개.get금액()+"\t"+스케줄1개.get이름());

		}
	}
	
	public void 예약( int sc ) {
		
		ArrayList<스케줄출력Dto> 전체스케줄 = 수업Controller.getInstance().전체수업목록();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy.MM.dd aHH:mm");
		
		System.out.println("=============== 선택한 스케줄 ===============");
		System.out.println("["+sc + "번 수업을 선택하셨습니다.]");
		String time = 전체스케줄.get(sc-1).get수강일시().format(dtf);
		System.out.println("일시 : " + time);
		int num = 전체스케줄.get(sc-1).get금액();
		DecimalFormat df = new DecimalFormat("#,##0원");
		System.out.println("강사 : " + 전체스케줄.get(sc-1).get이름()+" 강사");
		System.out.println("금액 : " + df.format(num) );
		
		System.out.println("========================================");
		System.out.println("수강하시겠습니까? [ 1.예 / 2.아니오 ]");
		try {
			
			int ch = scanner.nextInt();
			if ( ch == 1 ) { 예약처리( sc );	}
			else if ( ch == 2 ) { return; }
		}catch (Exception e) {
			System.out.println("[예외] 잘못된 입력형식 입니다.");
			scanner = new Scanner(System.in);
		}
	}
	
	public void 예약처리( int sc ) {
		boolean result = 수업Controller.getInstance().예약처리(sc);
		if ( result ) { System.out.println("[수강신청이 완료되었습니다.]");	}
		else { System.out.println("[수강신청 실패 - 관리자문의]");	}
	}
	
	// 예약내역조회
	public void 예약내역 () {
		ArrayList<예약내역Dto> 예약내역리스트 = 수업Controller.getInstance().예약내역();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy.MM.dd aHH:mm");
		DecimalFormat df = new DecimalFormat("#,##0원");
		System.out.println("========================================");
		System.out.printf("%s\t%-20s\t%s\t%s\n","수강내역번호","수강일시","강사","금액");
		for ( 예약내역Dto dto : 예약내역리스트 ) {
			String time = dto.get수강일시().format(dtf);
			int num = dto.get금액();
			System.out.printf("%s\t%s\t%s\t%s\n",dto.get수강내역번호(),time,dto.get강사(),df.format(num));
			
		}
		System.out.println("========================================");
	}
	
	
	//관리자페이지////////////////////////////////////////////////
	
	
	public void 관리자로그인_page() {
		System.out.println("관리자 비밀번호 : ");
		try {
			String pw =  scanner.next();
			boolean result = 회원Controller.getInstance().관리자로그인(pw);
			if ( result ) { System.out.println("[ 관리자 로그인 성공 ]"); 관리자_page();	}
			else { System.out.println("[ 관리자 로그인 실패 ]");	}
		}catch (Exception e) {
			System.out.println("[예외] 관리자 로그인 실패 ");
			scanner = new Scanner(System.in);
		}
	}
	
	public void 관리자_page() {
		while(true) {
			System.out.println("=============== 관리자 페이지 ===============");
			System.out.print("[ 1.전체수업목록 2.강사조회 3.회원조회 4.수업등록 5.강사등록 ] 번호입력 : ");
			try {
				int ch = scanner.nextInt();
				if ( ch == 1 ) { 
					System.out.println("=============== 전체수업목록 ==============="); 
					전체수업목록();
					System.out.println();}
				
				else if ( ch == 2 ) { 회원조회(2);	}
				else if ( ch == 3 ) { 회원조회(1);	}
				else if ( ch == 4 ) { 수업등록();	}
				else if ( ch == 5 ) { 회원가입_page(2);	}
			}catch (Exception e) {
				System.out.println("[예외] 잘못된 입력형식 입니다.");
				scanner = new Scanner(System.in);
			}
		}
		
	}
	
	public void 회원조회( int 등급 ) {
		System.out.println("=============== 강사조회 ===============");
		System.out.printf("%s\t%s\t%s\t%-10s\t%s\n","회원번호","아이디","비밀번호","전화번호","이름");
		ArrayList<회원Dto> 강사리스트 = 회원Dao.getInstance().회원조회(등급);
		for ( 회원Dto d : 강사리스트 ) {
			System.out.printf("%s\t%s\t%s\t%s\t%s\n",d.get회원번호_pk(),d.get아이디(),d.get비밀번호(),d.get전화번호(),d.get이름());
		}
	}
	
	
	
	public void 수업등록() {
		System.out.println("=============== 수업등록 ===============");
		try {
			//강사여야 등록가능하도록 유효성검사 필요
			System.out.print("금액 : "); int 금액 = scanner.nextInt();
			System.out.print("강사번호 : "); int 강사번호 = scanner.nextInt();
			
			//연도,월,일,시,분
			System.out.print("연도 : "); int year = scanner.nextInt();
			System.out.print("월 : "); int month = scanner.nextInt();
			System.out.print("일 : "); int day = scanner.nextInt();
			System.out.print("시 : "); int hour = scanner.nextInt();
			System.out.print("분 : "); int minute = scanner.nextInt();
			
			LocalDateTime time = LocalDateTime.of(year, month, day, hour, minute);
			System.out.println( time );
			boolean result = 수업Controller.getInstance().수업등록(time, 금액, 강사번호);
			if ( result ) { System.out.println("[수업등록 성공]");	}
			else { System.out.println("[수업등록 실패]");	}
			
		}catch (Exception e) {
			System.out.println("[예외] 잘못된 입력형식 입니다.");
			scanner = new Scanner(System.in);
		}
		
		
	}
	// 1. 관리자페이지 2. 회원페이지
	
	// 회원페이지
	// 1. 로그인 2.회원가입(일반회원)
	
	// 회원가입페이지
	
	// 로그인페이지 (일반회원)
	// 1. 수업예약 2. 예약내역
	
	// 1. 수업예약
	// 관리자가 등록한 수업목록 보여주기  원하는 수업번호를 입력하면 예약
	
	// 2. 예약내역
	// 내가 예약한 수업목록 보기
	
	// 2-1. 예약취소
	   
	// 로그인페이지 (강사)
	// 강사의 수업목록 출력
	
	//////////////////////////////////////////////////////
	// 관리자페이지
	// 1. 수업목록보기
			// 수업수정(날짜,강사) , 수업삭제
	// 2. 수업등록 
	
	// 3. 강사등록
	
	// 회원수정삭제는 필요없을 것 같음. (수강권등록기능이 없어서)
	
}
