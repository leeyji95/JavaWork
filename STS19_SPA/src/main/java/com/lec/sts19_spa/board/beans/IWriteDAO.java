package com.lec.sts19_spa.board.beans;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface IWriteDAO {
	public List<BWriteDTO> select();
	public int insert(final BWriteDTO dto);
	public int insert(String subject, String content, String name);
	
	//public List<BWriteDTO> readByUid(final int uid);
	public List<BWriteDTO> selectByUid(final int uid);
	public int incViewCnt(int uid); // 조회수 증가 
//	public int update(final BWriteDTO dto) ;
//	public int update(int uid, @Param("a") BWriteDTO dto);
	public int update(int uid, String subject, String content);
//	public int deleteByUid(final int uid);
	// 특정 uid 글(들) 삭제하기(오버로딩)
	public int deleteByUid(int[] uids);
	// BWriteDAO 에 있는 메소드들 모두 복사해서 추상메소드 만들어두자.
	// MyBatis 를 사용하면 BWriteDAO 지워도 동작한다. 
	
	// 지금 뭐 했다? 
	// DAO 를 Interface 로 만들어 셋팅해둔 것이다.
	
	// total 개수
	public int countAll();
	
	// fromRow 부터 ~ pageRows 전까지의 페이지 내용 뽑기 
	public List<BWriteDTO> selectFromRow(final int from, final int rows);
	
}
