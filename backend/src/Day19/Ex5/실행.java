package Day19.Ex5;

import java.util.Scanner;

public class 실행 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Music music = new Music(); // 음악스레드
		Movie movie = new Movie(); // 영화스레드
		
		// 스레드가 start되면 다시 start못함 
		// 그래서 음악,영화 끄면 new Music / new Movie 객체 새로생성함 ( start가 없어지고, stop이 false로 초기화)
		
		// movie 와 music의 while문 yield
		
		// 스레드3가지
		// main은 안내문구 계속 실행
		// music 스레드 
		// movie 스레드
		
		while (true ) {
			System.out.print("1.음악재생/중지 2.영화재생/중지 : ");
			int ch = scanner.nextInt();
			// 만약에 1번 입력하면서 음악이 꺼져있으면 재생
			if ( ch == 1 && music.stop == false  ) {
				
				
				music.start(); // 음악스레드 시작
				music.stop = !music.stop; // 음악재생 여부 true;
				
			// 만약 1번입력하면서 음악이 켜져있으면 끄기
			}else if ( ch== 1 && music.stop == true ) {
				
				music.stop = !music.stop; //음악 재생여부 false;
				music = new Music(); // 추후 음악스레드 초기화 ( 다시 킬 수 있도록 )
				
			// 만약 2번 입력하면서 영화재생 꺼져있으면 재생
			}else if ( ch == 2 && movie.stop == false ) {
				movie.start();
				movie.stop = !movie.stop;
			
			// 만약 2번 입력하면서 영화재생 켜져있으면 끄기
			}else if ( ch== 2 && movie.stop == true ) {
				movie.stop = !movie.stop;
				movie = new Movie();
			}
		}
		
	}
	
}
