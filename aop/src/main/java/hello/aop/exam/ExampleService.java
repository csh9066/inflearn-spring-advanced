package hello.aop.exam;

import hello.aop.exam.annotation.Retry;
import hello.aop.exam.annotation.Trace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExampleService {

    private final ExamRepository examRepository;

    @Retry
    @Trace
    public void request(String itemId) {
        examRepository.save(itemId);
    }
}
