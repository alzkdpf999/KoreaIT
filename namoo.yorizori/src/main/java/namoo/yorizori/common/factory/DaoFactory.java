package namoo.yorizori.common.factory;

import namoo.yorizori.dao.cookbook.CookbookDao;
import namoo.yorizori.dao.cookbook.ProcedureDao;
import namoo.yorizori.dao.cookbook.RecipeDao;
import namoo.yorizori.dao.user.UserDao;

/**
 * DaoFactory에 대한 규약을 선언하는 인터페이스 
 * @author 정충효
 *
 */
public interface DaoFactory {
	
	public UserDao getUserDao();
	public CookbookDao getCookbookDao();
	public RecipeDao getRecipeDao();
	public ProcedureDao getProcedureDao();
}
