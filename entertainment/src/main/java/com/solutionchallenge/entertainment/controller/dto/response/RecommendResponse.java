package com.solutionchallenge.entertainment.controller.dto.response;

import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import lombok.*;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecommendResponse {
    private Long lectureId;
    private String imageUrl;
    private String title;
    private String activityTime;
    private String aDayOfWeek;
    private String lectureIntro;
    private String location;
    private int likeCount;
    private int maxPeople;
    private int presentPeople;
    private double distance;

    public RecommendResponse(Lecture lecture) {
        this.lectureId = lecture.getLectureId();
        this.imageUrl = lecture.getRepresentImageUrl();
        this.title = lecture.getTitle();
        this.activityTime = lecture.getActivityTime();
        this.aDayOfWeek=lecture.getMonday();
        this.location=lecture.getLocation();
        this.maxPeople=lecture.getMaxRegistrant();
        this.presentPeople = lecture.getPresentRegistrant();
        this.likeCount = lecture.getLikeCount();
        this.lectureIntro = lecture.getInstroduction();

    }
}
