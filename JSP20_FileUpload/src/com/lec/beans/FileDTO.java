package com.lec.beans;

public class FileDTO {
	private int uid;  // bf_uid
	private String source; // bf_source
	private String file; // bf_file
	private boolean isImage; // 해당 파일이 이미지 여부인지 (요구사항에 첨부파일이 이미지인 경우만 웹에 보일 수 있도록 한다) --- DB 테이블에 없지만, 확인용으로 이렇게 변수 넣어서 사용해도 괜찮다. 
	
	public FileDTO() {
		super();
	}
	
	public FileDTO(int uid, String source, String file) {
		super();
		this.uid = uid;
		this.source = source;
		this.file = file;
//		this.isImage = isImage;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public boolean isImage() {
		return isImage;
	}
	public void setImage(boolean isImage) {
		this.isImage = isImage;
	}
	

}
