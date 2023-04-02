package com.solutionchallenge.entertainment.controller.dto.response;

import com.solutionchallenge.entertainment.domain.review.Review;
import lombok.*;

@Builder
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewResponse {
    private Long reviewId;
    private String content;
    private String seniorNickName;
    private Long lectureId;

    public ReviewResponse(Review review) {
        this.reviewId = review.getReviewId();
        this.content = review.getContent();
        this.seniorNickName = review.getSenior().getNickName();
        this.lectureId = review.getLecture().getLectureId();
    }
}
