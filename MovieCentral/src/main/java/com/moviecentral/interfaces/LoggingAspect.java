/**
 * 
 */
package com.moviecentral.interfaces;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @author ravitejakommalapati
 *
 */
@Aspect
@Configuration
public class LoggingAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Pointcut("within(com.moviecentral..*..*)")
	public void befor(JoinPoint joinPoint) {
		logger.info(" Allowed execution for {}", joinPoint);
		
	}
}
