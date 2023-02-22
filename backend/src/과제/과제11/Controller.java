package 과제.과제11;

import java.net.MulticastSocket;
import java.util.ArrayList;

public class Controller {
	
	// 싱글톤
	private static Controller controller = new Controller();
	private Controller() { 	}
	public static Controller getInstance() {
		return controller;
	}
	
	// ArrayList 전역
	ArrayList<Integer> cartList = new ArrayList<>();
	ArrayList<ProductDto> 임시재고 = list();
	
	
	// 3. 제품등록 [ 인수: 이름 , 가격 , 초기재고  / 반환: ]
	boolean pRegist( String pname , int pprice , int pstock  ) {
		ProductDto dto = new ProductDto(0, pname, pprice, pstock);
		return ProductDao.getInstance().pRegist(dto);
		
	}
	
	// 4. 제품출력
	ArrayList<ProductDto> list() {
		return ProductDao.getInstance().list();
	}
	
	// 5. 제품 이름수정 [ 인수 : pno , pname , pprice / 반환 : 성공실패 ]
	boolean upDate_pname( int pno , String pname ) {
		return ProductDao.getInstance().upDate_pname(pno, pname);
	}
	
	// 5. 제품 가격수정 [ 인수 : pno , pname , pprice / 반환 : 성공실패 ]
	boolean upDate_pprice( String pname , int pprice ) {
		return ProductDao.getInstance().upDate_pprice(pname, pprice);
	}
		
	// 5. 제품 가격수정 [ 인수 : pno , pname , pprice / 반환 : 성공실패 ]
	boolean upDate_pstock( int pno , int pstock ) {
		return ProductDao.getInstance().upDate_pstock(pno, pstock);
	}
			
	// 6. 제품삭제
	boolean delete( int pno ) {
		return ProductDao.getInstance().delete(pno);
	}
	
	//////////////////////////////////////////////////////
	
	
	// 7. 결제
	int pay() {
		
		int total = 0;
		for ( int i : cartList ) {
			for ( ProductDto p : list() )
			if ( p.getPno() == i ) { total += p.getPprice();	} 
		}
		//장바구니 비우기
		cartList = new ArrayList<>();
		
		// 임시재고를 실제 DB에 반영
		ProductDao.getInstance().down_pstock(임시재고);
		
		// 임시재고를 실제DB로 반영
		임시재고 = list();
		
		return total;
	}
	
	
	// 장바구니에 담으면 임시재고 개수를 차감 , 결제시 임시재고 수량으로 DB 변경
	// 8. 장바구니 담기 [ 인수 : 제품번호 / 반환 : 성공[1] 재고부족[2] 없는제품[3]]
	int addCartList( int pno ){
		// 임시재고 차감
				for ( ProductDto p : 임시재고 ) {
					if ( p.getPno() == pno ) {
						if ( p.getPstock() > 0 ) {
							p.setPstock(p.getPstock()-1);;
						}
					}
				}
		// 장바구니에 담기
		for ( ProductDto p : 임시재고 ) { 
			//임시재고의 제품번호가 선택한 제품번호와 같으면
			if ( p.getPno() == pno ) {	
					//선택한 제품의 재고가 0보다 크면
					if ( p.getPstock() > 0 ) {
						cartList.add(pno);
						//System.out.println("장바구니ArrayList : ");
						System.out.println("장바구니ArrayList : "+cartList);
						return 1; //장바구니성공
					//선택한 제품의 재고가 0보다 크지 않으면
					}else { return 2;} //재고없음
			// 임시재고의 제품번호가 선택한 제품번호와 같지 않으면
			}  
		}
		
		return 3; // 없는제품
	}
	
	// 9. 장바구니 개수 출력
	int cartCount() {
		
		return cartList.size();
	}
	
	// 10. 결제취소시 임시재고 리셋 , 장바구니 리셋
	void cancel() {
		
		임시재고 = list();
		System.out.println(임시재고.toString());
		cartList = new ArrayList<>();
	}
	
	
}
