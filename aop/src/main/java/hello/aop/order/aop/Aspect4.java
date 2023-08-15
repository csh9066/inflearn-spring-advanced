package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class Aspect4 {

    @Around("hello.aop.order.aop.PointCuts.allOrder()")
    public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("[log] {}", joinPoint.getSignature());
        return joinPoint.proceed();
    }

    @Around("hello.aop.order.aop.PointCuts.allOrderAndAllService()")
    private Object executeTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            log.info("[트랜잭션 시작] {}", joinPoint.getSignature());
            Object proceed = joinPoint.proceed(joinPoint.getArgs());
            log.info("[트랜잭션 커밋] {}", joinPoint.getSignature());
            return proceed;
        } catch (Exception e) {
            log.info("[트랜잭션 롤백] {}", joinPoint.getSignature());
            throw e;
        }
    }

}
