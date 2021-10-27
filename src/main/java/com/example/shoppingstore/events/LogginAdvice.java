package com.example.shoppingstore.events;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogginAdvice {

    Logger logger = LoggerFactory.getLogger(LogginAdvice.class);

    @Pointcut("execution(* com.example.shoppingstore.*.*.*.*(..))")
    void MyPointCut() {

    }

    @Around("MyPointCut()")
    public Object MyLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        String className = proceedingJoinPoint.getTarget().getClass().getName();

        logger.info("method invoked -" + methodName + " :" + className + " args ");

        Object object = proceedingJoinPoint.proceed();
        logger.info("method invoked -" + methodName + " :" + className + " args ");

        return object;
    }

}
