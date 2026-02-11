package jsg.my_project.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final MemberRepository memberRepository;

    @PostMapping("/members")
    public String saveMember(@RequestBody TestRequestDTO requestDTO) {
        memberRepository.save(Member.builder().name(requestDTO.name()).build());
        return "저장 완료";
    }
}
