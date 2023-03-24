package model.dao;

import java.util.ArrayList;

import model.dto.ProductDto;

public class ProductDao extends Dao {
	
	private static ProductDao dao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance () { 	return dao; 	}
	
	// 1. 제품등록
	public boolean write( ProductDto dto ) {
		String sql = "insert product ( pname , pcomment , pprice , plat , plng ) "
				+ " values ( '"+dto.getPname()+"' , "
						+ " '"+dto.getPcomment()+"' , "+dto.getPprice()+" , "
						+ " "+dto.getPlat()+" , "+dto.getPlng()+" );";
		try {
			ps = con.prepareStatement(sql);
			int count = ps.executeUpdate();
			if ( count == 1 ) { return true; }
		} catch (Exception e) { System.out.println(e); 	}
		return false;
	}
	
	// 2. 제품출력
	public ArrayList<ProductDto> getProduct( String 동 , String 서 , String 남 , String 북 ) { 	
		ArrayList<ProductDto> list = new ArrayList<>(); // plng 경도(가로) plat 위도(세로) 
		String sql = "select * from product where "+남+" <= plat && "+북+" >= plat && "+서+" <= plng && "+동+" >= plng";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while ( rs.next() ) {
				ProductDto dto = new ProductDto(
						rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getLong(4), rs.getInt(5), rs.getString(6), 
						rs.getString(7), rs.getInt(8), rs.getString(9));
				list.add(dto);
			}
		} catch (Exception e) { System.out.println(e); 	}
		return list;
	}
}
