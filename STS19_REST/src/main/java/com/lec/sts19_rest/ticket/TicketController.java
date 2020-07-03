package com.lec.sts19_rest.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ticket")
public class TicketController {
	@Autowired
	TicketService ticketService;
	
	@RequestMapping("/buy_ticket")
	public String buy_ticket() {
		return "ticket/buy_ticket";
	}
	
	// 티켓 구매 처리(트렌젝션)
	@RequestMapping("buy_ticket_card")
	public String buy_ticket_card(TicketDTO dto, Model model) {
		
		String page = "ticket/buy_ticket_done";
		
		try {
			ticketService.buyTicket(dto); // 트랜젝션 수행
			model.addAttribute("ticketInfo", dto);
		}catch (Exception e) {
			e.printStackTrace();
			page = "ticket/buy_ticket_fail"; // 오류 발생시 페이지 이동
		}
		
		
		
		return page;
	}
	
}
