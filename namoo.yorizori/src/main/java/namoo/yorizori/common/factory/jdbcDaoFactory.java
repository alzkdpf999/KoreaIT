package namoo.yorizori.common.factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import namoo.yorizori.dao.cookbook.CookbookDao;
import namoo.yorizori.dao.cookbook.ProcedureDao;
import namoo.yorizori.dao.cookbook.RecipeDao;
import namoo.yorizori.dao.cookbook.jdbcCookbookDao;
import namoo.yorizori.dao.cookbook.jdbcProcedureDao;
import namoo.yorizori.dao.cookbook.jdbcRecipeDao;
import namoo.yorizori.dao.user.UserDao;
import namoo.yorizori.dao.user.jdbcUserDao;
/**
 *	JDBC 기술을 이용하는 Dao 객체를 생성하는 팩토리 
 * @author 정충효
 *
 */
public class jdbcDaoFactory implements DaoFactory {

	private static jdbcDaoFactory instance = new jdbcDaoFactory();
	private String driver;
	private String url;
	private String username;
	private String password;
	private DataSource dataSource;

	private UserDao userDao;
	private CookbookDao cookbookDao;
	private RecipeDao recipeDao;
	private ProcedureDao procedureDao;
	private jdbcDaoFactory() {
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
	public static jdbcDaoFactory getInstance() {
		return instance;
	}
	public Connection getConnection() throws SQLException {
		return instance.dataSource.getConnection();
	}
	@Override
	public UserDao getUserDao() {
		if(userDao==null) {
		userDao= new jdbcUserDao(dataSource);
		}
		return userDao;
	}
	public CookbookDao getCookbookDao() {
		if(cookbookDao==null) {
			cookbookDao= new jdbcCookbookDao(dataSource);
		}
		return cookbookDao;
	}
	public RecipeDao getRecipeDao() {
		if(recipeDao==null) {
			recipeDao= new jdbcRecipeDao(dataSource);
		}
		return recipeDao;
	}
	public ProcedureDao getProcedureDao() {
		if(procedureDao==null) {
			procedureDao= new jdbcProcedureDao(dataSource);
		}
		return procedureDao;
	}
}
