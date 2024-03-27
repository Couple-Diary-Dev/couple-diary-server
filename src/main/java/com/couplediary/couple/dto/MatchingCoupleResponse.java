package com.couplediary.couple.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MatchingCoupleResponse {
    private String user1;
    private String user2;

    public MatchingCoupleResponse(String user1, String user2) {
        this.user1 = user1;
        this.user2 = user2;
    }
}
