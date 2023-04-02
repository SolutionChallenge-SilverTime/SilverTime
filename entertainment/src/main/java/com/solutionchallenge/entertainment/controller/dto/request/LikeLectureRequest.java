package com.solutionchallenge.entertainment.controller.dto.request;

import com.solutionchallenge.entertainment.service.dto.LikeLectureDTO;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class LikeLectureRequest {
    private Long seniorId;
    private Long lectureId;

    public LikeLectureDTO toServiceDto(){
        return LikeLectureDTO.of(seniorId, lectureId);
    }
}
