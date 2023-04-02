package com.solutionchallenge.entertainment.controller.dto.request;

import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecommendRequest {
    private Long[] lectureIds ={23L,5L,38L,12L,24L,3L};
//    private Long[] lectureIds ={3L,24L,12L,38L,5L,23L};
    private List<Long> lectures = new ArrayList<>(Arrays.asList(lectureIds));
//    private List<Long> reverseLectures = Collections.reverse(lectures);
}
