
/* Drop Tables */

DROP TABLE test_card CASCADE CONSTRAINTS;
DROP TABLE test_ticket CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE test_card
(
	user_id varchar2(14) NOT NULL,
	buy_amount number DEFAULT 1
);


CREATE TABLE test_ticket
(
	user_id varchar2(20) NOT NULL,
	ticket_count number NOT NULL,
	CONSTRAINT ticket_buy_limit
	CHECK(ticket_count BETWEEN 1 AND 5)
);

SELECT * FROM test_card;
SELECT * FROM test_ticket;

-- ticket 2장을 카드로 결제하는 경우
INSERT INTO test_card VALUES ('aaa', 2); -- OK
INSERT INTO test_ticket VALUES ('aaa', 2); -- OK

-- ticket 5장을 카드로 결제하는 경우
INSERT INTO test_card VALUES ('aaa', 5); -- OK
INSERT INTO test_ticket VALUES ('aaa', 5); -- OK

-- ticket 5장을 카드로 결제하는 경우
INSERT INTO test_card VALUES ('aaa', 6); -- OK
INSERT INTO test_ticket VALUES ('aaa', 6); -- ORA-02290: check constraint (SCOTT0316.TICKET_BUY_LIMIT) violated




