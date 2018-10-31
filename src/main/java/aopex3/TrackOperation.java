package aopex3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TrackOperation {
	@Pointcut("execution(* Operation.*(..))")
	public void aopeg() {}

	@Before("aopeg()")
	public void myAdvice(JoinPoint jp) {
		System.out.println("-- concern before method --");
	}
	@After("aopeg()")
	public void advice2(JoinPoint jp) {
		System.out.println("-- concern after method --"+jp.getSignature());
	}
}
