package ex3_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ex3_1.OperatorBean;

public class PlusOp implements OperatorBean {
	
	// @Qualifier  붙인 이유 operand1, 2 의 타입이 같으므
	
	@Autowired
	@Qualifier("operand1")
	Operand operand1;
	
	@Autowired
	@Qualifier("operand2")
	Operand operand2;

	public PlusOp() {
		super();
		System.out.println("PlusOp() 생성");
	}
	public PlusOp(Operand operand1, Operand operand2) {
		super();
		System.out.printf("PlusOp(%d, %d) 생성\n", 
					operand1.getValue(), operand2.getValue());
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	public Operand getOperand1() {
		return operand1;
	}

	public void setOperand1(Operand operand1) {
		this.operand1 = operand1;
	}

	public Operand getOperand2() {
		return operand2;
	}

	public void setOperand2(Operand operand2) {
		this.operand2 = operand2;
	}

	@Override
	public int doOperate() {
		return operand1.getValue() + operand2.getValue();
	}

	@Override
	public String toString() {
		return String.format("[PlusOp %s, %s]", operand1, operand2);
	}
	

}
