package com.solutionchallenge.entertainment.service.dto;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LikeLectureDTO {
    private Long seniorId;
    private Long lectureId;

    public static LikeLectureDTO of(Long seniorId, Long lectureId) {
        return new LikeLectureDTO(seniorId,lectureId);
    }
}
