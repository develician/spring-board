package kr.yuhan.domain;

public class Criteria {
	private int page; // 페이지 번호
	private int perPageNum; // 한 페이지당 글의 개수

	public Criteria() {
		page = 1;
		perPageNum = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum >100) {
			this.perPageNum=10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	//limit 시작번호 반환하는 메소드
	public int getPageStart() {
		return (page-1)*perPageNum;
	}
}
