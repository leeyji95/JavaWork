package project.booksearch;

import java.io.Serializable;
import java.util.ArrayList;

public class InfoStore implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7694560157099497620L;
	private String storeName = "";  // 서점명
	private ArrayList<InfoBook> list = new ArrayList<InfoBook>();  // 검색결과 서적 리스트
	
	// 생성자
	public InfoStore() {}
	public InfoStore(String storeName, ArrayList<InfoBook> list) {
		super();
		this.storeName = storeName;
		this.list = list;
	}
	// getter & setter
	public String getStoreName() {return storeName;}
	public void setStoreName(String storeName) {this.storeName = storeName;}
	public ArrayList<InfoBook> getList() {return list;}
	public void setList(ArrayList<InfoBook> list) {this.list = list;}
	
	@Override
	public String toString() {
		String result = storeName + "[" + list.size() + "개 검색]\n";
		
		for(InfoBook e : list) {
			result += e.toString() + "\n";
		}
		
		return result;
	}
	
	
	
	
	
	
	
}



