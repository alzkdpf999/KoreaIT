package namoo.student.common.web;

/**
 * 여러개의 요청파라메터들을 포장하기 위한 Wrapper 클래스
 * {사용자 선택페이지, 한페이지에 출력하는 행의 개수, 출력 페이지 개수, 검색유형, 검색값 등}
 * @author 김기정
 */
public class Params {
	private int page;            /** 사용자 선택 페이지 */
	private int searchList=10;        /** 조회 목록 개수 */
	private int pageSize=3; /** 출력 페이지 개수 */
	private String sortType="ssn";
	private String searchType="all";   /** 검색 유형 */
	private String searchValue;  /** 검색 값 */
	private String seq = "order";
	
	public Params() {
		this(1,10,3,"ssn","all",null,"order");
	}
	
	
	public Params(int page, int searchList,int pageSize,String sortType, String searchType, String searchValue,String seq) {
		this.page = page;
		this.searchList = searchList;
		this.pageSize = pageSize;
		this.sortType = sortType;
		this.searchType = searchType;
		this.searchValue = searchValue;
		this.seq = seq;
	}

	public String getSeq() {
		return seq;
	}


	public void setSeq(String seq) {
		this.seq = seq;
	}


	public String getSortType() {
		return sortType;
	}


	public void setSortType(String sortType) {
		this.sortType = sortType;
	}


	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSearchList() {
		return searchList;
	}

	
	
	public int getPageSize() {
		return pageSize;
	}


	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	@Override
	public String toString() {
		return "Params [page=" + page + ", searchList=" + searchList + ", pageSize=" + pageSize + ", searchType="
				+ searchType + ", searchValue=" + searchValue + "]";
	}

	
}
