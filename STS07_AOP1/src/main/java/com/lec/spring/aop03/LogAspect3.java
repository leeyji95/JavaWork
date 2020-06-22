package com.lec.spring.aop03;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspect3 {
	
	@Pointcut("within(com.lec.spring.aop03.*)")
	public void pc1() {}

	@Pointcut("within(com.lec.spring.aop02.*)")
	public void pc2() {}

	@Pointcut("execution(* com.lec.spring.aop*.My*.*Action(..))")
	public void pc3() {}
	
	@Pointcut("execution(* com.lec.spring.*3.My*.do*(..))")
	public void pc4() {}
	
	
//	@Before("pc1()") // 3, 4, 5, 6, 7, 8 
//	@Before("pc2()") // 1, 2
//	@Before("pc3()") // 1 2 3 5 6 8
//	@Before("pc4()") // 3 4 6 7
//	@Before("pc1() || pc2()") //  12345678
//	@Before("pc1() && pc2()") // X
//	@Before("!pc1()") // 1 2
//	@Before("pc3() && !pc4()") // 1 2 5 8
	@Before("!(pc3() && pc4())")
	public void beforeAdvice() {
		System.out.print("[Advice] ");
	}
	
	
	

} // end LogAspect3
