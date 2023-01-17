package hello.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @since       2023.01.17
 * @author      seunglo
 * @description order service
 **********************************************************************************************************************/
@RequiredArgsConstructor
@Service
public class OrderServiceV0 {

    private final OrderRepositoryV0 orderRepository;

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}