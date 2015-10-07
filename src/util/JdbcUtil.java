package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 最后修改时间：2015-09=29
 * @author 13302010019-jichao
 *
 */
public class JdbcUtil {
	private String url;
	private String user;
	private String passwd;
	private static JdbcUtil util;
	public JdbcUtil(){
		url = "jdbc:mysql://localhost:3306/dblab1";
		user = "root";
		passwd = "140311jc";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] Class Not Found Exception in Jdbc Util");
			e.printStackTrace();
		}
	}
	/*本方法用于获取到JdbcUtil*/
	public static JdbcUtil getInstance(){
		if(util == null){
			util = new JdbcUtil();
		}
		return util;
	}
	public Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			System.out.println("[Error] SQL Exception in Jdbc Util");
			e.printStackTrace();
		}
		return conn;
	}
}