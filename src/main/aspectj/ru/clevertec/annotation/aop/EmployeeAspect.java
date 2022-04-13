package ru.clevertec.annotation.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class EmployeeAspect {

    @Around("@annotation(ru.clevertec.annotation.aop.MyLogger)")
    public Object aroundAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Method " + joinPoint.getSignature().getName() + " has been called with args : " + Arrays.toString(joinPoint.getArgs()));
        Object proceed = joinPoint.proceed();
        System.out.println("Return result :" + proceed);
        return proceed;
    }
}
