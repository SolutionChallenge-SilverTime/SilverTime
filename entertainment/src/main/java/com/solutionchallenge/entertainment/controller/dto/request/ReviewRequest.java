package com.solutionchallenge.entertainment.controller.dto.request;

import com.solutionchallenge.entertainment.service.dto.ReviewDTO;
import lombok.*;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {

    @NotNull
    private Long seniorId;

    @NotNull
    private Long lectureId;

    @NotNull
    private String content;

    @NotNull
    private double score;

    public ReviewDTO toServiceDto(){
        return ReviewDTO.of(seniorId,lectureId,content,score);
    }


}
