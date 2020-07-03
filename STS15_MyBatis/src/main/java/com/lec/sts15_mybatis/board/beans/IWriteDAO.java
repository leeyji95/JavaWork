package com.lec.sts15_mybatis.board.beans;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface IWriteDAO {
	// 지금 뭐 했다? 
	// DAO 를 Interface 로 만들어 셋팅해둔 것이다.
	// BWriteDAO 에 있는 메소드들 모두 복사해서 추상메소드 만들어두자.
	// MyBatis 를 사용하면 BWriteDAO 지워도 동작한다. 
	public List<BWriteDTO> select();
	public int insert(final BWriteDTO dto);
	public int insert(String subject, String content, String name);
	
	//public List<BWriteDTO> readByUid(final int uid);
	public List<BWriteDTO> selectByUid(final int uid);
	public int incViewCnt(int uid); // 조회수 증가 
	public int update(final BWriteDTO dto) ;
	
	public int update(int uid, @Param("a") BWriteDTO dto); // a 에 있는 content , subject 를 의미, // 특정 파라미터 dp qufaud qnxdutj tkdydgksek. 
	
	public int deleteByUid(final int uid);
	
}
