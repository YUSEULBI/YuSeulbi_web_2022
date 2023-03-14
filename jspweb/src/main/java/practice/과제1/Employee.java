package practice.과제1;

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

import practice.과제1.dao.EmployeeDao;
import practice.과제1.dto.EmployeeDto;

/**
 * Servlet implementation class Employee
 */
@WebServlet("/employee")
public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<EmployeeDto> list = EmployeeDao.getInstance().getEmployee();
		System.out.println("list : "+ list);
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(list);
		System.out.println("jsonArray : " + jsonArray);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uploadpath = request.getSession().getServletContext().getRealPath("/practice/과제1/img");
		System.out.println("uploadpath : " + uploadpath);
		
		MultipartRequest multi = new MultipartRequest(
					request ,
					uploadpath ,
					1024*1024*10 ,
					"UTF-8" ,
					new DefaultFileRenamePolicy()
				);
		
		String ename = multi.getParameter("ename"); 		System.out.println("ename : " + ename);
		String erank = multi.getParameter("erank");			System.out.println("erank : " + erank);
		String etype = multi.getParameter("etype");			System.out.println("etype : " + etype);
		String dept = multi.getParameter("dept");			System.out.println("dept : " + dept);
		String edate = multi.getParameter("edate");			System.out.println("edate : " + edate);
		String epic = multi.getFilesystemName("epic");		System.out.println("epic : " + epic);
		String rdept = multi.getParameter("rdept");			System.out.println("rdept : " + rdept);
		
		EmployeeDto dto = new EmployeeDto(0, ename, erank, etype, dept, edate, epic, rdept , null , null );
		System.out.println(dto);
		
		boolean result =  EmployeeDao.getInstance().signUp(dto);
		response.getWriter().print(result);
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uploadpath = request.getSession().getServletContext().getRealPath("/practice/과제1/img");
		System.out.println("uploadpath : " + uploadpath);
		
		MultipartRequest multi = new MultipartRequest(
					request ,
					uploadpath ,
					1024*1024*10 ,
					"UTF-8" ,
					new DefaultFileRenamePolicy()
				);
		// Integer.parseInt( “문자열“ )
		int eno = Integer.parseInt( multi.getParameter("eno") ); 		System.out.println("eno : " + eno);
		EmployeeDto bdto = EmployeeDao.getInstance().getEmployeeOne(eno);
		
		String chname = multi.getParameter("chname"); 		
		chname = (chname == null ? bdto.getEname() : chname); System.out.println("chname : " + chname);
		
		String chrank = multi.getParameter("chrank");			
		chrank = (chrank == null ? bdto.getErank() : chrank);	System.out.println("chrank : " + chrank);
		
		String chtype = multi.getParameter("chtype");			
		chtype = (chtype == null ? bdto.getEtype() : chtype);	System.out.println("chtype : " + chtype);
		
		String chdept = multi.getParameter("chdept");			
		chdept = (chdept == null ? bdto.getDept() : chdept);	System.out.println("chdept" + chdept);
		
		String chepic = multi.getFilesystemName("chepic");		
		chepic = (chepic == null ? bdto.getEpic() : chepic);	System.out.println("chepic : " + chepic);
		
		String chrdept = multi.getParameter("chrdept");			
		chrdept = (chrdept == null ? bdto.getRdept() : chrdept);	System.out.println("chrdept : " + chrdept);
		
		String dedate = multi.getParameter("dedate");			
		dedate = (dedate == null ? bdto.getDedate() : dedate);	System.out.println("dedate : " + dedate);
		
		String dereason = multi.getParameter("dereason");			
		dereason = (dereason == null ? bdto.getDereason() : dereason);	System.out.println("dereason : " + dereason);

		
		EmployeeDto dto = new EmployeeDto(eno, chname, chrank, chtype, chdept, null, chepic, chrdept, dedate, dereason);
		System.out.println(dto);
		
		boolean result =  EmployeeDao.getInstance().updateEmployee(dto);
		response.getWriter().print(result);
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eno = Integer.parseInt(request.getParameter("eno")) ;
		boolean result =  EmployeeDao.getInstance().deleteEmploye(eno);
		response.getWriter().print(result);
	}

}
