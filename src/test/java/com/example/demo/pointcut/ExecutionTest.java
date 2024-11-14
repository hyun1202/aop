package com.example.demo.pointcut;

import com.example.demo.member.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.Method;

@Slf4j
public class ExecutionTest {

    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    Method helloMethod;

    @BeforeEach
    public void init() throws NoSuchMethodException {
        helloMethod = MemberServiceImpl.class.getMethod("hello", String.class);
    }

    @Test
    void printMethod() {
        log.info("helloMethod={}", helloMethod);
    }

    @Test
    void exactMatch() {
        // public java.lang.String com.example.demo.member.MemberServiceImpl.hello(java.lang.String)
        pointcut.setExpression("execution(public String com.example.demo.member.MemberServiceImpl.hello(String))");
        Assertions.assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void allMatch() {
        pointcut.setExpression("execution(* *(..))");
        Assertions.assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void nameMatch() {
        pointcut.setExpression("execution(* hello(..))");
        Assertions.assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void packageExactMatch1() {
        pointcut.setExpression("execution(* com.example.demo.member.MemberServiceImpl.hello(..))");
        Assertions.assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void packageExactMatch2() {
        pointcut.setExpression("execution(* com.example.demo.member.*.hello(..))");
        Assertions.assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void packageMatchSubPackage1() {
        pointcut.setExpression("execution(* com.example.demo.member..*.*(..))");
        Assertions.assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void packageMatchSubPackage2() {
        pointcut.setExpression("execution(* com.example.demo..*.*(..))");
        Assertions.assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void typeExactMath() {
        pointcut.setExpression("execution(* com.example.demo.member.MemberServiceImpl.*(..))");
        Assertions.assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    // 타입 매칭 - 부모 타입 허용
    @Test
    void typeMatchSuperType() {
        pointcut.setExpression("execution(* com.example.demo.member.MemberService.*(..))");
        Assertions.assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    // 부모 타입의 메서드만 허용
    @Test
    void typeMatchInternal() throws NoSuchMethodException {
        pointcut.setExpression("execution(* com.example.demo.member.MemberService.*(..))");

        Method internalMethod = MemberServiceImpl.class.getMethod("internal", String.class);
        Assertions.assertThat(pointcut.matches(internalMethod, MemberServiceImpl.class)).isFalse();
    }

    // 파라미터는 String 형식
    @Test
    void argsMatch() {
        pointcut.setExpression("execution(* *(String))");
        Assertions.assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    // 파라미터가 없어야함
    @Test
    void argsMatchNoArgs() {
        pointcut.setExpression("execution(* *())");
        Assertions.assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isFalse();
    }

    // 정확히 하나의 파라미터 허용, 모든 타입 허용
    @Test
    void argsMatchStar() {
        pointcut.setExpression("execution(* *(*))");
        Assertions.assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    // 숫자와 무관한 모든 파라미터, 모든 타입 허용
    @Test
    void argsMatchAll() {
        pointcut.setExpression("execution(* *(..))");
        Assertions.assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    // String 타입으로 시작, 숫자와 무관한 모든 파라미터, 모든 타입 허용
    @Test
    void argsMatchComplex() {
        pointcut.setExpression("execution(* *(String, ..))");
        Assertions.assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }
}
