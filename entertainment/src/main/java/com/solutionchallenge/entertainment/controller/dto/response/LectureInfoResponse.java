package com.solutionchallenge.entertainment.controller.dto.response;

import com.solutionchallenge.entertainment.domain.curriculum.Curriculum;
import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import com.solutionchallenge.entertainment.domain.review.Review;
import com.solutionchallenge.entertainment.domain.tutor.Tutor;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LectureInfoResponse {

    private String tutorName;
    private String category;
    private String title;
    private int likeCount;
    private int maxPeople;
    private int presentPeople;
    private String lectureIntro;
    private List<String> lectureIntroImagesUrl;
    private List<String> curriculumContents;
    private List<String> curriculumImagesUrl;
    private String tutorGender;
    private Date tutorBirth;
    private String profileUrl;
    private String tutorIntro;
    private List<Map<String,String>> reviews;

    private Date startDate;
    private Date endDate;
    private Date registerDate;
    private String activityTime;

    private double userLat;
    private double userLng;
    private double lectureLat;
    private double lectureLng;

    public static LectureInfoResponse getNewInstance(Lecture lecture, Tutor tutor, List<String> curriculumContents, List<String> curriculumImagesUrl, List<String> lectureIntroImagesUrl, List<Map<String,String>> reviews,Double userLat,Double userLng, Double lectureLat, Double lectureLng) {

        return LectureInfoResponse.builder()
                .tutorName(tutor.getName())
                .category(lecture.getCategory().getContent())
                .title(lecture.getTitle())
                .likeCount(lecture.getLikeCount())
                .maxPeople(lecture.getMaxRegistrant())
                .presentPeople(lecture.getPresentRegistrant())
                .lectureIntro(lecture.getInstroduction())
                .lectureIntroImagesUrl(lectureIntroImagesUrl)
                .curriculumContents(curriculumContents)
                .curriculumImagesUrl(curriculumImagesUrl)
                .tutorGender(tutor.getGender())
                .tutorBirth(tutor.getBirth())
                .profileUrl(tutor.getProfileUrl())
                .tutorIntro(tutor.getIntroduction())
                .startDate(lecture.getStartDate())
                .endDate(lecture.getEndDate())
                .registerDate(Timestamp.valueOf(lecture.getCreateDate()))
                .activityTime(lecture.getActivityTime())
                .reviews(reviews)
                .userLng(userLng)
                .userLat(userLat)
                .lectureLat(lectureLat)
                .lectureLng(lectureLng)
                .build();
    }
}
