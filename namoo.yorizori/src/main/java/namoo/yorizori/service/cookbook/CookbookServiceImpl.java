package namoo.yorizori.service.cookbook;

import java.sql.SQLException;
import java.util.List;

import namoo.yorizori.common.factory.jdbcDaoFactory;
import namoo.yorizori.common.web.YZRuntimeException;
import namoo.yorizori.dao.cookbook.CookbookDao;
import namoo.yorizori.dao.cookbook.jdbcCookbookDao;
import namoo.yorizori.dto.cookbook.Cookbook;
import namoo.yorizori.dto.cookbook.Recipe;

public class CookbookServiceImpl implements CookbookService{
	CookbookDao cookbookDao = jdbcDaoFactory.getInstance().getCookbookDao();
	@Override
	public void registerCookbook(Cookbook cookbook) {
		try {
			cookbookDao.regist(cookbook);
		} catch (SQLException e) {
			throw new YZRuntimeException(e.getMessage());
		}
		
	}

	@Override
	public Cookbook findCookbookById(int bookid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cookbook> findCookbookByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Recipe findRecipeById(int recipeid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Recipe> findRecipeByAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
