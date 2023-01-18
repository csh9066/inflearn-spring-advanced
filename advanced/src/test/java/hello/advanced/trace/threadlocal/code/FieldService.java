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
        log.info("저장 name = {}, -> nameStore = {}", name, nameStore);
        nameStore = name;
        sleep(1000);
        log.info("조회 nameStore = {}", nameStore);
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