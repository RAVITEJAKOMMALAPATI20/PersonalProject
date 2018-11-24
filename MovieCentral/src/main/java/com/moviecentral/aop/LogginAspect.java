/**
 * 
 */
package com.moviecentral.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author ravitejakommalapati
 *
 */
@Aspect
@Component
public class LogginAspect {
	Logger logger = LoggerFactory.getLogger(LogginAspect.class);
	
	@Before("execution(* com.moviecentral..*..*(..))")
	public void logBefore(JoinPoint joinPoint) throws Throwable {
		logger.info("Entered the"+joinPoint.getTarget().getClass().getName()+"--Method Name :-"+joinPoint.getSignature().getName());
	//	joinPoint.proceed();
	//	logger.debug("Exit the"+joinPoint.getTarget().getClass().getName()+"--Method Name :-"+joinPoint.getSignature().getName());

	}
	
}
