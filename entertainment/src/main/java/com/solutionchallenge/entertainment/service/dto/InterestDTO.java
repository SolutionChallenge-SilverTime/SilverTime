package com.solutionchallenge.entertainment.service.dto;

import lombok.*;

import java.util.List;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class InterestDTO {
    private List<String> contents;
    private List<Long> interestIds;

    public static InterestDTO of(List<String> contents) {
        return InterestDTO.builder().contents(contents).build();
    }

    public static InterestDTO idOf(List<Long> interestIds) {
        return InterestDTO.builder().interestIds(interestIds).build();

    }
}
