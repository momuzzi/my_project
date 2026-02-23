package jsg.my_project.mts.orders;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    @PostMapping("/buy")
    @Operation(summary = "매수", description = "")
    public void buy() {

    }

    @PostMapping("/sell")
    @Operation(summary = "매도", description = "")
    public void sell() {

    }

    @DeleteMapping("/{orderId}")
    @Operation(summary = "주문 취소", description = "")
    public void cancelOrder() {

    }
}
