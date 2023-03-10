package hello.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

/**
 * @since       2023.01.18
 * @author      seunglo
 * @description field service
 **********************************************************************************************************************/
@Slf4j
public class ThreadLocalService {

    private ThreadLocal<String> nameStore = new ThreadLocal<>();

    public String logic(String name) {
        log.info("์ ์ฅ name = {}, -> nameStore = {}", name, nameStore.get());
        nameStore.set(name);
        sleep(1000);
        log.info("์กฐํ nameStore = {}", nameStore.get());
        return nameStore.get();
    }

    private void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}