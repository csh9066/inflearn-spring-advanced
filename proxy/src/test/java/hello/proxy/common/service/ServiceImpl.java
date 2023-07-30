package hello.proxy.common.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceImpl implements ServiceInterface {
    @Override
    public void save() {
        log.info("service.save() 호출");
    }

    @Override
    public void find() {
        log.info("service.find() 호출");
    }
}
