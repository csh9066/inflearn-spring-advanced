package hello.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

/**
 * @since       2023.01.18
 * @author      seunglo
 * @description field service
 **********************************************************************************************************************/
@Slf4j
public class FieldService {

    private String nameStore;

    public String logic(String name) {
        log.info("์ ์ฅ name = {}, -> nameStore = {}", name, nameStore);
        nameStore = name;
        sleep(1000);
        log.info("์กฐํ nameStore = {}", nameStore);
        return nameStore;
    }

    private void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}