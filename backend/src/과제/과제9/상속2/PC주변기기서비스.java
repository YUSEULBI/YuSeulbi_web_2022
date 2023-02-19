package 과제.과제9.상속2;

import java.util.ArrayList;

public class PC주변기기서비스 {
	
	void regist() {
		PC주변기기 제품 = (PC주변기기)this;
		if ( ( 제품.get제품명() == null ) && 
				( 제품.get제품가격() <= 0 ) && 
					( 제품.get연결방식() == null ) ){
			System.out.println("-입력이 잘못되었습니다.");
		}else {
			ArrayList<PC주변기기> 리스트 = Controller.getInstance().getProductDB();
			if ( 리스트.size() == 0 ) { 제품.setPno(1);	}
			else {
				제품.setPno((리스트.get(리스트.size()-1).getPno())+1); // 새등록제품pno는 DB리스트의 마지막제품의 pno+1
			}
			Controller.getInstance().getProductDB().add(제품);
			System.out.println("-제품이 등록되었습니다.");
		}
		
	}
	
	
	
}
