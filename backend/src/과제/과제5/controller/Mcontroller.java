package 과제.과제5.controller;

import java.util.ArrayList;

import 과제.과제5.model.Member;
import 과제.과제5.model.Memo;
import 과제.과제5.model.Product;

public class Mcontroller {// 객체 1개만 써도 됨 싱글톤

	//싱글톤
	// 직접접근 막기위해서
	private static Mcontroller mc = new Mcontroller();
	private Mcontroller() {	}
	// 외부에서 객체를 생성해서 클래스를 호출할 수 없기 때문에 정적메소드로 바로 호출하도록
	public static Mcontroller getInstance() {
		return mc;
	}
	
	// Member DB 역할
	private ArrayList<Member> memberDB = new ArrayList<>(); 
	
	// Memo DB역할
	private ArrayList<Memo> memoDB = new ArrayList<>();
	public ArrayList<Memo> getMemoDB () {
		return memoDB;
	}
	
	//logSession
	private Integer logSession = -1;
	public Integer getLogSession() {
		return logSession;
	}
	
	private ArrayList<Integer> idnumList = new ArrayList<>();
	
	// 1. 회원가입 / 인수: id , pw	반환 : true false
	public boolean signUp ( String id , String pw , String confirmPw , String phone  ){
		
		if ( !pw.equals(confirmPw)) { return false; }
		
		int idnum = 0;
		
		for( int i : idnumList ) {
			if( i == idnum ){
				idnum++;
			}
		}
		// 객체에 담기
		Member member = new Member(idnum, id, confirmPw, phone);
		//DB에 저장
		memberDB.add(member);
		return true;
	}
	
	// 2. 로그인 / 인수: id , pw	반환 : true false
	public boolean logIn( String id , String pw ){
		for ( Member m : memberDB ) {
			if ( m.getId().equals(id) ) {
				if ( m.getPw().equals(pw)) {
					//Member logSession = 멤버객체
					logSession = m.getMno();
					return true;
				}
			}
		}
		
		return false;
	}	
	
		
	// 3. 로그아웃 인수X 반환 true;
	public boolean logOut(){
		logSession = -1;
		return true;
	}
	
	// 4. 내가등록한 제품반환 // 인수X 	반환 내가등록한제품 productList 또는 null 
	public ArrayList<Product> myProduct(){
		ArrayList<Product> myPList = new ArrayList<>();
		for ( Product p : Pcontroller.getInstance().getProductDB() ) {
			if ( p.getMno() == logSession ) {
				myProduct().add(p);
				return myProduct();
			}
		}
		return null;
	}
	// ProductDB에서 for문
	
	// 5. 내가보낸쪽지 반환 // 인수X	반환 쪽지리스트의 보낸사람.equls( 로그인한사람 )인 쪽지객체만 반환 
		public ArrayList<Memo> mySendM(){
			ArrayList<Memo> sendMemo = new ArrayList<>();
			for ( Memo m : memoDB ) {
				if ( m.getFrommno() == logSession ) {
					sendMemo.add(m);
				}
				
			}
			return sendMemo;
			
		}
	
	//6. 받은쪽지 반환 // 인수X	반환 쪽지리스트의 받은사람.equls( 로그인한사람 )인 쪽지객체만 반환 	
		public ArrayList<Memo> myReceiM(){
			ArrayList<Memo> receiMemo = new ArrayList<>();
			for ( Memo m : memoDB ) {
				if ( m.getPno() == logSession ) {
					receiMemo.add(m);
				}
			}
			return receiMemo; 
		}

	
 
		
}


