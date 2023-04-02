package com.solutionchallenge.entertainment.service.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TutorLectureDTO {

    private Long tutorId;

    private String category;

    private int maxRegistrant;

    private int week;

    private Date startDate;

    private Date endDate;

    private String activityTime;

    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private String sunday;

    private String title;

    private String instroduction;

    private List<String> curiculums;

    private String location;
    public static TutorLectureDTO of(Long tutorId, String category, int maxRegistrant, int week, Date startDate, Date endDate, String activityTime, String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday, String title, String instroduction, List<String> curiculums, String location){
        return new TutorLectureDTO(tutorId, category, maxRegistrant, week, startDate, endDate, activityTime, monday, tuesday, wednesday, thursday, friday, saturday, sunday, title, instroduction, curiculums, location);
    }


}
