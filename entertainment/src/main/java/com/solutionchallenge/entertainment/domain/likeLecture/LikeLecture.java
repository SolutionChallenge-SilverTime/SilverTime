package com.solutionchallenge.entertainment.domain.likeLecture;

import com.solutionchallenge.entertainment.domain.BaseTimeEntity;
import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import com.solutionchallenge.entertainment.domain.senior.Senior;
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
public class LikeLecture extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long likeLectureId;

    @ManyToOne
    @JoinColumn(name="senior_Id")
    private Senior senior;

    @ManyToOne
    @JoinColumn(name="lecture_id")
    private Lecture lecture;

    public static LikeLecture getNewInstance(Lecture lecture, Senior senior) {
        return LikeLecture.builder().lecture(lecture).senior(senior).build();
    }
}
