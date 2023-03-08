package practice.signupadmin.dao;

public class ConfirmDao extends Dao {

	private static ConfirmDao confirmDao = new ConfirmDao();
	private ConfirmDao() { 	}
	public static ConfirmDao getInstance() {
		return confirmDao;
	}
	
	public boolean idCheck( String mid ) {
		String sql = "select * from member where mid = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			while( rs.next() ) { return true;		}
		} catch (Exception e) {
			System.out.println(e);
		}return false;
	}
	
}
