package com.solutionchallenge.entertainment.domain.registration;

import com.solutionchallenge.entertainment.domain.BaseTimeEntity;
import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import com.solutionchallenge.entertainment.domain.senior.Senior;
import com.solutionchallenge.entertainment.domain.tutor.Tutor;
import com.solutionchallenge.entertainment.service.dto.TutorLectureDTO;
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
public class Registration extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long regiestrationId;

    private String state;

    @ManyToOne
    @JoinColumn(name="tutor_Id")
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name="lecture_Id")
    private Lecture lecture;

    public static Registration getNewInstance(String state, Tutor tutor, Lecture lecture) {
        return Registration.builder()
                .state(state)
                .tutor(tutor)
                .lecture(lecture)
                .build();
    }
}
