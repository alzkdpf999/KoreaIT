package namoo.springJPA.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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
}
