package com.solutionchallenge.entertainment.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.solutionchallenge.entertainment.service.dto.TutorLectureDTO;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TutorLectureRequest {

    @NotNull
    private Long tutorId;

    @NotNull
    private String category;

    @NotNull
    private int maxRegistrant;

    @NotNull
    private int week;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endDate;

    @NotNull
    private String activityTime;

    @NotNull
    private String monday;
    @NotNull
    private String tuesday;
    @NotNull
    private String wednesday;
    @NotNull
    private String thursday;
    @NotNull
    private String friday;
    @NotNull
    private String saturday;
    @NotNull
    private String sunday;

    @NotNull
    private String title;

    @NotNull
    private String instroduction;

    @NotNull
    private List<String> curiculums;

    @NotNull
    private String location;


    public TutorLectureDTO toServiceDto(){
        return TutorLectureDTO.of(tutorId,category,maxRegistrant,week,startDate,endDate,activityTime,monday,tuesday,wednesday,thursday,friday,saturday,sunday,title,instroduction,curiculums,location);
    }
}
