package namoo.yorizori.dto.cookbook;

/**
 * Recipe DTO
 * 
 * @author 김기정
 *
 */
public class Recipe {
	private String recipe_id;
	private String book_id;
	private String recipe_name;
	private String recipe_time;
	private String recipe_level;
	private String ingredients;
	private String img_cont_type;
	private String img_file_name;
	private String writer_id;
	
	/**
	 * @param recipe_id
	 * @param book_id
	 * @param recipe_name
	 * @param recipe_time
	 * @param recipe_level
	 * @param ingredients
	 * @param img_cont_type
	 * @param img_file_name
	 * @param writer_id
	 */
	public Recipe(String recipe_id,String book_id,String recipe_name,String recipe_time,String recipe_level,String ingredients,String img_cont_type,String img_file_name,String writer_id) {
		this.recipe_id = recipe_id;
		this.book_id = book_id;
		this.recipe_name = recipe_name;
		this.recipe_time = recipe_time;
		this.recipe_level = recipe_level;
		this.ingredients = ingredients;
		this.img_cont_type = img_cont_type;
		this.img_file_name = img_file_name;
		this.writer_id = writer_id;
	}

	
	public String getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(String recipe_id) {
		this.recipe_id = recipe_id;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getRecipe_name() {
		return recipe_name;
	}
	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}
	public String getRecipe_time() {
		return recipe_time;
	}
	public void setRecipe_time(String recipe_time) {
		this.recipe_time = recipe_time;
	}
	public String getRecipe_level() {
		return recipe_level;
	}
	public void setRecipe_level(String recipe_level) {
		this.recipe_level = recipe_level;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getImg_cont_type() {
		return img_cont_type;
	}
	public void setImg_cont_type(String img_cont_type) {
		this.img_cont_type = img_cont_type;
	}
	public String getImg_file_name() {
		return img_file_name;
	}
	public void setImg_file_name(String img_file_name) {
		this.img_file_name = img_file_name;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
}
