package com.lec.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

// POJO(포조) : Plain Old Java Object
// 
public class AjaxWriteListJson {

	int count; // 데이터 개수
	String status; // 처리 결과
	
	@JsonIgnore
	String memo; // response 에서 제외할 필드 
	
	@JsonProperty("data") // Json property  이름과 Java 
	List<WriteDTO> list;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public List<WriteDTO> getList() {
		return list;
	}

	public void setList(List<WriteDTO> list) {
		this.list = list;
	}
	
} // end class



