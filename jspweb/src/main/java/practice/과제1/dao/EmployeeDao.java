package practice.과제1.dao;

import java.sql.Statement;
import java.util.ArrayList;



import practice.과제1.dto.EmployeeDto;

public class EmployeeDao extends Dao {
	
	private static EmployeeDao dao = new EmployeeDao();
	private EmployeeDao() { 	}
	public static EmployeeDao getInstance() { return dao; }
	
	// 1. 직원등록
	public boolean signUp( EmployeeDto dto ) {
		String sql ="insert into employee(ename , erank , etype , deptno , edate , epic )values(?,?,?,?,?,?);";
		try {
			//인사팀 영업팀 개발팀
			int deptNo = 0;
			if ( dto.getDept().equals("인사팀") ) { deptNo = 1; }
			else if ( dto.getDept().equals("영업팀") ) { deptNo = 2; }
			else if ( dto.getDept().equals("개발팀") ) { deptNo = 3; }
			
			
			ps = con.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dto.getEname());
			ps.setString(2, dto.getErank());
			ps.setString(3, dto.getEtype());
			ps.setInt(4, deptNo );
			ps.setString(5, dto.getEdate());
			ps.setString(6, dto.getEpic());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys(); // 회원번호
			int eno = 0;
			if( rs.next() ) { eno = rs.getInt(1); } 
			System.out.println(rs.getInt(1));
			// 부서 담당자
			if ( !dto.getRdept().equals("없음") ) {
				int rdeptNo = 0;
				if ( dto.getRdept().equals("인사팀") ) { rdeptNo = 1; }
				else if ( dto.getRdept().equals("영업팀") ) { rdeptNo = 2; }
				else if ( dto.getRdept().equals("개발팀") ) { rdeptNo = 3; }
				boolean result = rupdate( eno , rdeptNo );
				if ( !result ) { return false; }
			}
			
			return true;
		} catch (Exception e) { System.out.println("사원등록 예외 : " + e); 		}
		return false;
	}
	
	// 인사등록시 부서담당자 업데이트
	public boolean rupdate( int eno , int deptno ) {
		String sql = "update department set eno = ? where deptno = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, eno);
			ps.setInt(2, deptno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) { System.out.println(e); 	}
		return false;
	}
		
	
	// 2. 직원출력
	public ArrayList<EmployeeDto> getEmployee() {
		ArrayList<EmployeeDto> list = new ArrayList<>();
		String sql = "select"
				+ "	e.eno , e.ename , e.erank , e.etype , d.dname , e.edate , e.epic , "
				+ "    if( e.eno in( select e.eno from  employee e , department d  where e.eno = d.eno ) , d.dname , '' ) as rname ,"
				+ "    e.dedate , e.dereason"
				+ " from "
				+ "	employee e ,department d"
				+ " where "
				+ "	e.deptno = d.deptno;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				EmployeeDto dto = new EmployeeDto(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), 
						rs.getString(8), rs.getString(9), rs.getString(10));
				list.add(dto);
			}return list;
			} catch (Exception e) { System.out.println(e); 	}
		return null;
	}
	
	// 3. 사원 수정
	public boolean updateEmployee(EmployeeDto dto) {
		if ( dto.getDedate() == null ) { 	}
		
		//인사팀 영업팀 개발팀
		int deptNo = 0;
		if ( dto.getDept().equals("인사팀") ) { deptNo = 1; }
		else if ( dto.getDept().equals("영업팀") ) { deptNo = 2; }
		else if ( dto.getDept().equals("개발팀") ) { deptNo = 3; }
		System.out.println(deptNo);
		String sql = "update employee set "
				+ "ename = ? , erank = ? , etype = ? , deptno = ? , "
				+ "epic = ? , dedate = ? , dereason = ? where eno = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getEname());
			ps.setString(2, dto.getErank());
			ps.setString(3, dto.getEtype());
			ps.setInt(4, deptNo);
			ps.setString(5, dto.getEpic());
			// ps.setString(6 , dto.getDedate() );
			if ( dto.getDedate() == null || dto.getDedate().equals("")  ) { ps.setString(6, null); }else { ps.setString(6 , dto.getDedate() ); }
			ps.setString(7, dto.getDereason());
			ps.setInt(8, dto.getEno());
			ps.executeUpdate();
			return true;
		} catch (Exception e) { System.out.println(e); 	}
		return false;
	}
	
	
	// 2. 직원 1명 호출
		public EmployeeDto getEmployeeOne( int eno ) {
			EmployeeDto dto = new EmployeeDto();
			String sql = "select"
					+ "	e.eno , e.ename , e.erank , e.etype , d.dname , e.edate , e.epic , "
					+ "    if( e.eno in( select e.eno from  employee e , department d  where e.eno = d.eno ) , d.dname , '' ) as rname ,"
					+ "    e.dedate , e.dereason"
					+ " from "
					+ "	employee e ,department d"
					+ " where "
					+ "	e.deptno = d.deptno and e.eno = ?;";
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, eno);
				rs = ps.executeQuery();
				if (rs.next()) {
					dto = new EmployeeDto(rs.getInt(1), rs.getString(2), rs.getString(3), 
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), 
							rs.getString(8), rs.getString(9), rs.getString(10));
					
				}return dto;
				} catch (Exception e) { System.out.println(e); 	}
			return null;
		}
	// 3. 회원 탈퇴
		public boolean deleteEmploye( int eno ) {
			String sql = "delete from employee where eno = ?;";
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, eno);
				ps.executeUpdate();
				return true;
			} catch (Exception e) { System.out.println(e); 	}
			return false;
		}
		
	// 4. 근무자 출력
		public ArrayList<EmployeeDto> getWEmployee() {
			ArrayList<EmployeeDto> list = new ArrayList<>();
			String sql = "select"
					+ "	e.eno , e.ename , e.erank , e.etype , d.dname , e.edate , e.epic , "
					+ "    if( e.eno in( select e.eno from  employee e , department d  where e.eno = d.eno ) , d.dname , '' ) as rname ,"
					+ "    e.dedate , e.dereason"
					+ " from "
					+ "	employee e ,department d"
					+ " where "
					+ "	e.deptno = d.deptno and e.dedate IS NOT NULL;";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					EmployeeDto dto = new EmployeeDto(rs.getInt(1), rs.getString(2), rs.getString(3), 
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), 
							rs.getString(8), rs.getString(9), rs.getString(10));
					list.add(dto);
				}return list;
				} catch (Exception e) { System.out.println(e); 	}
			return null;
		}
}
