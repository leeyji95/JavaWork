package com.lec.emailauth.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.lec.emailauth.beans.EmailDTO;

@MapperScan
public interface EmailDAO {
	
	public int EmailInsert(@Param("email") String user_email);
	
	public int Key(String email, String user_key); // 인증키 저장
	
	public int SelectUid(@Param("email2") String email); // 해당 이메일로 uid 뽑기
	
	public int UpdateKey(int uid, String key); // key 바꾸기
	
}
