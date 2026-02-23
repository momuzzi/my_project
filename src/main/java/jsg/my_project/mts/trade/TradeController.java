package jsg.my_project.mts.trade;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trades")
public class TradeController {

    @GetMapping
    @Operation(summary = "내 체결 내역 조회", description = "")
    public void getTradeList() {

    }
}
