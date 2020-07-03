package com.lec.sts19_rest.ticket;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.lec.sts19_rest.board.C;

public class TicketService {
	
	//mybatis
	private SqlSession sqlSession;
	
	@Autowired
	protected void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// transaction Template 사용
	private TransactionTemplate transactionTemplate;
	
	@Autowired
	protected void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
	// 하나의 트랜젝션 정의
	public void buyTicket(final TicketDTO dto) {
		// MyBatis 를 사용하여 이 트랜젝션 안의 여러 동작(쿼리들) 실행
		// 중간에 실패하면 트랜젝션 실패하고 자동으로 rollback 된다
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			
			// 두개중 하나라도 실패하면 롤백된당
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				ITicketDAO dao = C.sqlSession.getMapper(ITicketDAO.class);
				dao.insertCard(dto.getUserId(), dto.getTicketCount());
				dao.insertTicket(dto.getUserId(), dto.getTicketCount());
				
			}
		});
	}
	
	
	
	
}
