package 과제.과제9.상속1;

import java.util.ArrayList;
import java.util.Scanner;

import 과제.과제9.상속1.하위클래스.믹서기;
import 과제.과제9.상속1.하위클래스.전자레인지;
import 과제.과제9.상속1.하위클래스.청소기;

public class 실행 {
	
	public static void main(String[] args) {
		
		ArrayList<주방가전> 할일목록 = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
		전자레인지 전자레인지 = new 전자레인지("아침식사 데우기");
		믹서기 믹서기 = new 믹서기("과일주스 만들기"); 
		청소기 청소기 = new 청소기("청소하기");
		
		할일목록.add(전자레인지);
		할일목록.add(믹서기);
		할일목록.add(청소기);
		
		while(true) { //할일목록에 없으면 while문 종료
					
					if ( 할일목록.size() == 0 ) { //할일목록에 없으면 while문 종료
						System.out.println("---------------------------------");
						System.out.println("[ 할일을 다했습니다! ]"); break;	}
					// 할 일을 하기전이면
					if ( 할일목록.size() == 3 ) {	 System.out.println("----------- 아침에 할 일 -----------"); }
					// 할 일을 하나라도 했으면
					if ( 할일목록.size() < 3 ) {	System.out.println("------------ 남은 할 일 ------------");}
					int i = 0;
					for ( 주방가전 o : 할일목록 ) {
						i++;
						System.out.print((i)+"."+o.할일 +" ");
						
					}
					System.out.println();
			
					System.out.println("무슨 일을 해볼까요?");
					System.out.print("번호입력 : ");
					int no = scanner.nextInt();
					System.out.println();
					
					if ( no > 할일목록.size() ) { //번호 잘못입력햇을 때
						System.out.println("- 번호를 다시 입력해주세요.");
					}else { //맞게 입력했을 때
						System.out.println("---------------------------------");
						할일목록.get(no-1).전원키기();
						할일목록.get(no-1).전원끄기();
						할일목록.remove(no-1);
					}

		}
		
	}

	
}
