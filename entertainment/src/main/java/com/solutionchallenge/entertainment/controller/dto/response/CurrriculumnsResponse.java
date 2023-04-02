package com.solutionchallenge.entertainment.controller.dto.response;

import com.solutionchallenge.entertainment.domain.curriculum.Curriculum;
import lombok.*;
@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrriculumnsResponse {
    private Long curriculumId;
    private String content;
    private String imageUrl;
    private int week;

    public CurrriculumnsResponse(Curriculum curriculum) {
        this.curriculumId = curriculum.getCurriculumId();
        this.content = curriculum.getContent();
        this.imageUrl = curriculum.getImageUrl();
    }
}
