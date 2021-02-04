import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDAO {

	public String search(String e) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.DBConnection();
		String q = "select pswd from registration where email=?";
		PreparedStatement ps = con.prepareStatement(q);
		ps.setString(1, e);
		ResultSet rs = ps.executeQuery();
		String s="";
		while(rs.next()) {
			s = rs.getString(1);
		}
		
		return s;
	}
}
