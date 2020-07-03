package com.lec.sts19_rest.board.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Boardlist {
	@JsonProperty("data")
	private List<BWriteDTO> list;
	private int page;
	private int count;
	private String message;
	private String status;
	private int totalpage;
	private int totalcnt;
	private int writepages;
	private int pagerows;
	public List<BWriteDTO> getList() {
		return list;
	}
	public void setList(List<BWriteDTO> list) {
		this.list = list;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getTotalcnt() {
		return totalcnt;
	}
	public void setTotalcnt(int totalcnt) {
		this.totalcnt = totalcnt;
	}
	public int getWritepages() {
		return writepages;
	}
	public void setWritepages(int writepages) {
		this.writepages = writepages;
	}
	public int getPagerows() {
		return pagerows;
	}
	public void setPagerows(int pagerows) {
		this.pagerows = pagerows;
	}
	
	
	
	
	
}
