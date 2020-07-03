package com.lec.sts19_rest.ticket;

public interface ITicketDAO {
	// 트랜젝션 수행하는 메소드 
	// 아래 2개의 동작이 하나의 트랜젝션으로 처리 되어야함
	int insertCard(String userId, int buyAmount);
	int insertTicket(String userId, int ticketCount);
}
