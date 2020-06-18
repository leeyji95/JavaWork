package com.lec.spring;

import ex2_1.OperatorBean;

public class PlusOp implements OperatorBean {
	
	int operand1;
	int operand2;
	
	public PlusOp() {
		super();
		System.out.println("PlusOp() 기본 생성");
	}

	public PlusOp(int operand1, int operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}


	public int getOperand1() {
		return operand1;
	}

	public void setOperand1(int operand1) {
		this.operand1 = operand1;
	}

	public int getOperand2() {
		return operand2;
	}

	public void setOperand2(int operand2) {
		this.operand2 = operand2;
	}

	@Override
	public int doOperate() {
		return operand1 + operand2;
	}

}
