package namoo.tutorial.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 프로퍼티 파일 사용하기
 * @author 정충효
 *
 */

public class ConnectionFactory2 {
	private static ConnectionFactory2 instance = new ConnectionFactory2();
	private String driver;
	private String url;
	private String username;
	private String password;
	
	private ConnectionFactory2() {
		loadProperties();
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) { }
	}
	/**
	 * 프로퍼티를 동적으로 스트림을 얻어오기 위해서 이렇게 사용
	 * 그래서 new를 안씀 
	 */
	private void loadProperties() {
		Properties prop = new Properties();
		
		InputStream in = getClass().getResourceAsStream("/config/jdbc.properties");
		try {
			prop.load(in);
			driver = prop.getProperty("database.driver");
			url = prop.getProperty("database.url");
			username = prop.getProperty("database.username");
			password = prop.getProperty("database.password");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static ConnectionFactory2 getInstance() {
		return instance;
	}
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,username,password);
	}
	
}
