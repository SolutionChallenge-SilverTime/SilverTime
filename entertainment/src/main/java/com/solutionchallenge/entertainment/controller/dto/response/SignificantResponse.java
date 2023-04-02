package com.solutionchallenge.entertainment.controller.dto.response;

import com.solutionchallenge.entertainment.domain.significant.Significant;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SignificantResponse {
    private String tutorName;
    private String guardianName;
    private String seniorName;
    private String lectureName;
    private LocalDateTime createDate;
    private String title;
    private String content;
    private Long significantId;
    private String tutorProfileUrl;
    private String guardianProfileUrl;
    public SignificantResponse(Significant significant) {
        this.tutorName = significant.getTutor().getName();
        this.guardianName = significant.getGuardian().getName();
        this.seniorName = significant.getSeniorName();
        this.createDate = significant.getCreateDate();
        this.lectureName = significant.getLectureName();
        this.title = significant.getTitle();
        this.content = significant.getContent();
        this.significantId = significant.getSignificantId();
        this.tutorProfileUrl = significant.getTutor().getProfileUrl();
        this.guardianProfileUrl = significant.getGuardian().getProfileUrl();
    }
}
