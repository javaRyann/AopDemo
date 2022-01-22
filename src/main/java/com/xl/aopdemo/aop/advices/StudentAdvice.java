package com.xl.aopdemo.aop.advices;

import com.alibaba.fastjson.JSONObject;
import com.xl.aopdemo.aop.vo.RestApiResultVo;
import com.xl.aopdemo.aop.vo.StudentQueryVo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class StudentAdvice {

    @Pointcut("@annotation(com.xl.aopdemo.aop.annotations.Permissions)")
    private void sutdentPointCut () {

    }

    @AfterReturning(pointcut = "sutdentPointCut()", returning = "student")
    private RestApiResultVo testAfterReturnning (JoinPoint joinPoint, RestApiResultVo student) throws Throwable {

        Signature signature = joinPoint.getSignature();
        String method = signature.getName();
        System.out.println("方法：" +method+"执行完毕，返回参数是："+ JSONObject.toJSONString(student));
        StudentQueryVo content = (StudentQueryVo)student.getContent();
        content.setAge("55555555555");

        return RestApiResultVo.ok(student);
    }
}
