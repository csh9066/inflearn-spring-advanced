package hello.proxy.jdkdynamic;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ReflectionTest {

    @Test
    void reflection() {
        Hello target = new Hello();

        // 공통 로직1 시작
        log.info("start");
        String result1 = target.callA();
        log.info("result1={}", result1);

        log.info("start");
        String result2 = target.callA();
        log.info("result1={}", result2);
    }

    @SneakyThrows
    @Test
    void reflectionWithClassForName() throws ClassNotFoundException {
        Class<?> classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello hello = new Hello();

        Method callA = classHello.getMethod("callA");
        String result = (String) callA.invoke(hello);

        assertThat(result).isEqualTo("A");

    }

    @Slf4j
    static class Hello {
        public String callA() {
            log.info("callA");
            return "A";
        }

        public String callB() {
            log.info("callB");
            return "B";
        }
    }
}
