package hello.advanced.trace.stategy.code.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {

    public void execute(Callback callback) {
        long startTime = System.currentTimeMillis();
        // 비지니스 로직 실 행
        callback.call();
        // 비지니스 로직 종료
        Long endTIme = System.currentTimeMillis();
        long resultTime = endTIme - startTime;
        log.info("resultTime={}", resultTime);
    }
}
