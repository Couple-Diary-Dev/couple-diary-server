package com.couplediary.couple.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetCodeRequest {
    private Long id;

    public GetCodeRequest(Long id) {
        this.id = id;
    }
}
