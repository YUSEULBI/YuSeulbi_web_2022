package Day20.model.Dao;

import java.util.ArrayList;

import Day20.model.Dto.BoardDto;
import Day20.model.Dto.CategoryDto;

public class BoardDao extends Dao {
	
		//싱글톤
		private static BoardDao dao = new BoardDao();
		private BoardDao() {
			// TODO Auto-generated constructor stub
		}
		public static BoardDao getInstance() {
			return dao;
		}
		
		ArrayList<CategoryDto> clist = new ArrayList<>();
		
		public boolean categoryAdd( String cname ) {
		
			String sql = "insert into category( cname ) values( ? );";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, cname);
				ps.executeUpdate();
				return true;
			}catch (Exception e) {
				System.out.println(e);
			}
			return false;
		}
		
		public ArrayList<CategoryDto> categoryPrint(){
			clist = new ArrayList<>();
			String sql = "select * from category";
			try {
				ps=con.prepareStatement(sql);
				rs = ps.executeQuery();
				while ( rs.next() ) {
					CategoryDto categoryDto = new CategoryDto(rs.getInt(1), rs.getString(2));
					clist.add(categoryDto);
				}return clist;
			}
			catch (Exception e) {
				System.out.println(e);
			}
			return null;
		}
		
		// 3. 게시물 등록
		public boolean boardAdd( String btitle , String bcontent , int mno , int cno ) {
			String sql ="insert into board( btitle ,  bcontent , mno_fk , cno_fk  ) "
					+ "values( ? , ? , ? , ? );";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, btitle);
				ps.setString(2, bcontent);
				ps.setInt(3, mno);
				ps.setInt(4, cno);
				ps.executeUpdate();
				return true;
				
			}catch (Exception e) {
				System.out.println(e);
			}return false;
		}
		
		ArrayList<BoardDto> blist = new ArrayList<>();
		// 4. 최신 게시물 3개 출력 --sql에서 limit 
		public ArrayList<BoardDto> boardPrintRecent(){
			blist = new ArrayList<>();
			String sql ="select b.bno , b.btitle , b.bcontent , b.bdate , b.bview , m.mid , c.cname \r\n"
					+ " from board b , member m , category c \r\n"
					+ " where b.mno_fk = m.mno and b.cno_fk = c.cno \r\n"
					+ " order by b.bdate desc limit 3;";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while ( rs.next() ) {
					BoardDto boardDto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
					blist.add(boardDto);
				}
			}catch (Exception e) {
				System.out.println("최근글쓰기 예외"+e);
			}
			return blist;
		}
		
		// 5. 해당 카테고리의 모든 게시물 출력
		public ArrayList<BoardDto> boardPrint( int cno ){
			blist = new ArrayList<>();
			String sql ="select b.bno , b.btitle , b.bcontent , b.bdate , b.bview , m.mid , c.cname \r\n"
					+ " from board b , member m , category c \r\n"
					+ " where b.mno_fk = m.mno and b.cno_fk = c.cno \r\n"
					+ " and b.cno_fk = ?;";
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, cno);
				rs = ps.executeQuery();
				while ( rs.next() ) {
					BoardDto boardDto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
					blist.add(boardDto);
				}
			}catch (Exception e) {
				System.out.println(e);
			}
			return blist;
		}
		
		// 6. 해당 게시물 출력
		
		
}
