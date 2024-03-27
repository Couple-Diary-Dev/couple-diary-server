package com.couplediary.couple.controller;

import com.couplediary.couple.dto.GetCodeRequest;
import com.couplediary.couple.dto.GetCodeResponse;
import com.couplediary.couple.dto.MatchingCoupleRequest;
import com.couplediary.couple.dto.MatchingCoupleResponse;
import com.couplediary.couple.service.CoupleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/couple")
public class CoupleController {
    private final CoupleService coupleService;

    @PostMapping()
    public MatchingCoupleResponse matchingCouple(@RequestBody MatchingCoupleRequest matchingCoupleRequest) {
        return coupleService.matchingCouple(matchingCoupleRequest);
    }

    @GetMapping("/mycode")
    public GetCodeResponse getCode(@RequestBody GetCodeRequest getCodeRequest) {
        return coupleService.getCode(getCodeRequest);
    }
}
