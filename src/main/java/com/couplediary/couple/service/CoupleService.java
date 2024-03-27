package com.couplediary.couple.service;

import com.couplediary.couple.domain.Couple;
import com.couplediary.couple.dto.GetCodeRequest;
import com.couplediary.couple.dto.GetCodeResponse;
import com.couplediary.couple.dto.MatchingCoupleRequest;
import com.couplediary.couple.dto.MatchingCoupleResponse;
import com.couplediary.couple.repository.CoupleRepository;
import com.couplediary.exception.CustomException;
import com.couplediary.user.domain.User;
import com.couplediary.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoupleService {
    private final CoupleRepository coupleRepository;
    private final UserRepository userRepository;

    public MatchingCoupleResponse matchingCouple(MatchingCoupleRequest matchingCoupleRequest) {
        User user1 = userRepository.findByCode(matchingCoupleRequest.getCode()).orElseThrow(() ->
                CustomException.builder()
                        .message("해당 회원이 존재하지 않습니다.")
                        .status(HttpStatus.BAD_REQUEST)
                        .build());

        User user2 = userRepository.findById(matchingCoupleRequest.getId()).orElseThrow(() ->
                CustomException.builder()
                        .message("해당 회원이 존재하지 않습니다.")
                        .status(HttpStatus.BAD_REQUEST)
                        .build());

        Couple couple = Couple.builder()
                .user1(user1)
                .user2(user2)
                .build();

        coupleRepository.save(couple);

        return MatchingCoupleResponse.builder()
                .user1(user1.getNickname())
                .user2(user2.getNickname())
                .build();
    }

    public GetCodeResponse getCode(GetCodeRequest getCodeRequest) {
        User user = userRepository.findById(getCodeRequest.getId()).orElseThrow(() ->
                CustomException.builder()
                        .message("해당 회원이 존재하지 않습니다.")
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
        return new GetCodeResponse(user.getCode());
    }
}