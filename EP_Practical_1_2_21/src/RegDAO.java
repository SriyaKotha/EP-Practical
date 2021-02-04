import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegDAO {
	public int studentInsert(RegBean rb) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.DBConnection();
		PreparedStatement ps = con.prepareStatement("insert into registration values(?,?,?,?,?,?)");
		ps.setInt(1,rb.getRegno());
		ps.setString(2, rb.getName());
		ps.setString(3,rb.getEmail());
		ps.setString(4, rb.getPswd());
		ps.setInt(5,rb.getYear());
		ps.setInt(6, rb.getSec());
		int i = ps.executeUpdate();
		con.close();
		return i;
	}
}