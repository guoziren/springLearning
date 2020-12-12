package com.ustc.anno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect  //标注当前类是一个切面类
public class MyAspect {

    @Before("execution(* com.ustc.anno.Target.*(..))")
    public void before() {
        System.out.println("前置增强");
    }
}
