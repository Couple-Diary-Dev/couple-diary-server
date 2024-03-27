package com.couplediary.couple.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class GetCodeResponse {
    private UUID code;

    public GetCodeResponse(UUID code) {
        this.code = code;
    }
}
