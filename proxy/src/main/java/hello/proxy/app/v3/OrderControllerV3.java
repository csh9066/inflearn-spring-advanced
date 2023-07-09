package hello.proxy.app.v3;

import hello.proxy.app.v2.OrderServiceV2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
@ResponseBody
public class OrderControllerV3 {

    private final OrderServiceV2 orderService;

    public OrderControllerV3(OrderServiceV2 orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/v3/request")
    public String request(String itemId) {
        orderService.save(itemId);
        return "ok";
    }

    @GetMapping("/v3/no-log")
    public String noLog() {
        return "ok";
    }
}
