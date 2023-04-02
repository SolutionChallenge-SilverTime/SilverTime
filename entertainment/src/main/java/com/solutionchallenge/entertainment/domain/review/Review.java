package com.solutionchallenge.entertainment.domain.review;

import com.solutionchallenge.entertainment.domain.BaseTimeEntity;
import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import com.solutionchallenge.entertainment.domain.senior.Senior;
import com.solutionchallenge.entertainment.domain.tutor.Tutor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Review extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;

    @Column
    private String content;
    private double score;

    @ManyToOne
    @JoinColumn(name="senior_Id")
    private Senior senior;

    @ManyToOne
    @JoinColumn(name="lecture_Id")
    private Lecture lecture;

    public static Review getNewInstance(Senior senior, Lecture lecture, String content, double score){
        return Review.builder()
                .senior(senior)
                .lecture(lecture)
                .content(content)
                .score(score)
                .build();
    }
}
