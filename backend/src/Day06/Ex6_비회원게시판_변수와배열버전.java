package Day06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Ex6_비회원게시판_변수와배열버전 { // class start

	public static void main(String[] args) throws Exception { // main start // 예외처리 던지기
		
		// 입력객체
		Scanner scanner = new Scanner(System.in);
		
		// 배열
		
		
		while ( true ) {
			
			// 2. 파일에 있는 모든 문자열 가지고 오기
			
				//1. 파일입력 클래스 객체 생성
				FileInputStream fin = new FileInputStream("c:/java/board.txt");
			
				// 2. 읽어온 바이트를 저장하기 위해 1000바이트 배열을 미리 생성
				byte[] inbytes = new byte[ 1000 ]; // 바이트 기준 영문1바이트 한글3바이트 특수문자1바이트
			
				// 3. .read() 메소드를 이용한 파일읽기 [ * 읽은 바이트를 바이트배열에 저장 ]
					// inbytes : 읽어온 바이트 배열 저장
					// bytecount : 읽어온 바이트 개수
				
				// 1000바이트중에 남는바이트는 공백으로 출력되는 문제해결
				int bytecount = fin.read( inbytes ); // 스트림 : 바이트단위 // 읽어온 바이트를 바이트배열에 저장 //int는 읽어온 바이트 개수 세는 것
				
				// 4. 바이트배열 ---> 문자열
					// new String("유재석")
					// new String( 바이트배열 ); new String( 바이트배열 , 시작인덱스 , 마지막인덱스 ); 원하는 인덱스만큼
				String fStr = new String( inbytes , 0 , bytecount ); // 시작인덱스 ~ bytecount인덱스
				
				// 자르기 전
				// fStr = "안녕하세요,자바글쓰기,유재석,1234\n안녕하세요,호호호호,강호동,4567\n"

				
				// 5. 문자열분리
					// 행자르기
				String[] boards = fStr.split("\n"); 	// 행 기준으로 분리 // 배열에 담기 
					// boards = {"안녕하세요,자바글쓰기,유재석,1234" , "안녕하세요,호호호호,강호동,4567"}
				
					// 열자르기
							//[만약에 게시물2개일때는 \n때문에 3조각 인데 마지막인덱스는 공백이 나온다면 .length-1]
							// 지금은 위에서 공백없애면서 사라짐 그대로 length
				System.out.println("------------게시물목록--------------");
				System.out.printf(" %2s %10s %5s \n" , "번호" , "제목" , "작성자" );
				
				for ( int i = 0 ; i<boards.length ; i++ ) {
					
					// 게시물 마다 열 자르기
					String[] cols = boards[i].split(","); // 4조각으로 쪼개져서 배열에 저장
					String title = cols[0];
					String content = cols[1];
					String writer = cols[2];
					String password = cols[3];
					System.out.printf(" %2d %10s %5s \n" , i , title , writer );
				}
				System.out.println("---------------------------------");
				/*
				  for i = 0 일때 - boards[0]
				  	cols = {"안녕하세요","자바글쓰기","유재석","1234" }
				  
				  for i = 1 일때 - boards[1]
				  	cols = {"안녕하세요","호호호호","강호동","4567" }
				  	
				 * 
				 */
			
			// 초기페이지
			/*
			 * System.out.println("-----------------게시판-----------------\n" +
			 * "번호	제목		작성자	조회수\n");
			 */
			
			System.out.println("[메뉴번호] 게시물보기[보류] 글쓰기[-1] 나가기[-1] ");
			System.out.println(">>>번호를 입력하세요");
			int num = scanner.nextInt();
			
			if ( num == -1 ) {
				System.out.println("-------------게시물 작성---------------");
				
				System.out.println("제목 : ");
				String title = scanner.next();
				
				System.out.println("내용 : ");
				String content = scanner.next();
				
				System.out.println("작성자 : ");
				String writer = scanner.next();
				
				System.out.println("비밀번호 : ");
				String password = scanner.next();
				
				// , : 열 구분선[데이터구분]  \n : 행 구분선[게시물구분]
				String outstr = title+","+content+","+writer+","+password+"\n"; 
				
				// 1. 파일처리 [ 클래스 ] ("파일경로",true)
				FileOutputStream fout = new FileOutputStream("c:/java/board.txt",true); //true있으면 파일 안만들어짐
				fout.write(outstr.getBytes());
				
				
			//나가기
			} else if ( num == -2 ) {
				break;
			}
			
		}
		
	} // main end
	
} // class end
