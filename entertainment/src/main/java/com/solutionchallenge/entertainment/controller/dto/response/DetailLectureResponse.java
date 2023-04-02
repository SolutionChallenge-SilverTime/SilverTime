package com.solutionchallenge.entertainment.controller.dto.response;

import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import com.solutionchallenge.entertainment.domain.tutor.Tutor;
import lombok.*;

import java.util.Date;
import java.util.List;


@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailLectureResponse {
    private List<CurrriculumnsResponse> curriculums;
    private List<InstroductionImagesResponse> instroductionImages;
    private List<ReviewResponse> reviews;
//lectured
    private Long lectureId;
    private String instroduction;
    private Date startDate;
    private String categoryToKorean;
    private Date endDate;
    private String location;
    private int likeCount;
    private int presentRegistrant;
    private int maxRegistrant;
    private String title;
    private String activityTime;
    private int week;
    private String aDayOfWeek;
    private double latitude;
    private double longitude;
//    tutor
    private String tutorName;
    private Date birth;
    private String gender;
    private String profileUrl;
    private String tutorIntroduction;

    public static DetailLectureResponse of(Lecture lecture, Tutor tutor, List<CurrriculumnsResponse> currriculumnsResponses, List<InstroductionImagesResponse> instroductionImagesResponses, String categoryToKorean, List<ReviewResponse> reviewResponses) {
        return DetailLectureResponse.builder()
                .lectureId(lecture.getLectureId())
                .instroduction(lecture.getInstroduction())
                .startDate(lecture.getStartDate())
                .endDate(lecture.getEndDate())
                .location(lecture.getLocation())
                .likeCount(lecture.getLikeCount())
                .categoryToKorean(categoryToKorean)
                .activityTime(lecture.getActivityTime())
                .presentRegistrant(lecture.getPresentRegistrant())
                .maxRegistrant(lecture.getMaxRegistrant())
                .title(lecture.getTitle())
                .week(lecture.getWeek())
                .aDayOfWeek(lecture.getMonday())
                .latitude(lecture.getLatitude())
                .longitude(lecture.getLongitude())
                .tutorName(tutor.getName())
                .birth(tutor.getBirth())
                .gender(tutor.getGender())
                .profileUrl(tutor.getProfileUrl())
                .instroduction(lecture.getInstroduction())
                .curriculums(currriculumnsResponses)
                .instroductionImages(instroductionImagesResponses)
                .tutorIntroduction(tutor.getIntroduction())
                .reviews(reviewResponses)
                .build();
    }
}

