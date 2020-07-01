package com.lec.sts15_mybatis.board.beans;

import java.util.List;

public interface IWriteDAO {
	public List<BWriteDTO> select();
	public int insert(final BWriteDTO dto);
	public int insert(String subject, String content, String name);
	
	//public List<BWriteDTO> readByUid(final int uid);
	public List<BWriteDTO> selectByUid(final int uid);
	public int incViewCnt(int uid); // 조회수 증가 
	public int update(final BWriteDTO dto) ;
	public int deleteByUid(final int uid);
	// BWriteDAO 에 있는 메소드들 모두 복사해서 추상메소드 만들어두자.
	// MyBatis 를 사용하면 BWriteDAO 지워도 동작한다. 
	
	// 지금 뭐 했다? 
	// DAO 를 Interface 로 만들어 셋팅해둔 것이다.
	
	
}
