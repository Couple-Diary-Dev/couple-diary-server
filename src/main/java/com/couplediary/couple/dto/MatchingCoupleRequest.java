package com.couplediary.couple.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class MatchingCoupleRequest {
    private Long id;
    private UUID code;

    public MatchingCoupleRequest(Long id, UUID code) {
        this.id = id;
        this.code = code;
    }
}
