package namoo.yorizori.dto.cookbook;

public class Procedure {
	private String recipe_id;
	private int seq_num;
	private String pcd;
	
	public Procedure() {
		this(null,0,null);
	}
	public Procedure(String recipe_id, int seq_num, String pcd) {
		this.recipe_id = recipe_id;
		this.seq_num = seq_num;
		this.pcd = pcd;
	}
	public String getPcd() {
		return pcd;
	}
	public void setPcd(String pcd) {
		this.pcd = pcd;
	}
	public String getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(String recipe_id) {
		this.recipe_id = recipe_id;
	}
	public int getSeq_num() {
		return seq_num;
	}
	public void setSeq_num(int seq_num) {
		this.seq_num = seq_num;
	}
	
	
}
