package namoo.springJPA.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//공통 관심사항(공통 기능) 정의
// 하나 이상의 Advice(공통기능)와 Pointcut(기능을 적용하는 조건) 정의

@Component
@Aspect
public class TimeTraceAspect {
	// 메소드 실행시간
	//적용할 advice 정의
	@Around("execution(* namoo.springJPA..*(..))")
	public Object methodTimeTrace(ProceedingJoinPoint jointPoint)  throws Throwable{
		long start = System.currentTimeMillis();
		String bizObject = jointPoint.getTarget().getClass().getName();
		String bizMethod = jointPoint.getSignature().toShortString();
		System.out.println(bizObject + "객체의" + bizMethod + "메소드 시작");

		try {
			//핵심 비즈니스 객체의 메소드 호출
			return jointPoint.proceed();
		}finally {
			long finish =System.currentTimeMillis();
			long timeMs = finish - start;
			System.out.println("실행시간 :" + timeMs+"Ms");
			System.out.println(bizObject + "객체의"+ bizMethod+"메소드 종료");
		}
	}
	@Before("execution(* namoo.springJPA.Service..*(..))")
	public void starLog() {
		System.out.println("비즈니스 메소드 실행 전");
	}
	@After("execution(* namoo.springJPA.Service..*(..))")
	public void endLog() {
		System.out.println("비즈니스 메소드 실행 후");
	}

	@AfterReturning(pointcut = "execution(* namoo.springJPA.Service..*(..))", returning = "returnValue")
	public void afterReturningLog(JoinPoint joinPoint, Object returnValue) {
	System.out.println(">> 실행 메소드 반환값: " + returnValue);
	} 
	
	
	@AfterThrowing(pointcut = "execution(* namoo.springJPA.Service..*(..))", throwing = "exception")
	public void afterThrowingLog(JoinPoint joinPoint, Throwable exception) {
	System.out.println(">> " + joinPoint.getSignature().toShortString() + " 메소드 예외발생 : " + exception);
	}
	
}
