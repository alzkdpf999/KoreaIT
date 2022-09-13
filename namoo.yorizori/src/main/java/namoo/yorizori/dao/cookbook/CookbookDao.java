package namoo.yorizori.dao.cookbook;

import java.sql.SQLException;
import java.util.List;

import namoo.yorizori.dto.cookbook.Cookbook;

/**
 * 영속적 데이터 처리를 위한 다양한 기술(JDBC, JPA, iBatis, Hibernate 등)들을 
 * 일관된 방법(메소드 호출)으로 접근할 수 있도록 규약 메소드 선언
 *  * @author 김기정
 */
public interface CookbookDao {
	//등록
	public void regist(Cookbook cookbook) throws SQLException;
	public  List<Cookbook> view_All() throws SQLException;
	//제목과 설명 보여주기용
	public Cookbook view_All(String book_id) throws SQLException;
	
	public  List<Cookbook> view_mybook(String author_id) throws SQLException;
	public void modify(Cookbook cookbook) throws SQLException;
	
	
	public void delete(String book_id) throws SQLException;
	public void viewup(String book_id) throws SQLException;
	
	public List<Cookbook> top4view() throws SQLException;
	
	
}








