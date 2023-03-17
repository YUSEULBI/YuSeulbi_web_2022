package controller.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dao.MemberDao;
import model.dto.BoardDto;
import model.dto.PageDto;

/**
 * Servlet implementation class Boardinfo
 */
@WebServlet("/board/info")
public class Boardinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Boardinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int type = Integer.parseInt(request.getParameter("type"));
		if ( type == 1 ) { // 전체출력
			// --------카테고리별 출력 ------------------
			// 1. 카테고리 매개변수 요청 [ cno ] 2. getTotalSize / getBoardList
			int cno = Integer.parseInt(request.getParameter("cno"));
			
			
			// -------------검색처리
			// 1. 검색에 필요한 매개변수 요청 [ key , keyword ]
			// 2. getTotalSize , getBoardList 조건전달
			String key = request.getParameter("key");			System.out.println("key : "+key);
			String keyword = request.getParameter("keyword");	System.out.println("keyword : "+keyword);
			
			// ------------ page 처리 계산
			// 1. 현재페이지[요청] , 2.페이지당 게시물수 , 3. 현재페이지[게시물시작 , 게시물끝]
			int page = Integer.parseInt(request.getParameter("page"));
			System.out.println("page : "+page);
			// 페이지당 게시물수
			int listsize = Integer.parseInt(request.getParameter("listsize"));
			// 선택페이지 첫 게시물번호
			int startrow = (page-1)*listsize; 
			
			// --------------------page 버튼만들기 //
			// 1. 전체페이지수[총레코드수/페이지당표시된수] 2. 페이지 표시할 최대버튼수 3. 시작버튼 번호
				// 전체 게시물수 레코드수
					//검색없을때
				// int totalsize = BoardDao.getInstance().getTotalSize();
					// 검색있을때
			int totalsize = BoardDao.getInstance().getTotalSize( key , keyword , cno );
				// 페이지수
				int totalpage = totalsize % listsize == 0 ? // 나머지가 0이면
					totalsize/listsize : // 몫 
						totalsize/listsize+1; // 나머지가 있으면 +1
			
			// 2. 페이지당 최대버튼수
			int btnsize = 5;
			
			int startbtn = ( (page-1)/btnsize ) *btnsize+1;
				/*	btn size = 5
				 * 	시작번호 패턴 : 1	6	11	16	21
				 	1페이지 : 1-1 / 5  	몫0 *5 + 1 			1
				 	2페이지 : 2-1 / 5 		몫0 *5 + 1			1
				 	3페이지 : 3-1 / 5 		몫0 *5 + 1			1
				 	4페이지 : 4-1 / 5 		몫0 *5 + 1			1
				 	5페이지 : 5-1 / 5 		몫0 *5 + 1			1
				 	6페이지 : 6-1 / 5 		몫1 *5 + 1			6
				 	7페이지 : 7-1 / 5 		몫1 *5 + 1			6
				 	8페이지 : 8-1 / 5 		몫1 *5 + 1			6
				 	9페이지 : 9-1 / 5 		몫1 *5 + 1			6
				 	10페이지 : 10-1 / 5	몫1 *5 + 1			6
				 	11페이지 : 11-1 / 5 	몫2 *5 + 1			11
				 
				 */
				
			int endbtn = startbtn + (btnsize-1);
			// * 단 마지막페이지버튼수가 총 페이지수보다 커지면 안됨 -> 마지막버튼수가 커지면 마지막버튼수를 총페이지수로 대입
			if ( endbtn > totalpage ) { endbtn = totalpage; }
			
			// 검색없을때
			// ArrayList<BoardDto> result = BoardDao.getInstance().getBoardList(startrow ,listsize);
			ArrayList<BoardDto> result = BoardDao.getInstance().getBoardList(startrow ,listsize, key , keyword , cno);
			
			PageDto pagedto = new PageDto(page, listsize, startrow, totalsize, totalpage, btnsize, startbtn, endbtn, result);
			
					/*
					 	총 게시물 수 = 10 , 페이지당 표시할 게시물수 = 3
					 	1. 총 페이지수 = 10/3%+1 / 123 , 456 , 789 , 10
					 			총레코드수/페이지당표시게시물수
					 				1. 나머지가 없으면 몫만사용		9/3 -> 3페이지
					 				2. 나머지가 있으면 몫 + 1		10/3 -> 4페이지
					 	총레코드수 = 10 총레코드의 인덱수 0~9
					 	
						2. 페이지별 게시물시작 번호 찾기
								1. 페이지 요청 -> (1-1)*3 => 0
								2. 페이지 요청 -> (2-1)*3 => 3
								3. 페이지 요청 -> (3-1)*3 => 6
						3. 시작버튼 , 마지막버튼 수
							 
							1페이지 -> 12345
							2페이지 -> 12345
							3페이지 -> 12345
							4페이지 -> 12345
							5페이지 -> 12345
							6페이지 -> 678910
							7페이지 -> 111213
 
					 */
			 
			
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonlist = mapper.writeValueAsString(pagedto);
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print(jsonlist);
			
			
		}else if (type == 2) { // 개별출력
			int bno =  Integer.parseInt(request.getParameter("bno"));
			System.out.println("bno : " + bno);
			// Dao
			BoardDto dto = BoardDao.getInstance().getBoard(bno);
			System.out.println("dto : " + dto);
			// 형변환
			ObjectMapper mapper = new ObjectMapper();
			String jsondto = mapper.writeValueAsString(dto);
			System.out.println("jsondto : " + jsondto);
			// 응답
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print(jsondto);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 업로드
		// 1. 업로드할 파일의 저장 위치 [ 경로 ]
			// 클라이언트[유저] ----X----> git[내프로젝트]
			//            ---------> 서버[배포된프로젝트]
		String uploadpath = request.getSession().getServletContext().getRealPath("/board/bfile");
			System.out.println("uploadpath : " + uploadpath);
			
			// * 업로드 [ 파일이동 : 유저파일 -> 서버폴더내 이동 ]
		//파일복사 [ 입력받은 file 대용량 바이트 복사하기 ]
 		MultipartRequest multi = new MultipartRequest(
				request, 		// 1. 요청방식
				uploadpath,		// 2. 첨부파일 가져와서 저장할 서버내 폴더
				1024*1024 *10 ,	// 3. 첨부파일 허용 범위 용량 [ 바이트단위 ]
				"UTF-8" ,		// 4. 첨부파일 한글 인코딩
				new DefaultFileRenamePolicy() // 5. 동일한 첨부파일명이 있으면 뒤에 숫자 붙여서 식별
		);
		System.out.println("multi : "+multi);
		
		// form 전송은 form 하위 name명
		// .getParameter 값을 가져옴
 		int cno = Integer.parseInt(multi.getParameter("cno"));	System.out.println("cno : "+cno);
 		String btitle = multi.getParameter("btitle");			System.out.println("btitle : "+btitle);
 		String bcontent = multi.getParameter("bcontent");		System.out.println("bcontent : "+bcontent);
 		
 		// 첨부파일의 파일명만 호출 [ .getFilesystemName ]
 		String bfile = multi.getFilesystemName("bfile");		System.out.println("bfile : "+bfile);
 		
 		// mid 호출
 		String mid = (String)request.getSession().getAttribute("login");
 		System.out.println("mid : "+ mid);
 		
 		// MemberDao에서 mid를 mno로 바꿔서 받기
 		int mno = MemberDao.getInstance().getMno(mid);
 		// 만약에 회원번호가 존재하지 않으면 글쓰기 불가 유효성검사
 		if ( mno < 1 ) { response.getWriter().print(false); }
 		System.out.println("mno : "+ mno);
 		//dto
 		BoardDto dto = new BoardDto(btitle, bcontent, bfile, mno, cno);
 		System.out.println("dto : "+ dto); //BoardDto클래스에 toString 오버라이드하면 dto안의 객체값을 볼수 있음/ 원래는 주소값이 나옴
 		
 		//dao
 		boolean result = BoardDao.getInstance().bwrite(dto);
 		System.out.println("result : "+result);
 		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//업로드
		String path = request.getSession().getServletContext().getRealPath("/board/bfile");
		MultipartRequest multi = new MultipartRequest(
				request, path , 1024*1024*10 , "UTF-8" , new DefaultFileRenamePolicy()
				);
		
		// 정보
		int bno = Integer.parseInt(multi.getParameter("bno"));
		int cno = Integer.parseInt(multi.getParameter("cno"));
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		
		/* 첨부파일의 수정 경우의수
			// 1. 기존 첨부파일이 없었다. 	--> 새로운 첨부파일 X
			 						--> 새로운 첨부파일 O [ 업로드 DB처리 ]
			 
			// 2. 기존 첨부파일이 있었다. 	--> 새로운 첨부파일 X [ 기존파일명으로 업데이트 처리(그대로사용) ]
									--> 새로운 첨부파일 O [ 업로드 , 새로운DB처리 , 기존파일삭제 ]
			  						
		*/
		// 1. 수정전 기존 첨부파일명 가져오기 
		String oldfile = BoardDao.getInstance().getBoard(bno).getBfile();
					
		if ( bfile == null ) { // 새로운 첨부파일이 없다.
			bfile = oldfile;	// null이면 기존 첨부파일명 대입
		}else { // 새로운 첨부파일 있다.
			// 삭제할 첨부파일 경로찾기
			String filepath = request.getSession().getServletContext().getRealPath("/board/bfile/"+oldfile);
			// 기존파일 삭제
			File file = new File(filepath); if ( file.exists()) { file.delete(); }
		}
		
		// dto
		BoardDto boardDto = new BoardDto(bno, btitle, bcontent, bfile, cno);
			System.out.println("boardDto : "+boardDto);
		// dao
		boolean result = BoardDao.getInstance().bupdate( boardDto );
		// 응답
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("delete 메소드");
		int bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("bno : "+bno);
		//삭제전 첨부파일명 구하기 ( 게시물한개 dto반환하는 함수)
		String bfile = BoardDao.getInstance().getBoard(bno).getBfile();
		System.out.println("bfile : "+bfile);
		
		// 삭제처리
		boolean result = BoardDao.getInstance().bdelete(bno);
		System.out.println("result : "+result);
		// 삭제/수정시 : 첨부파일이 있을경우 같이 삭제
			// 1. 경로 찾아서
			// 2. 파일 객체화[ ?? 다양한 파일 관련 메소드 제공 .length() , delete() , exixts() 등등 ]
		if( result ) { // 만약에 DB가 레코드를 삭제를 성공하면
			String path = request.getSession().getServletContext().getRealPath("/board/bfile/"+bfile);
			File file = new File(path); // 객체화
			System.out.println("file : "+file);
			// 만약에 파일이 존재하면
			if ( file.exists() ) {
				file.delete();// 파일삭제
			}
		}
		
		response.getWriter().print(result);
	}

}
