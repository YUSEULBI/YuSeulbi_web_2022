package controller.product;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dao.ProductDao;
import model.dto.ProductDto;

/**
 * Servlet implementation class ProductInfo
 */
@WebServlet("/product/info")
public class ProductInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String 동 =  request.getParameter("동"); System.out.println("동 : "+동);
		String 서 =  request.getParameter("서"); System.out.println("서 : "+서);
		String 남 =  request.getParameter("남"); System.out.println("남 : "+남);
		String 북 =  request.getParameter("북"); System.out.println("북 : "+북);
		
		ArrayList<ProductDto> list = ProductDao.getInstance().getProduct(동,서,남,북);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ----------------- commons.jar 사용시 --------------------//  
		request.setCharacterEncoding("UTF-8");// * 요청 한글타입
		
		// 1. 다운로드 할 서버 경로 
		String 경로 = request.getSession().getServletContext().getRealPath("/product/pimg");
		// 2. 해당 경로의 파일/폴더 객체화 [ setRepository 에서 대입하기 위해 ]
		File 저장경로객체 = new File( 경로 );

		// 3. 업로드할 저장소 객체 생성 
		DiskFileItemFactory 파일저장소 = new DiskFileItemFactory();
		파일저장소.setRepository( 저장경로객체 );			// 파일저장소 위치 대입 
		파일저장소.setSizeThreshold( 1024*1024*10 );	// 파일저장소에 저장할수 있는 최대용량 범위
		파일저장소.setDefaultCharset("UTF-8");  		// 인코딩

		// 4.파일업로드객체 
		ServletFileUpload 파일업로드객체 = new ServletFileUpload(파일저장소);

		try {
			// 5. 매개변수 요청해서 리스트에 담기 [ 무조건 예외처리 발생 ]  
			List<FileItem> 파일아이템목록 = 파일업로드객체.parseRequest(request);
			
			//* DB저장을 위해 분류
			List<String> 일반필드목록 = new ArrayList<>();
			List<String> 파일필드목록 = new ArrayList<>();
			
			// List인터페이스 ArrayList구현객체
			
			// 6.
			for( FileItem item : 파일아이템목록 ) {	// 요청된 모든 매개변수들을 반복문 돌려서 확인
				
				if ( item.isFormField() ) {
					// ★FileItem 클래스
					// ★.isFormField() : 바이너리 필드여부 -> 첨부파일이 아니면 true / 첨부파일이면 false
					// ★item.getString()
					System.out.println("첨부파일 아닌 필드명 : "+item.getFieldName());
					System.out.println("첨부파일 아닌 필드의 입력값 : "+item.getString()); // 입력값 - 값을 호출
					일반필드목록.add(item.getString()); // 리스트에 저장
					
				}else { // ★item.getName()
					System.out.println("첨부파일 인 필드명 : "+ item.getFieldName());
					System.out.println("첨부파일 인 필드의 파일명 : "+ item.getName()); // 첨부파일의 파일명 호출
					
					// 9. 첨부파일 이름 식별이름 변경 // replaceAll("기존문자", "새로운문자") 문자열 치환함수
						// 1. 파일명에 공백이 존재하면 -으로 변경
						// 2. UUID : 범용 고유 식별자 [ 중복이 없는 식별자 만들기 ]
						// 최종 식별 파일명 : UUID 파일명
					String filename = UUID.randomUUID()+" "+item.getName().replaceAll(" ", "-");
					
					파일필드목록.add( filename ); // 첨부된 파일의 이름을 요청해서 리스트 저장
					
					// 7. 저장할 경로+/+파일명 의 파일을 객체화
					File 업로드할파일 = new File(경로+"/"+filename);
					
					// 8. 해당 경로에 item 업로드하기 
					// ★item.write( 경로를담은 file객체 )
					item.write( 업로드할파일 );
				}
				
			}
			//
			System.out.println( 일반필드목록.toString() );
			System.out.println( 파일필드목록.toString() );
			
			int mno = MemberDao.getInstance().getMno( 
					(String)request.getSession().getAttribute("login"));
			
			System.out.println("일반필드목록.get(0) : "+일반필드목록.get(0));
			System.out.println("일반필드목록.get(1) : "+일반필드목록.get(1));
			System.out.println("Integer.parseInt(일반필드목록.get(2)) : "+Integer.parseInt(일반필드목록.get(2)));
			System.out.println("일반필드목록.get(3) : "+일반필드목록.get(3));
			System.out.println("일반필드목록.get(4) : "+일반필드목록.get(4));
			System.out.println("mno : "+mno);
			System.out.println("파일필드목록 : "+파일필드목록);
			
			ProductDto dto = new ProductDto( 
					일반필드목록.get(0), 일반필드목록.get(1), 
					Integer.parseInt(일반필드목록.get(2)) , 
					일반필드목록.get(3), 일반필드목록.get(4) , 
					mno , 파일필드목록);
			System.out.println("dto : "+dto.toString() );
			
		}catch (Exception e) { System.out.println(e); }
		

		
		// cos.jar라이브러리 사용방식
//		String path = request.getSession().getServletContext().getRealPath("/product/pimg");
//		MultipartRequest multi = new MultipartRequest(
//						request,
//						path ,
//						1024*1024 *10 ,
//						"UTF-8" ,
//						new DefaultFileRenamePolicy()
//					);
//		String pname = multi.getParameter("pname"); 			System.out.println("pname : "+pname);
//		String pcomment = multi.getParameter("pcomment");		System.out.println("pcomment : "+pcomment);
//		int pprice = Integer.parseInt(multi.getParameter("pprice"))  ;		System.out.println("pprice : "+pprice);
//		String plat = multi.getParameter("plat");				System.out.println("plat : "+plat);
//		String plng = multi.getParameter("plng");				System.out.println("plng : "+plng);
//		
//		String pfile = multi.getFilesystemName("pfile");
//		System.out.println("pfile : "+pfile);
//		
//		String pfile1 = multi.getFilesystemName("pfile1");
//		System.out.println("pfile1 : "+pfile1);
//		String pfile2 = multi.getFilesystemName("pfile2");
//		System.out.println("pfile2 : "+pfile2);
//		String pfile3 = multi.getFilesystemName("pfile3");
//		System.out.println("pfile3 : "+pfile3);
//		
//		//첨부파일 여러개 가져오기
//		// multiple input에 등록된 여러 사진들의 이름 가져오기 불가능 [ cos.jar 불가능 ]
//			// 다른 라이브러리 사용
//		Enumeration pfiles = multi.getFileNames(); // input type이 file인 태그명 호출
//		while( pfiles.hasMoreElements() ) {
//			// 해당목록[pfiles]에 요소[element]가 존재하면 true / 아니면 false
//			String s = (String)pfiles.nextElement(); // 다음 요소 가져오기
//			System.out.println("s : "+s);
//		}
//		
//		ProductDto dto = new ProductDto(pname, pcomment, pprice, plat, plng);
//		boolean result =  ProductDao.getInstance().write(dto);
//		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
