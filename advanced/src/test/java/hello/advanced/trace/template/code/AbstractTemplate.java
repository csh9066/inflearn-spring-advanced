package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

/**
 * @since       2023.01.19
 * @author      seunglo
 * @description abstract template
 **********************************************************************************************************************/
@Slf4j
public abstract class AbstractTemplate {

    public void execute() {
        long startTime = System.currentTimeMillis();

        call();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("resultTime={}", resultTime);
    }

    protected abstract void call();

}