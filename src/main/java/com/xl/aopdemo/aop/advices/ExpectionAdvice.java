package com.xl.aopdemo.aop.advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExpectionAdvice {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void expectionPointCut () {}

    @AfterThrowing(pointcut = "expectionPointCut()", throwing = "ex")
    private void expectionAdvice (JoinPoint joinPoint, Throwable ex) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();

        System.out.println("执行方法： "+name+"抛出了异常"+ex.getStackTrace());
    }
}
