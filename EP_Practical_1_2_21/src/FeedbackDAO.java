import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FeedbackDAO {
	public int Insert(FeedbackBean fb) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.DBConnection();
		PreparedStatement ps = con.prepareStatement("insert into farewell values(?,?,?,?,?)");
		ps.setString(1,fb.getR1());
		ps.setString(2,fb.getR2());
		ps.setString(3,fb.getR3());
		ps.setString(4,fb.getR4());
		ps.setString(5,fb.getR5());	
		int i = ps.executeUpdate();
		con.close();
		return i;
	}
}
