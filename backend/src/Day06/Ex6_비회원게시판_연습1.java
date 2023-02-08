package Day06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Ex6_비회원게시판_연습1 { // class start
	
	public static void main(String[] args) throws Exception { // main start
		
		// 4. 텍스트 파일 가져오기
		FileInputStream fin = new FileInputStream("C:/java/practice.txt");
		
		// 5. 1000바이트배열을 미리 생성
		byte[] finbytes = new byte[1000]; // 1000바이트 바이트배열
		
		// 5-1. 텍스트파일에서 가져온 바이트배열을 미리생성한 1000바이트배열에 저장
		//fin.read( finbytes );
		
		// 5-2 1000바이트 배열에 가져와서 데이터 외의 남는 바이트는 공백으로 출력되는 문제 해결
		// 공백을 제외한 바이트배열의 데이터 개수를 세어줌 ( int 변수명 = ) 
		int bytecount = fin.read( finbytes );
		
		// 6. 문자열로 변경
		//1000바이트배열에서 0인덱스부터 데이터가 있는 마지막 인덱스까지 문자열에 담기
		String fstr = new String ( finbytes , 0 , bytecount ); 
		System.out.println( fstr );
		
		// 7. 행 자르기 ( 행을 자르면 2개가 되니까 String배열에 저장 )
		String[] strArr1 = fstr.split("\n"); 
		
		// 8. 열 자르기 ( 행을 쪼개 저장한 String배열의 열을 쪼개려면 위의 방법에서 추가방법이 필요하다)
		// String[] strArr2 = strArr1.split(",") 
		// 위의 방법은 안됨. fstr은 문자열이어서 쪼갤수 있지만 
		// strArr1은 배열이기 때문에 데이터가 힙영역에 있다.  
		// strArr1만 호출하면 스택영역의 주소가 호출되기 때문에 데이터를 호출해서 쪼개야함.->인덱스사용
		for ( int i = 0 ; i < strArr1.length ; i++ ) {
			String[] strArr2 = strArr1[i].split(",");
			String title = strArr2[0];
			String content = strArr2[1];
			String writer = strArr2[2];
			String password = strArr2[3];
			System.out.printf("%d %10s %s \n" , i , title , writer );
		}
		
		//System.out.println(strArr2[0]); - 오류발생 
		//위의 for문을 나가면 strArr2배열은 사라짐
		
		// 9. 배열의 인덱스를 구해서 제목,작성자 문자열 선언
		
		
		
		// 입력객체
		Scanner scanner = new Scanner(System.in);
		
		// 입력받기 (제목,내용,작성자,비밀번호)
		System.out.println("제목 : ");
		String title = scanner.next();
		System.out.println("내용 : ");
		String content = scanner.next();
		System.out.println("작성자 : ");
		String writer = scanner.next();
		System.out.println("비밀번호 : ");
		String password = scanner.next();
		
		// 영구저장 , 출력 단계 
		// 1. 테이블 형식으로 만들기위해 문자열 구성 
		// 2. 윈도우텍스트파일 만들기 -> true추가해서 이어쓰게하기
		// 2-1 . 메인에 예외처리던지기 추가 //throws Exception
		// 3. 문자열을 바이트배열로 바꿔서 텍스트파일에 작성 
		// 4. 텍스트파일 가져오기 
		// 5. 1000바이트배열을 미리 생성
		// 5-1. 텍스트파일에서 가져온 바이트배열을 미리생성한 1000바이트배열에 저장
		// 5-2 1000바이트 배열에 가져와서 데이터 외의 남는 바이트는 공백으로 출력되는 문제 해결 (공백을 제외한 바이트배열의 데이터 개수를 세어줌)
		// 6. 문자열로 변경
		// 7. 행 자르기
		// 8. 열 자르기
		// 9. 배열의 인덱스를 구해서 제목,작성자 문자열 선언
		//10. 콘솔에출력
		
		
		// 1.테이블 형식으로 만들기위해 문자열 구성 (배열아님)
		String Arr1 = title+","+content+","+writer+","+password+"\n";
				
		// 2. 윈도우텍스트파일 만들기 -> true추가해서 이어쓰게하기
		FileOutputStream fout = new FileOutputStream("C:/java/practice.txt",true);
		
			// 2-1 . 메인에 예외처리던지기 추가 //throws Exception
		
		// 3. 문자열을 바이트배열로 바꿔서 텍스트파일에 작성
		fout.write( Arr1.getBytes() ); 
		
		
		
		
	} // main end

} // class end


/*
변수,연산자,반복문,배열,파일처리

	- 주의
	- c드라이브에 java폴더 생성후 java폴더안에 board.txt 이름으로 빈 메모장 생성후 작업 
 
Ex_6비회원게시판_변수/배열 버전
	- 저장 제목 , 내용 , 작성자 , 비밀번호 , 조회수
	- 초기 페이지
		-------------- 게시판 ------------------
		번호	제목		작성자 	조회수
		0	안녕4		유재석	5
		1	JAVA	강호동	1
		
		메뉴>  -1 : 쓰기  -2 : 나가기

	- 쓰기 페이지
		-------------- 게시물 작성 --------------
		제목 : 
		내용 : 
		작성자 :
		비밀번호 : 
	 

 */