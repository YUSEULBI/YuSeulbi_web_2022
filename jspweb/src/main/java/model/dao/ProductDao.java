package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



import model.dto.ProductDto;

public class ProductDao extends Dao {
	
	private static ProductDao dao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance () { 	return dao; 	}
	
	// 1. 제품등록
	public boolean write( ProductDto dto ) {
		// 1. 제품 우선 등록
		String sql = "insert product ( pname , pcomment , pprice , plat , plng , mno ) "
				+ " values ( '"+dto.getPname()+"' , "
						+ " '"+dto.getPcomment()+"' , "+dto.getPprice()+" , "
						+ " "+dto.getPlat()+" , "+dto.getPlng()+" , "+dto.getMno()+" );";
		try {
			// 등록된 제품pk번호 가져오기
			ps = con.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
			int count = ps.executeUpdate();
			// insert 후 생성된 제품 pk
			rs = ps.getGeneratedKeys();
			if ( rs.next() ) { // 만약에 생성된 제품pk번호가 존재하면
				for ( String pimgname : dto.getPimglist() ) {
					// dto내 첨부파일명 리스트 반복문 돌려서  하나씩 insert 하기
					sql = "insert into productpic( pimgname , pno ) values (?,?)";
					ps = con.prepareStatement(sql);
					ps.setString(1, pimgname);
					ps.setInt(2, rs.getInt(1));
					ps.executeUpdate();
				}
			}
			return true;
		} catch (Exception e) { System.out.println(e); 	}
		return false;
	}
	
	// 2. 제품출력
	public ArrayList<ProductDto> getProduct( String 동 , String 서 , String 남 , String 북 ) { 	
		ArrayList<ProductDto> list = new ArrayList<>(); // plng 경도(가로) plat 위도(세로) 
		String sql = "select p.* , m.mid , m.mimg from product p natural join member m "
				+ " where "+남+" <= plat && "+북+" >= plat && "+서+" <= plng && "+동+" >= plng";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while ( rs.next() ) {
				
				// 사진 레코드 호출
				ArrayList<String> pimglist = new ArrayList<>();
				sql = "select * from productpic where pno = "+rs.getInt(1);
				ps = con.prepareStatement(sql);
				ResultSet rs2 = ps.executeQuery();
				while( rs2.next() ) {
					pimglist.add(rs2.getString(2));	// 검색된 이미지 이름을 리스트에 저장
				}
				ProductDto dto = new ProductDto(
						rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getLong(4), rs.getInt(5), rs.getString(6), 
						rs.getString(7), rs.getInt(8), rs.getString(9), 
						rs.getInt(10), rs.getString(11), rs.getString(12), pimglist);
				
				list.add(dto);
			}
		} catch (Exception e) { System.out.println(e); 	}
		return list;
	}
	
	// 3.찜하기 등록과 취소
	public boolean setPlike( int pno , int mno ) {
		// 1. 등록할지 취소할지 검색
		String sql = "select * from plike where mno = "+mno+" and pno = "+pno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if ( rs.next() ) { // 이미 찜한 제품 --> 취소
				sql = "delete from plike where mno = "+mno+" and pno = "+pno;
				ps = con.prepareStatement(sql);
				ps.executeUpdate(); return false;
			}else { // 찜한 적 없으면 --> 찜하기 
				sql = "insert into plike ( mno , pno ) values ( "+mno+" , "+pno+" );";
				ps = con.prepareStatement(sql);
				ps.executeUpdate(); return true;
			}
		} catch (Exception e) { System.out.println(e); 	}
		return false;
	}
	
	// 4. 현재 회원이 해당 제품의 찜하기 상태 확인
	public boolean getPlike( int pno , int mno ) {
		String sql = "select * from plike where mno = "+mno+" and pno = "+pno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if ( rs.next()) { return true; }
		} catch (Exception e) {
			System.out.println(e);
		}return false;
	}
}
