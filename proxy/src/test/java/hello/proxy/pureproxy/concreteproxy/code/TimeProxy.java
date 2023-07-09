package hello.proxy.pureproxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

@Slf4j
public class TimeProxy extends ConcreteLogic {

    private final ConcreteLogic concreteLogic;

    public TimeProxy(ConcreteLogic concreteLogic) {
        this.concreteLogic = concreteLogic;
    }

    @Override
    public String operation() {
        log.info("TimeProxy 실행");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        String data = concreteLogic.operation();
        stopWatch.stop();
        log.info("TimeProxy 종료 resultTime = {}", stopWatch.getTotalTimeMillis());
        return data;
    }
}
