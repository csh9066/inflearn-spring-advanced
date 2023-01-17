package hello.advanced.app.v2;

import hello.advanced.app.v1.OrderServiceV1;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @since       2023.01.17
 * @author      seunglo
 * @description order controller v0
 **********************************************************************************************************************/
@RequiredArgsConstructor
@RestController
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;

    private final HelloTraceV2 trace;

    @GetMapping("/v2/request")
    public String request(String itemId) {
        TraceStatus status = trace.begin("OrderController.request()");

        try {
            orderService.orderItem(status.getTraceId(), itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

        return "ok";
    }
}