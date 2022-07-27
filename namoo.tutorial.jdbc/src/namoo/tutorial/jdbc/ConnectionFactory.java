package namoo.tutorial.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 싱글톤 패턴이 적용된 Connection Factory
 * @author 정충효
 *
 */
public class ConnectionFactory {


	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USERNAME = "hr";
	private static final String PASSWORD = "hr";
	private static ConnectionFactory instance = new ConnectionFactory();
	private ConnectionFactory() {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) { }
	}
	public static ConnectionFactory getInstance() {
		return instance;
	}
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
}
