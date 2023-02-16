package 과제.과제8;

public class 화장품서비스 {
	
	void 등록 ( 화장품 제품 ) {
		
		if ( 제품.가격 != 0 && 제품.제품명 != null ) {
			Front.getInstance().화장품DB.add(제품);
			System.out.println("제품등록성공");
		}else { System.out.println("제품등록실패-슈퍼클래스");	}
		
	}
	
	void 상세보기() {
		화장품 제품 = (화장품)this;
		System.out.println( 제품.제품명 );
		System.out.println( 제품.가격 );
	}
	
}
	