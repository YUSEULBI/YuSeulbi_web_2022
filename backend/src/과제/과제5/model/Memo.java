package 과제.과제5.model;

public class Memo { // 단방향 : 메모리효율 속도 좀더 좋은데 양뱡향과 크게 차이없음 ( 리스트가없으면 단방향 ) 데이터가많으면 단방향
	
	// 관계필드 = 참조필드 [ fk ]
	private int formmno; // 쪽지보낸 회원번호
		// 받는사람 product
	
	// 관계필드 = 식별용 [ pk ]
	private int mono; 	// 쪽지번호
	
		
}
