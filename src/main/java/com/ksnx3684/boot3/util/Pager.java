package com.ksnx3684.boot3.util;

import lombok.Data;

@Data
public class Pager {
	
	// DB에서 한 페이지 당 몇개 씩 조회할지 결정(파라미터의 값으로도 가능)
	private Integer perPage;
	// DB에서 조회할 시작 인덱스 번호
	private Integer startRow;
	
	// 페이지 번호(파라미터의 값)
	private Integer pn;
	
	// ----- 검색 사용 변수 -----
	// 검색어(파라미터의 값)
	private String search;
	// 검색 종류(파라미터의 값)
	private String kind;
	
	// ----- jsp 사용 변수 -----
	private Long startNum;
	private Long lastNum;
	
	private boolean pre;
	private boolean next;
	
	
	public Integer getPerPage() {
		if(this.perPage == null || this.perPage < 1) {
			this.perPage = 10;
		}
		return this.perPage;
	}
	
	public void makeRow() {
		// pn : 1, perPage : 10, startRow : 0
		// pn : 2, perPage : 10, startRow : 10
		// pn : 3, perPage : 10, startRow : 20
		this.startRow = (this.getPn() - 1) * this.getPerPage();
	}
	
	public Integer getPn() {
		if(this.pn == null || this.pn < 1) {
			this.pn = 1;
		}
		return this.pn;
	}
	
	public String getSearch() {
		if(this.search == null) {
			this.search = "";
		}
		return search;
	}
	
	public void makeNum(Long totalCount) {
		// 1. 전체 row의 갯수 구하기
		
		// 2. 전체 페이지의 갯수 구하기
		Long totalPage = totalCount / this.getPerPage();
		if(totalCount % this.getPerPage() != 0) {
			totalPage++;
		}
		
		// 3. 블럭 당 갯수
		Long perBlock = 10L;
		
		// 4. 전체 블럭의 갯수 구하기
		Long totalBlock = totalPage / perBlock;
		if(totalPage % perBlock != 0) {
			totalBlock++;
		}
		
		// 5. Page번호로 현재 몇 번째 Block인지 계산
		Long curBlock = this.getPn() / perBlock;
		if(this.getPn() % perBlock != 0) {
			curBlock++;
		}
		
		// 6. curBlock으로 startNum, lastNum 구하기
		this.startNum = (curBlock - 1) * perBlock + 1;
		this.lastNum = curBlock * perBlock;
		
		// 7. 이전, 다음 블럭 유무
		this.pre = false;
		if(curBlock > 1) {
			this.pre = true;
		}
		
		this.next = false;
		if(totalBlock > curBlock) {
			this.next = true;
		}
		
		// 8. 현재 블럭이 마지막 블럭과 같다면
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
		
		// 9. 검색결과가 없어서 0일 때
		if(totalCount == 0) {
			this.lastNum = 0L;
		}
	}

}
