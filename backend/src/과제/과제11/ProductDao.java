package 과제.과제11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Day15.Ex9_MVC패턴.MemberDTO;

public class ProductDao {
	
	// 싱글톤
	private static ProductDao dao = new ProductDao();
	
	public static ProductDao getInstance() {
		return dao;
	}
	
	// 1. 필드
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// 2. 생성자
	private ProductDao() {
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/과제11",
					"root",
					"1234"
			);
			
		}catch (Exception e) {
			System.out.println( "[DB연동문제] :" + e );
		}	
	} // 생성자 end
	
	// 3. 제품등록 [ 인수: 이름 , 가격 , 초기재고  / 반환: ]
	boolean pRegist( ProductDto dto  ) {
		String sql = "insert into product ( pname , pprice , pstock ) values( ? , ? , ? );";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getPname());
			ps.setInt(2, dto.getPprice());
			ps.setInt(3, dto.getPstock());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("[sql예외] : " + e);
		}
		return false;
	}
	
	// 4. 제품출력
	ArrayList<ProductDto> list() {
		
		ArrayList<ProductDto> list = new ArrayList<>();
		
		String sql = "select * from product;";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); // 검색결과 가져옴
			while ( rs.next()) {
				ProductDto dto = new ProductDto(
				rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4) );
				//System.out.println("회원객체1개 : " + dto);
				list.add(dto);
				
			}
			//System.out.println("회원목록 : " + list.toString());
			return list;
		}catch (Exception e) {
			System.out.println("[DAO제품출력문제] : " + e);
		}
		return null;
		
	}
	
	// 5. 제품수정 [ 인수 : pno , pname / 반환 : 성공실패 ]
	boolean upDate_pname( int pno , String pname ) {
		String sql = "update product set pname = ? where pno=?;";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pname);
			ps.setInt(2, pno);
			ps.executeUpdate();
			return true;
			
		}catch (Exception e) {
			System.out.println("제품수정예외 : " +e);
		}
		return false;
	}
	
	// 5. 제품수정 [ 인수 : pname , pprice / 반환 : 성공실패 ]
	boolean upDate_pprice( String pname , int pprice ) {
		String sql = "update product set pprice = ? where pname=?;";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pprice);
			ps.setString(2, pname);
			ps.executeUpdate();
			return true;
			
		}catch (Exception e) {
			System.out.println("제품수정예외 : " +e);
			
		}
		return false;
	}
	
	// 6. 제품재고변경
	boolean upDate_pstock( int pno , int pstock ) {
		String sql = "update product set pstock = ? where pno=?;";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pstock);
			ps.setInt(2, pno);
			ps.executeUpdate();
			return true;
			
		}catch (Exception e) {
			System.out.println("제품수정예외 : " +e);
		}
		return false;
	}
	
	// 7. 제품삭제 // [ 인수 : 제품번호 // 반환 :성공실패 ]
	boolean delete( int pno ) {
		String sql = "delete from product where pno = ?;";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("제품수정예외 : " +e);
		}
		return false;
	}
	
	// 6. 장바구니에 담긴 제품재고수량 DB에서 차감
	boolean down_pstock( ArrayList<ProductDto> 임시재고 ) {
			
			try {
				for( ProductDto p : 임시재고 ) {
					String sql = "update product set pstock = ? where pno=?;";
					ps = conn.prepareStatement(sql);
					ps.setInt(1, p.getPstock());
					ps.setInt(2, p.getPno());
					ps.executeUpdate();
				}
				return true;
				
			}catch (Exception e) {
				System.out.println("제품결제예외 : " +e);
			}
			return false;
	}
	
}











