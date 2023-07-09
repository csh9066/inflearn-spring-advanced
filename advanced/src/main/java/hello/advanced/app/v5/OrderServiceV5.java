package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Service;

/**
 * @since       2023.01.17
 * @author      seunglo
 * @description order service
 **********************************************************************************************************************/
@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;

    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace logTrace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(logTrace);
    }

    public void orderItem(String itemId) {
        template.execute("OrderSerivce.orderItem()", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }
}
