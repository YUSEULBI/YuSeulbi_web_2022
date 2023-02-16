package 과제.과제8;

public class 파운데이션 extends 화장품 {

	// 1. 필드
		int 호수;
		String 제형;
		
	// 2. 생성자
	//빈생성자
	public 파운데이션() { 	}

	
		
	//풀생성자
	public 파운데이션(String 제품명, int 가격 , int 호수 , String 제형) {
			super(제품명, 가격);
			this.호수 = 호수;
			this.제형 = 제형;
		}



		// 3. 메소드
		@Override
			void 등록(화장품 제품) {
				
				파운데이션 파운데이션제품 = (파운데이션)제품;//강제형변환
				if ( 파운데이션제품.제형 != null && 파운데이션제품.호수 != 0 ) { 	
					super.등록(제품);
				}else { System.out.println("제품등록실패-파운데이션필드");	}
				
				
			}
		
		
		@Override
		void 상세보기() {
			super.상세보기();
			System.out.println("제형 : "+제형);
			System.out.println("호수 : "+호수);
		}



			@Override
		public String toString() {
			return "파운데이션 [호수=" + 호수 + ", 제형=" + 제형 + "]";
		}



			



			public int get호수() {
				return 호수;
			}



			public void set호수(int 호수) {
				this.호수 = 호수;
			}



			public String get제형() {
				return 제형;
			}



			public void set제형(String 제형) {
				this.제형 = 제형;
			}



			
			
			
			
			
		
}
