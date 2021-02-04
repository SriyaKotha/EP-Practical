import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	final static String forNameURL = "com.mysql.jdbc.Driver";
	final static String DBURL = "jdbc:mysql://localhost:3306/EP_Prac_1_2_021?autoReconnect=true&useSSL=false";
	final static String username = "root";
	final static String password = "Sriya369*";
	
	public static Connection DBConnection() throws SQLException, ClassNotFoundException {
		Class.forName(forNameURL);
		Connection con = DriverManager.getConnection(DBURL,username,password);
		return con;
	}
}
