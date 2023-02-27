package Day19.Ex3;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex1_p604 {

	public static void main(String[] args) {
		
		// 1. 
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		for ( int i = 0 ; i < 10 ; i++ ) {
//			toolkit.beep(); // 비프음 내기
//			try {
//				Thread.sleep(3000); // 3초간 해당 스레드 일시정지 [ 3초간 CPU에게 자원안받기(점유불가) ]
//			}catch (Exception e) {
//				// TODO: handle exception
//			}
//		} //for end
		
		// 2.
		/*
		 * int i = 0; while(true) { Date date = new Date(); // 날짜 시간 SimpleDateFormat
		 * sdf = new SimpleDateFormat("hh:mm:ss"); // 날짜/시간 꾸미기 [형식] 클래스
		 * System.out.println(sdf.format(date)); i++;
		 * 
		 * System.out.println( i +"초"); try { Thread.sleep(1000); // 1초간 일시정지 }catch
		 * (Exception e) { } for( int s = 0 ; s<100 ; s++ ) {System.out.println();} //
		 * 100줄 공백만들기 }
		 */
		
		// 3.
//		SumThread sumThread = new SumThread();
//		sumThread.start();
//		System.out.println(sumThread.getSum());
		
		SumThread sumThread = new SumThread();
		sumThread.start();
		try {
			sumThread.join();// 계산이 끝날때까지 다른스레드 wait
		}catch (Exception e) {
			
		}
		System.out.println( sumThread.getSum() );
		
		
		
	} //main end	
	
}
