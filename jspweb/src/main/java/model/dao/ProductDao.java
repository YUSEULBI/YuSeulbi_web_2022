package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import model.dto.ChatDto;
import model.dto.ProductDto;

public class ProductDao extends Dao {
	
	private static ProductDao dao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance () { 	return dao; 	}
	
	 //  synchronized : 멀티스레드 사용시 ( 서블릿 ) 해당 메소드 동시사용불가 대기만들기 await
	
	// 1. 제품등록
	public synchronized boolean write( ProductDto dto ) {
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
	public synchronized ArrayList<ProductDto> getProduct( String 동 , String 서 , String 남 , String 북 ) { 	
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
	public synchronized boolean setPlike( int pno , int mno ) {
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
	public synchronized boolean getPlike( int pno , int mno ) {
		String sql = "select * from plike where mno = "+mno+" and pno = "+pno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if ( rs.next()) { return true; }
		} catch (Exception e) {
			System.out.println(e);
		}return false;
	}
	
	// 5. 쪽지보내기 (DB저장)
	public synchronized boolean setChat(ChatDto dto) {
		String sql = "insert into note(ncontent , pno , frommno , tomno ) values ( ? , ? , ? , ? );";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getNcontent() );
			ps.setInt(2, dto.getPno() );
			ps.setInt(3, dto.getFrommno() );
			ps.setInt(4, dto.getTomno() );
			int count = ps.executeUpdate();
			if ( count == 1 ) {return true; }
		} catch (Exception e) {
			System.out.println(e);
		}return false;
	}
	
	// 6. 쪽지출력 [ 제품번호 동일 , 로그인한 회원이 받거나 보낸 내용 ] js 9번 10번
	// mno : 로그인한 사람
	public synchronized ArrayList<ChatDto> getChatList( int pno , int mno , int chatmno ) {
		ArrayList<ChatDto> list = new ArrayList<>();
		
		String sql = "";
		
		if ( chatmno != 0 ) { // 채팅방내 메시지 목록출력
			sql = "select n.* , m.mid , m.mimg from note n join member m "
					+ " on m.mno = n.frommno "
					+ " where pno = ? and ( ( frommno = ? and tomno= ? ) or ( frommno = ? and tomno= ? ) )  order by n.nno asc";
		}else {
			System.out.println("dao에서 getChatList에서 chatmno가 0일때 sql");
			// 내맘대로 수정 전
//			sql = "select n.* , m.mid , m.mimg from note n join member m "
//					+ " on m.mno = n.frommno where n.pno = ? and ( n.frommno = ? or n.tomno = ? )  order by n.nno asc";
			
			sql = "select n.* , m.mid , m.mimg from note n join member m "
					+ " on m.mno = n.frommno where n.pno = ? and n.tomno = ?  order by n.nno desc";
		}
		
		
		// 현재 같이 채팅하고 있는 대상자들의 내용물만 출력 / pno : 채팅방기준 /
		
		
		/*
			1. 구매자 문제없음 2. 판매자는 채팅 대상자의 메시지만 출력 해야함 문제 발생
			
			만약에 채팅방에 4번회원 		5번회원
			frommno = 4이면서 tomno = 5 		이거나		frommno = 5 이면서 tomno = 4
			
			- 4번회원이 보냈거나 받았으면 5번회원이 받았거나 보냈으면
		
		 */
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.setInt(2, mno);
			
			if ( chatmno != 0 ) {
				ps.setInt(3, chatmno);
				ps.setInt(4, chatmno);
				ps.setInt(5, mno);
			}
			// 내맘대로수정
//			else {
//				ps.setInt(3, mno);
//			}
			rs = ps.executeQuery();
			while (rs.next()) {
				ChatDto chatDto = new ChatDto(
						rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getInt(4), rs.getInt(5), rs.getInt(6));
				chatDto.setFrommid(rs.getString(7));
				chatDto.setFrommimg(rs.getString(8));	
				
				list.add(chatDto);
			}
		} catch (Exception e) { System.out.println(e); 	}
		return list;
	}
	
	
	// 7. 날짜별 포인트 충전 내역
	public HashMap<String, Integer> getSum(){
		HashMap<String, Integer> map = new HashMap<>();	// String , Integer 타입 hashmap 저장
		String sql = "select "
				+ "    sum( if( mpcomment ='포인트충전'  , mpamount , 0 ) ) as 충전된포인트총합계 ,"
				+ "	date_format( mpdate , '%Y%m%d' ) as 충전날짜 "
				+ " from mpoint\r\n"
				+ "   group by date_format( mpdate , '%Y%m%d' ) "
				+ "   order by 충전날짜 desc "
				+ "   limit 5;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while ( rs.next() ) {
				map.put( rs.getString(2) , rs.getInt(1));
			}
		} catch (Exception e) { System.out.println(e); 	}
		System.out.println("dao map : "+map);
		return map;
	}
	
	
}

/*
 		// 1. 해당 타입의 객체를 여러개 저장할 수 있는 리스트 객체 선언
 		ArrayList<타입> list = new ArrayList<>();
 		[ '유재석' , '강호동' ]
 		add
 		------------------------
 		// 2. 해당 키타입과 데이터타입 의 해당하는 키와 데이터를 여러개 저장할 수 있는 맵 객체 선언
 		HashMap< 키타입 , 값타입 > map = new HashMap<>();
 		{ '유재석'=30 , '강호동'=10 }
 		put
 		------------------------
 		JSON = JS객체
 		let 객체명 = {
 			필드명 : 값 ,
 			필드명 : 값 
 		}
 */
 