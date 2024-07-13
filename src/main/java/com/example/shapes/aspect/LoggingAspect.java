package com.example.shapes.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    ConcurrentHashMap<String, AtomicInteger> beanCountMap = new ConcurrentHashMap<>();

    @Before("execution(* com.example.shapes.factory.ShapeFactory.getShape(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Before Method: {}", joinPoint.getSignature().getName());
        logger.info("Arguments: ");
        Arrays.stream(joinPoint.getArgs()).forEach(arg-> logger.info(" - {}", arg));
    }

    @After("execution(* com.example.shapes.factory.ShapeFactory.getShape(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("After Method: {}",joinPoint.getSignature().getName());
    }

    @Pointcut("execution(* com.example.shapes.*.init(..))")
    public void beanInit() {}

    @AfterReturning("beanInit()")
    public void logBeanCreation(JoinPoint joinPoint) {
        String beanName = joinPoint.getTarget().getClass().getSimpleName();
        AtomicInteger count = beanCountMap.computeIfAbsent(beanName, k->new AtomicInteger(0));
        int currentCount = count.incrementAndGet();
        logger.info("Bean type of {} has been created. Total Created: {}", beanName, currentCount);
    }
}
