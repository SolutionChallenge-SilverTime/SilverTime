package com.solutionchallenge.entertainment.service.dto;

import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class LectureDistance {

    private Lecture inputlecture;
    private double userLatitude;
    private double userLongitude;

    private double distance;
    private int likeCount;
    private LocalDateTime modifiedDate;

}
