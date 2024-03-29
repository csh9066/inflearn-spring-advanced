package hello.aop.exam;

import hello.aop.exam.aop.RetryAspect;
import hello.aop.exam.aop.TraceAspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import({TraceAspect.class, RetryAspect.class})
@SpringBootTest
class ExampleTest {

    @Autowired
    ExampleService exampleService;

    @Test
    void test() {
        for (int i = 0; i < 5; i++) {
            exampleService.request("data" + i);
        }
    }
}
