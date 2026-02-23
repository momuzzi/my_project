package jsg.my_project.mts.account;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    @GetMapping
    @Operation(summary = "내 계좌 내역 조회", description = "")
    public void getAccount() {

    }

    @PatchMapping("/in")
    @Operation(summary = "계좌 입금", description = "")
    public void deposit() {

    }

    @PatchMapping("/out")
    @Operation(summary = "계좌 출금", description = "")
    public void withdraw() {

    }
}
