package com.codeplay.scholamate.aspect;

import java.time.Duration;
import java.time.Instant;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    @Around("execution(* com.codeplay.scholamate..*.*(..))")
    public Object logDuration(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info(joinPoint.getSignature().toString() + " method execution started");
        Instant start = Instant.now();
        Object returnObj = joinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        log.info("Time took to execute " + joinPoint.getSignature().toString() + " method is : " + timeElapsed);
        log.info(joinPoint.getSignature().toString() + " method execution ended");
        return returnObj;
    }

    @AfterThrowing(value = "execution(* com.codeplay.scholamate..*.*(..))", throwing = "ex")
    public void logException(ProceedingJoinPoint joinpoint, Exception ex) {
        log.error(joinpoint.getSignature() + " - an exception happened due to : " + ex.getMessage());
    }
}
