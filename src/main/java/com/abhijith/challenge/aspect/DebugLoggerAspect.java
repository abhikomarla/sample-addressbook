package com.abhijith.challenge.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DebugLoggerAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @SuppressWarnings({ "squid:S00112" })
    @Around("execution(* com.abhijith.challenge.controller..*(..))")
    public Object requestHandler(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        Object response;

        Object[] request = proceedingJoinPoint.getArgs();
        String className = proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = proceedingJoinPoint.getSignature().getName();

        logger.debug("{}.{} Entry - args() : {}", className, methodName, request);

        response = proceedingJoinPoint.proceed();

        logger.debug("{}.{} Exit - Returned : {}", className, methodName, response);

        long duration = System.currentTimeMillis() - start;
        logger.debug("{}.{} took {} ms", className, methodName, duration);

        return response;
    }
}