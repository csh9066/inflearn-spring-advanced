package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Slf4j
@Aspect
public class Aspect5 {

    @Around("hello.aop.order.aop.PointCuts.allOrderAndAllService()")
    private Object executeTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            log.info("[around] [트랜잭션 시작] {}", joinPoint.getSignature());
            Object proceed = joinPoint.proceed(joinPoint.getArgs());
            log.info("[around] [트랜잭션 커밋] {}", joinPoint.getSignature());
            return proceed;
        } catch (Exception e) {
            log.info("[around] [트랜잭션 롤백] {}", joinPoint.getSignature());
            throw e;
        } finally {
            log.info("[around] [리소스 릴리즈] {}", joinPoint.getSignature());
        }
    }

    @Before("hello.aop.order.aop.PointCuts.allOrderAndAllService()")
    private void doBefore(JoinPoint joinPoint) throws Throwable {
        log.info("[before] {}", joinPoint.getSignature());
    }

    @AfterReturning(value = "hello.aop.order.aop.PointCuts.allOrderAndAllService()", returning = "result")
    private void doReturning(JoinPoint joinPoint, Object result) throws Throwable {
        log.info("[return] {} return={}", joinPoint.getSignature(), result);
    }

    @AfterThrowing(value = "hello.aop.order.aop.PointCuts.allOrderAndAllService()", throwing = "ex")
    private void doThrowing(JoinPoint joinPoint, Exception ex) {
        log.info("[throwing] {} exception={}", joinPoint.getSignature(), ex.getMessage());
    }

    @After(value = "hello.aop.order.aop.PointCuts.allOrderAndAllService()")
    private void doAfter(JoinPoint joinPoint) {
        log.info("[after] {}", joinPoint.getSignature());
    }
}
