package com.xl.aopdemo.aop.advices;

import com.xl.aopdemo.aop.vo.RestApiResultVo;
import com.xl.aopdemo.aop.vo.StudentQueryVo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Aspect
@Component
@Order(1)
public class PermissionAdvice {

    @Pointcut("@annotation(com.xl.aopdemo.aop.annotations.Permissions)")
    private void permissionsPointCut() {

    }


    @Around("permissionsPointCut()")
    private RestApiResultVo permissionsAdvice (ProceedingJoinPoint joinPoint) throws Throwable{
        Object[] args = joinPoint.getArgs();
        StudentQueryVo student = (StudentQueryVo) args[0];
        if (!Objects.equals(student.getName(),"admin")) {
            return RestApiResultVo.fail("0004","不是管理员用户");
        }
        // Around 环绕增强，可以动态改变返回值；
        student.setAge("1000000");
        args[0] = student;
        return (RestApiResultVo) joinPoint.proceed(args);
    }

}
