package com.solutionchallenge.entertainment.controller.dto.response;

import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import lombok.*;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BriefLectureResponse {
    private Long lectureId;
    private String imageUrl;
    private String title;
    private String activityTime;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private String sunday;
    private String lectureIntro;
    private String location;
    private int likeCount;
    private int maxPeople;
    private int presentPeople;
    private double distance;

    public static BriefLectureResponse getNewInstance(Lecture lecture, double distance){
        return BriefLectureResponse.builder()
                .lectureId(lecture.getLectureId())
                .imageUrl(lecture.getRepresentImageUrl())
                .title(lecture.getTitle())
                .activityTime(lecture.getActivityTime())
                .monday(lecture.getMonday())
                .tuesday(lecture.getTuesday())
                .wednesday(lecture.getWednesday())
                .thursday(lecture.getThursday())
                .friday(lecture.getFriday())
                .saturday(lecture.getSaturday())
                .sunday(lecture.getSunday())
                .lectureIntro(lecture.getInstroduction())
                .location(lecture.getLocation())
                .likeCount(lecture.getLikeCount())
                .maxPeople(lecture.getMaxRegistrant())
                .presentPeople(lecture.getPresentRegistrant())
                .distance(distance)
                .build();
    }

}
