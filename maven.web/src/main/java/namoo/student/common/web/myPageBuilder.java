package namoo.student.common.web;

/**
 * 페이징 처리에 필요한 정보 계산
 * @author 정충ㅎ
 */
public class myPageBuilder {
	
	// 연산에 필요한 속성들
	private Params params;            /** 여러개의 전달인자 포장 */
	private int cnt;             /** 테이블로부터 검색된 행의 수 */
	
	// 연산 결과 저장을 위한 속성들
	private int pageCount;            /** 페이지 수 */
	private int listNo;               /** 목록별 식별번호 */
	private int startPage;            /** 현재 페이지 목록의 시작 번호 */
	private int endPage;              /** 현재 페이지 목록의 마지막 번호 */
	private int nextStartPage;        /** 다음 페이지 목록의 마지막 번호 */
	public myPageBuilder() {}
	
	/**
	 * @param params           요청 파라메터
	 * @param totalRowCount    검색타입별 검색된 행의 수
	 */
	public myPageBuilder(Params params, int cnt ) {
		this.params = params;
		this.cnt = cnt;
	}
	
	/** setter/getter method */
	public Params getParams() {
		return params;
	}

	public void setParams(Params params) {
		this.params = params;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getListNo() {
		return listNo;
	}

	public void setListNo(int listNo) {
		this.listNo = listNo;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	
	public int getNextStartPage() {
		return nextStartPage;
	}

	public void setNextStartPage(int nextStartPage) {
		this.nextStartPage = nextStartPage;
	}
	
	@Override
	public String toString() {
		return "myPageBuilder [params=" + params + ", cnt=" + cnt + ", pageCount=" + pageCount + ", listNo="
				+ listNo + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}

	/** 페이징 계산 */
	public void build(){
		// DB로부터 검색된 행의 수에 따른 전체페이지수 계산
		pageCount = (int)Math.ceil((double)cnt / params.getSearchList());
		
		// 목록별 번호
		listNo = (params.getPage() - 1) / params.getPageSize();
		//(1~5): 0, (6~10): 1, (11~15): 2, .....
		
		// 현재 목록의 시작페이지번호와 마지막페이지번호 계산
		startPage = (listNo * params.getPageSize()) + 1;
		endPage = (listNo * params.getPageSize()) + params.getPageSize();
		
		//다음 목록 시작점
		nextStartPage = startPage + params.getPageSize();
		if (endPage > pageCount){
			endPage = pageCount;
		}
	
	}
	public boolean pageListLessOne() {
		return params.getPage() <= 1;
	}
	public boolean  pageListEqPageCount() {
		return params.getPage() == pageCount;
	}
	public boolean pageListEqEndPage() {
		return params.getPage() == endPage;
	}
	
	/** 동적 쿼리스트링 반환 */
	public String getQueryString(int page) {
		String queryString = "?page=" + page +"&searchList=" + params.getSearchList()+ "&type=" + params.getSearchType() + "&value=" + params.getSearchValue(); 
		return queryString;
	}
	
	
	
}
