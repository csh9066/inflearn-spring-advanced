package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

/**
 * @since       2023.01.19
 * @author      seunglo
 * @description sub class logic1
 **********************************************************************************************************************/
@Slf4j
public class SubClassLogic1 extends AbstractTemplate {

    @Override
    protected void call() {
      log.info("logic1");
    }
}