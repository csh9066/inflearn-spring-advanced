package hello.advanced.trace.stategy.code;

import hello.advanced.trace.stategy.code.strategy.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    void strategyV1() {
        ContextV2 context1 = new ContextV2();
        context1.execute(new StrategyLogic1());

        ContextV2 context2 = new ContextV2();
        context2.execute(new StrategyLogic2());
    }

    @Test
    void strategyV2() {
        ContextV2 context = new ContextV2();
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비지니스 1 실행");

            }
        });

        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비지니스 2 실행");

            }
        });
    }

    @Test
    void strategyV3() {
        ContextV2 context = new ContextV2();
        context.execute(() -> log.info("비지니스 1 실행"));

        context.execute(() -> log.info("비지니스 2 실행"));
    }
}
