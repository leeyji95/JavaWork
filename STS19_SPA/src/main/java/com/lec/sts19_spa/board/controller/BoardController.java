package com.lec.sts19_spa.board.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.sts19_spa.board.C;

@Controller
@RequestMapping("/board")
public class BoardController {
// 컨트롤러는 서버가 가동될 때 생성되며, 어디에? 스프링 컨테이너에 생성이 된다 .


	// MyBabatis
	private SqlSession sqlSession;

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		C.sqlSession = sqlSession;
	}

	public BoardController() {
		super();
		System.out.println("BoardController() 생성");
	}

	// REST 게시판
	@RequestMapping(value="/rest")
	public String rest() {
		System.out.println("board/rest 경로로...");
		return "board/rest";
	}
}
