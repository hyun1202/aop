package com.example.demo.pointcut;

import com.example.demo.member.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.Method;

@Slf4j
public class ArgsTest {

    Method helloMethod;

    @BeforeEach
    public void init() throws NoSuchMethodException {
        helloMethod = MemberServiceImpl.class.getMethod("hello", String.class);
    }

    private AspectJExpressionPointcut pointcut(String expression) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(expression);
        return pointcut;
    }

    // 객체 타입 매칭
    @Test
    void argsVsExecution() {
        Assertions.assertThat(
                pointcut("args(Object)").matches(helloMethod, MemberServiceImpl.class)
        ).isTrue();

        Assertions.assertThat(
                pointcut("args(java.io.Serializable)").matches(helloMethod, MemberServiceImpl.class)
        ).isTrue();

        Assertions.assertThat(
                pointcut("execution(* *(String))").matches(helloMethod, MemberServiceImpl.class)
        ).isTrue();

        Assertions.assertThat(
                pointcut("execution(* *(java.io.Serializable))").matches(helloMethod, MemberServiceImpl.class)
        ).isFalse();

        Assertions.assertThat(
                pointcut("execution(* *(Object))").matches(helloMethod, MemberServiceImpl.class)
        ).isFalse();
    }
}
