package com.lec.spring.aop02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.lec.beans.Logger;

// Aspect : Advisor 들을 모아놓은 객체
// Advisor : Advice + Pointcut
// Advice : 공통기능(메소드)

// 이 클래스가 Aspect 역할을 할 클래스 임을 명시 
@Aspect
public class LogAspect {
	// 특정 포인트컷을 pc1 이라는 이름으로 정의한 것
	@Pointcut ("within(com.lec.spring.aop02.*)")
	public void pc1() {}
	
	@Pointcut ("within(com.lec.spring.aop02.*)")
	public void pc2() {}

//	@Before("within(com.lec.spring.aop02.*)") // <-- 얘가 pointcut // aop02 에 있는 모든 클래스 안에 있는 메소드가 호출되기 전에 호출된다.
	@Before("pc1()")
	public void beforeAdvice() { // 이 메소드가 Advice
		System.out.print("[Before] ");
		new Logger().logIn(); // 공통코드. Advice!
	}
	// --> 요 덩어리가 Advisor

//	@After("within(com.lec.spring.aop02.*)")
//	@After("execution(* com.lec.spring.aop02.MyService22.*(..))") // 정확히 MyService22 밑에 있는 메소드 수행 후 실행됨.
//	@After("pc2()")
	@After("execution(* com.lec.spring.aop02.*2.*(..))")
	public void afterAdvice() {
		System.out.println("[After] ");
		new Logger().logOut();
	}

	// Around advice : 메소드 실행을 제어하는 가장 강력한 코드
	// 직겁 해당 메소드를 호출하고 결과나 예외 처리도 가능.
	@Around("within(com.lec.spring.aop02.*)") // 특정한 클래ㅡㅅ 안에 메소드들이 호출될 떄
	public Object aroundAdivce(ProceedingJoinPoint joinPoint) throws Throwable {
		// joinPoint 메소드 이름
		String signatureStr = joinPoint.getSignature().toShortString();

		// joinPoint 메소드 수행 전
		System.out.println("[Around] " + signatureStr + " 시작");
		long st = System.currentTimeMillis(); // 시작시간 기록

		// joinPoint 메소드 수행
		try {
			Object obj = joinPoint.proceed(); // Object 타입으로 리천 , try catch 감싸주기 // 어느 포인트에서 실행할지 알아서 껴맞춰 들어간다?>
			return obj;
		} finally {
			// joinPoint 메소드 수행 후
			long et = System.currentTimeMillis(); // 종료시간 기록 ( 핵심기능이 수행되는시간 체크하기 위해)
			System.out.println("[Around] " + signatureStr + " 종료,  경과시간: " + (et - st));
		}

	} // end aroundAdvice()

}
