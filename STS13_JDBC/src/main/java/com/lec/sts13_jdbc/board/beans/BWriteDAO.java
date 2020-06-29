package com.lec.sts13_jdbc.board.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.lec.sts13_jdbc.board.C;

public class BWriteDAO {
	JdbcTemplate template;
	
	public BWriteDAO() {
		this.template = C.template;  // 이미 만들어져 있는(controller에) template 가져온다. 
	}
	
	
	// 전체 SELECT 
	public List<BWriteDTO> select(){
		
		return template.query(C.SQL_WRITE_SELECT, // SQL 쿼리문
				new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class)); // 각각의 레코드를 DTO에 담는다. (쿼리문의 컬럼명이 BWriteDTO 의 멤버변수, 정확히 게터세터와 일치하기때문에 정확히 매칭해서 자동으로 끼워넣어준다.)
		
	}
	
	// update() 는 두 가지 방식을 사용해서 insert 할 수 있다.는 것을 보여주기 위해 
	public int insert(final BWriteDTO dto) { // effective ...
		/* 이거는 setter 방식으로 insert 한 것
		// 1. update() + PreparedStatementSetter() 사용한 것 
		return 
		template.update(C.SQL_WRITE_INSERT, new PreparedStatementSetter() {
			// 인터페이스는 new 못하는데 햇다? -> 익명클래스 해주자 
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getSubject());
				ps.setString(2, dto.getContent());
				ps.setString(3, dto.getName());
			}
		});
		*/

		// update() + 에다가 PreparedStatementCreator() 사용하여 insert 메소드 작성하기 
		return
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				PreparedStatement ps = con.prepareStatement(C.SQL_WRITE_INSERT);
				ps.setString(1, dto.getSubject());
				ps.setString(2, dto.getContent());
				ps.setString(3, dto.getName());
				
				return ps;
			}
		});
	}
	
	public BWriteDTO readByUid(int uid) {
		return template.query(C.SQL_WRITE_SELECT_BY_UID);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
