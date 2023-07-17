package com.github.mrs;

import com.github.mrs.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MrsSpringbootEventApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    void buyOrderTest() {

        orderService.buyOrder("123456");
    }

}
