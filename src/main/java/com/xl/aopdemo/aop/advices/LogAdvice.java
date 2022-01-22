package com.xl.aopdemo.aop.advices;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Aspect 注解用来定义一个切面类；
 * @Component 注解用来将这个切面类交给spring来管理；
 */
@Aspect
@Component
public class LogAdvice {

    /**
     * @Pointcut 注解用来定义切点；
     * 1，注解式，所有被GetMapping标注的方法，都会被植入切点的逻辑；
     * 2, 使用execution表达式定义切点位置；
     * 表达式语法：execution(* 包名.*.*(..))
     */
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    @Pointcut("execution(String com.xl.aopdemo.aop.controller.AopTestController.postTest(..))")
    private void logPointCut () {}


    /**
     * @Before： 在切点植入的方法前执行；
     */
//    @Before("logPointCut()")
    @Before("logPointCut()")
    private String logAdvice () {
        System.out.println("After-执行切点的逻辑！");
        return "1";
    }
}
