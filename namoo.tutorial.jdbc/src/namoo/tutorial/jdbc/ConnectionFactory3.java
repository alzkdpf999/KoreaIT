package namoo.tutorial.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;




/**
 * 프로퍼티 파일 사용하기
 * @author 정충효
 *
 */
public class ConnectionFactory3 {
	private static ConnectionFactory3 instance = new ConnectionFactory3();
	private String driver;
	private String url;
	private String username;
	private String password;
	private DataSource dataSource;
	private ConnectionFactory3() {
		loadProperties();
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setInitialSize(10); // 풀의 초기 커넥션 개수
		ds.setMaxTotal(100); // 최대 커넥션 개수
		ds.setMaxIdle(10); // Idle 상태에 풀이 소유하는 최대 커넥션 개수
		ds.setMaxWaitMillis(1000); // 커넥션이 존재하지 않을 때 커넥션 획득에 대기할 시간
		dataSource = ds;
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
	public static ConnectionFactory3 getInstance() {
		return instance;
	}
	public Connection getConnection() throws SQLException {
		return instance.dataSource.getConnection();
	}
	
}
