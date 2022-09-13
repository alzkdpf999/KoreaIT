package namoo.yorizori.service.cookbook;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import namoo.yorizori.common.factory.jdbcDaoFactory;
import namoo.yorizori.common.web.YZRuntimeException;
import namoo.yorizori.dao.cookbook.CookbookDao;
import namoo.yorizori.dao.cookbook.ProcedureDao;
import namoo.yorizori.dao.cookbook.RecipeDao;
import namoo.yorizori.dao.cookbook.jdbcCookbookDao;
import namoo.yorizori.dto.cookbook.Cookbook;
import namoo.yorizori.dto.cookbook.Procedure;
import namoo.yorizori.dto.cookbook.Recipe;

public class CookbookServiceImpl implements CookbookService{
	CookbookDao cookbookDao = jdbcDaoFactory.getInstance().getCookbookDao();
	RecipeDao recipeDao = jdbcDaoFactory.getInstance().getRecipeDao();
	ProcedureDao procedureDao = jdbcDaoFactory.getInstance().getProcedureDao();
	@Override
	// 책 등록
	public void registerCookbook(Cookbook cookbook) {
		try {
			cookbookDao.regist(cookbook);
		} catch (SQLException e) {
			throw new YZRuntimeException(e.getMessage());
		}
		
	}

	@Override
	//책 찾기
	public Cookbook findCookbookById(String bookid) {
		try {
			return cookbookDao.view_All(bookid);
		}catch (Exception e) {
			throw new YZRuntimeException(e.getMessage());
		}
	}

	@Override
	//책 리스트 
	public List<Cookbook> findCookbookByAll() {
		try {
			return cookbookDao.view_All();
		}catch (Exception e) {
			throw new YZRuntimeException(e.getMessage());
		}
	}

	@Override
	//레시피 저장
	public void registerRecipe(Recipe recipe) {
		try{
			recipeDao.regist(recipe);
		}catch (Exception e) {
			throw new YZRuntimeException(e.getMessage());
		}
	}

	@Override
	//상세보기
	public Recipe findRecipeById(int recipeid) {
		try {
			return recipeDao.detail(recipeid);
		}catch (Exception e) {
			throw new YZRuntimeException(e.getMessage());
		}
	}

	@Override
	public List<Recipe> findRecipeByAll() {
		try {
			return recipeDao.view_All();
		}catch (Exception e) {
			throw new YZRuntimeException(e.getMessage());
		}
	}

	@Override
	//요리 절차 저장
	public void registerProcedure(Procedure procedure) {
		try{
			procedureDao.regist(procedure);
		}catch (Exception e) {
			throw new YZRuntimeException(e.getMessage());
		}
	}

	@Override
	// 책 안에 레시피들
	public List<Recipe> findRecipeBybookId(int bookid) {
		try{
			return recipeDao.view_All(bookid);
		}catch (Exception e) {
			throw new YZRuntimeException(e.getMessage());
		}
	}

	@Override
	public List<Procedure> findProcedureByrecipeid(int recipeid) {
		try {
			return procedureDao.show(recipeid);	
		}catch (Exception e) {
			throw new YZRuntimeException(e.getMessage());
		}
		
	}

	@Override
	public List<String> findimageByrecipeid(int recipeid) {
		try {
			return recipeDao.image(recipeid);	
		}catch (Exception e) {
			throw new YZRuntimeException(e.getMessage());
		}
	}

	@Override
	public String[] findCookimage(String bookid) {
		try {
			return recipeDao.recipeId(bookid);	
		}catch (Exception e) {
			throw new YZRuntimeException(e.getMessage());
		}
	}

	@Override
	public void modifyrecipe(Recipe recipe) {
		try {
			recipeDao.modify(recipe);
		}catch (Exception e) {
			 throw new YZRuntimeException(e.getMessage());
		}
		
	}

	@Override
	public void modifyprocedure(HashMap<String, String> pcdMap, String recipeid) {
		try {
			procedureDao.modify(pcdMap, recipeid);
		} catch (Exception e) {
			throw new YZRuntimeException(e.getMessage());
		}
		
	}

	@Override
	public void modifyinsertprocedure(Procedure procedure) {
		try {
			procedureDao.modifyregist(procedure);
		} catch (Exception e) {
			throw new YZRuntimeException(e.getMessage());
		}
	}

	@Override
	public void modifydel(String[] num,String recipeid) {
		try {
			procedureDao.modifydel(num,recipeid);
		} catch (Exception e) {
			throw new YZRuntimeException(e.getMessage());
		}
		
	}

	@Override
	public void modifyCookbook(Cookbook cookbook) {
		try {
			cookbookDao.modify(cookbook);
		} catch (SQLException e) {
			throw new YZRuntimeException(e.getMessage());
		}
		
	}

	@Override
	public void delrecipe(String recipdeid) {
		try {
			recipeDao.delete(recipdeid);
		} catch (Exception e) {
			throw new YZRuntimeException(e.getMessage());
		}
	}

	@Override
	public void delcookbook(String book_id) {
		try {
			cookbookDao.delete(book_id);
		} catch (Exception e) {
			throw new YZRuntimeException(e.getMessage());
		}
		
	}

	@Override
	public void cookbookview(String book_id) {
		try {
			cookbookDao.viewup(book_id);
		} catch (Exception e) {
			throw new YZRuntimeException(e.getMessage());
		}
		
	}

	@Override
	public void recipeview(String recipeid) {
		try {
			recipeDao.viewup(recipeid);
		} catch (Exception e) {
			throw new YZRuntimeException(e.getMessage());
		}
		
	}

	@Override
	public List<Cookbook> top4Cookbook() {
		try {
			return cookbookDao.top4view();
		} catch (Exception e) {
			throw new YZRuntimeException(e.getMessage());
		}
		
	}

	@Override
	public List<Recipe> top4Recipe() {
		try {
			return recipeDao.top4view();
		} catch (Exception e) {
			throw new YZRuntimeException(e.getMessage());
		}
		
	}

	@Override
	public List<Cookbook> myCookbook(String author_id) {
		try {
			return cookbookDao.view_mybook(author_id);
		} catch (Exception e) {
			throw new YZRuntimeException(e.getMessage());
		}
	}

}
