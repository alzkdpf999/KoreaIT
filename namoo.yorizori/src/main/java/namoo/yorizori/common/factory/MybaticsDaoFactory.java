package namoo.yorizori.common.factory;

import namoo.yorizori.dao.cookbook.CookbookDao;
import namoo.yorizori.dao.cookbook.ProcedureDao;
import namoo.yorizori.dao.cookbook.RecipeDao;
import namoo.yorizori.dao.user.UserDao;
/**
 *	Mybatics 기술을 이용하는 Dao 객체를 생성하는 팩토리 
 * @author 정충효
 *
 */
public class MybaticsDaoFactory implements DaoFactory {

	@Override
	public UserDao getUserDao() {
		return null;
	}

	@Override
	public CookbookDao getCookbookDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecipeDao getRecipeDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProcedureDao getProcedureDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
