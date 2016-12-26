package com.hull.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/12/5.
 */

@Component
@Aspect
public class MyLog {
    //    @Pointcut("execution(* com.hull.service.*.select*(..))")
    @Pointcut("execution(* com.hull.service.*.*(..))")
    public void checkServer(){
        System.out.println("**************The System is Searching Information For You****************");
    }

    @Before("checkServer() && args(name)")//声明前置通知
    public void doBefore(String name) {
        System.out.println("前置通知");
        System.out.println("---" + name + "---");
    }

    @AfterReturning(pointcut = "checkServer()", returning = "result")//声明后置通知
    public void doAfterReturning(String result) {
        System.out.println("后置通知");
        System.out.println("---" + result + "---");
    }

    @AfterThrowing(pointcut = "checkServer()", throwing = "e")//声明例外通知
    public void doAfterThrowing(Exception e) {
        System.out.println("例外通知");
        System.out.println(e.getMessage());
    }

    @After("checkServer()")
    public void afterCheck(){
        System.out.println(">>>>>>>>　最终通知 ..........");
    }

    @Around("checkServer()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("进入方法---环绕通知");
        Object o = pjp.proceed();
        System.out.println("退出方法---环绕通知");
        return o;
    }
}
