package model.dao;

import java.util.ArrayList;

import model.dto.BoardDto;

public class BoardDao extends Dao {
	
	private static BoardDao boardDao = new BoardDao();
	private BoardDao() {	}
	public static BoardDao getInstance() { 	return boardDao; }
	
	// 글쓰기
	public boolean bwrite( BoardDto dto ) {
		String sql = "insert into board( btitle , bcontent , bfile , mno , cno ) "
				+ "values( ?,?,?,?,?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getBtitle());
			ps.setString(2, dto.getBcontent());
			ps.setString(3, dto.getBfile());
			ps.setInt(4, dto.getMno());
			ps.setInt(5, dto.getCno());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {	System.out.println(e);	}
		return false;
	}
	
	// 2. 게시물수 구하기 ( 레코드수 구하기)
	public int getTotalSize(String key , String keyword , int cno ) {
		String sql = "";
		if ( key.equals("") && keyword.equals("")) {// 검색이 없다..
			sql = "select count(*)  from member m natural join board b where b.cno = "+cno;
		}else { // 검색이 있따.
			sql = "select count(*)  from member m natural join board b where "+key+" like '%"+keyword+"%' and b.cno = "+cno;
		}
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if ( rs.next() ) { return rs.getInt(1);	}
		} catch (Exception e) {
			System.out.println(e);
		}return 0;
		
		
	}
	
	// 2. 게시글출력
	public ArrayList<BoardDto> getBoardList( int startrow ,int listsize , String key , String keyword , int cno ){
		ArrayList<BoardDto> list = new ArrayList<>();
		String sql = "";
		if ( key.equals("")&& keyword.equals("")) {
			sql = "select b.* , m.mid from member m natural join board b where b.cno = "+cno
					+ " order by b.bdate desc limit ? , ?;";
		}else {
			sql = "select b.* , m.mid from member m natural join board b where "+key+" like '%"+keyword+"%' and b.cno = "+cno
					+ " order by b.bdate desc limit ? , ?";
		}
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, startrow);
			ps.setInt(2, listsize);
			rs = ps.executeQuery();
			while( rs.next()) {
				BoardDto boardDto = new BoardDto(
						rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getInt(6), 
						rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getString(11));
				list.add(boardDto);
			}
		} catch (Exception e) {System.out.println(e);		}
		return list;
	}
	
	// 개별 게시물 조회
	public BoardDto getBoard( int bno ) {
		BoardDto boardDto = new BoardDto();
		String sql = "select board.* , member.mid , member.mimg  from member natural join board where board.bno = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
			if ( rs.next() ) {  
				boardDto = new BoardDto(
						rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getInt(6), 
						rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), 
						rs.getString(11) );
				
			}
		} catch (Exception e) {System.out.println(e);		}
		return boardDto;
	}
	
	// 4. 조회수/좋아수/싫어요 증가[update]
		public boolean bIncrease( int type , int bno ) {
			String sql ="";
			// 만약에 타입이 1이면 bview 2이면 bup 3이면 bdown 를 1씩 증가 업데이트
			if( type == 1 ) { sql="update board set bview 	= bview+1 	where bno = "+bno; }
			if( type == 2 ) { sql="update board set bup 	= bup+1 	where bno = "+bno; }
			if( type == 3 ) { sql="update board set bdown 	= bdown+1	where bno = "+bno; }
			try {
				ps = con.prepareStatement(sql); ps.executeUpdate(); return true;
			}catch (Exception e) {System.out.println(e);}  return false;
		}
		
	//
	public boolean bdelete( int bno ) {
		String sql = "delete from board where bno = "+bno;
		try {
			ps = con.prepareStatement(sql);
			int count = ps.executeUpdate();
			if ( count == 1 )return true;
		}catch (Exception e) {System.out.println(e);}  return false;
	}
	
	// 6. 게시물수정
	public boolean bupdate( BoardDto dto ) {
		String sql = "update board "
				+ " set btitle = ? , bcontent = ? , "
				+ " bfile = ? , cno = ? where bno = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getBtitle());
			ps.setString(2, dto.getBcontent());
			ps.setString(3, dto.getBfile());
			ps.setInt(4, dto.getCno());
			ps.setInt(5, dto.getBno());
			
			int count = ps.executeUpdate();
			if ( count == 1 ) {return true;}
		} catch (Exception e) { System.out.println(e); 	}
		return false;
	}
		
}















