package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.Timer;

@Slf4j
public class TimeDecorator implements Component {

    private final Component component;

    public TimeDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("TimeDecorator 실행");
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        String result = component.operation();
        stopWatch.stop();
        log.info("TimeDecorator 종료 resultTime = {}", stopWatch.getTotalTimeMillis());
        return result;
    }
}
