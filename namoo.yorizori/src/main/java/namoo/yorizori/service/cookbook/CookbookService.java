package namoo.yorizori.service.cookbook;

import java.util.HashMap;
import java.util.List;

import namoo.yorizori.dto.cookbook.Cookbook;
import namoo.yorizori.dto.cookbook.Procedure;
import namoo.yorizori.dto.cookbook.Recipe;

/**
 * 요리책 관리 서비스
 * @author 김기정
 *
 */
public interface CookbookService {
	public void registerCookbook(Cookbook cookbook);
	public Cookbook findCookbookById(String bookid);
	public List<Cookbook> findCookbookByAll();
	public void registerRecipe(Recipe recipe);
	public List<Recipe> findRecipeBybookId(int bookid);
	public Recipe findRecipeById(int recipeid);
	public List<Recipe> findRecipeByAll();
	public void registerProcedure(Procedure procedure);
	public List<Procedure> findProcedureByrecipeid(int recipeid);
	public List<String> findimageByrecipeid(int recipeid);
	public String[] findCookimage(String bookid);
	
	public void modifyrecipe(Recipe recipe);
	
	public void modifyprocedure(HashMap<String, String> pcdMap, String recipeid);
	public void modifyinsertprocedure(Procedure procedure);
	public void modifydel(String[] num,String recipeid);
	public void modifyCookbook(Cookbook cookbook);
	
	public void delrecipe(String recipdeid);
	public void delcookbook(String book_id);
	
	public void cookbookview(String book_id);
	public void recipeview(String recipeid);
	
	public List<Cookbook> top4Cookbook();
	public List<Recipe> top4Recipe();
	
	public List<Cookbook> myCookbook(String author_id);
}
