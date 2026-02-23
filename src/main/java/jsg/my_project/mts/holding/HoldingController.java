package jsg.my_project.mts.holding;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/holdings")
public class HoldingController {

    @GetMapping
    @Operation(summary = "내 보유 주식 조회", description = "")
    public void getHoldingList() {

    }
}
