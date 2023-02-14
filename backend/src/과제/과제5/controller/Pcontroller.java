package 과제.과제5.controller;

import java.util.ArrayList;

import 과제.과제5.model.Memo;
import 과제.과제5.model.Product;

public class Pcontroller { // 객체 1개만 써도 됨 싱글톤
	
	//싱글톤
	private static Pcontroller pc = new Pcontroller();
	private Pcontroller() { 	}
	public static Pcontroller getInstance() {
		return pc;
	}
	
	private ArrayList<Product> productDB = new ArrayList<>();
	public ArrayList<Product> getProductDB (){
		return productDB;
	}
	
	private ArrayList<Integer> pnoList = new ArrayList<>();
	
	//1. [등록]제품등록 처리
	// 제품객체 DB저장 + 내가등록한제품 리스트에 제품객체 저장
	// 인수: 제품이름,내용		반환 :  true판매중 false판매완료
	public boolean regist( String title , String content , String price ){
		int mno = Mcontroller.getInstance().getLogSession();
		int pno = 0;
		for ( int i : pnoList ) {
			if ( i == pno ) {
				pno++;
			}
		}
		Product product = new Product(mno, pno, title, content, price, true);
		productDB.add(product);
		return true;
	}
	
	//2. [출력]등록된 모든제품을 반환  // 인수X	DB반환  
	public ArrayList <Product> pPrint(){
		
		return productDB;
	}
	
	// 3. [상세] 선택한 제품 반환 // 인수 제품번호 / 반환 : DB에서 선택한 제품객체 
	public Product pView( int pno ){
		for ( Product p : productDB ) {
			if ( p.getPno() == pno ) {
				return p;
			}
		}
		return null;
	}
	
	//4. 쪽지보내기 처리 // 인수 제품번호 , 쪽지내용 	반환 : true false
	// DB에서 선택한 제품의 멤버객체 조회
	// 입력받은 쪽지내용과 , 제품객체 , 보낸사람(로그인한사람)
	// memoDB에 add
	public boolean send ( int pno , String content ){
		//
		int frommno = Mcontroller.getInstance().getLogSession();
		//
		int meno = 0;
		for ( Memo m : Mcontroller.getInstance().getMemoDB() ) {
			if ( m.getMeno() == meno ) {
				meno++;
			}
		}
		//
		for ( Product p : productDB ) {
			if ( p.getPno() == pno ) {
				
				Memo memo = new Memo(frommno, pno, meno, content);
				Mcontroller.getInstance().getMemoDB().add(memo);
				return true;
			}
			
		}	
		return false;
	}
	


} // class end
