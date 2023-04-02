package com.solutionchallenge.entertainment.domain.apply;

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
public class Apply extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long applyId;

    private String state;

    @ManyToOne
    @JoinColumn(name="senior_Id")
    private Senior senior;

    @ManyToOne
    @JoinColumn(name="lecture_Id")
    private Lecture lecture;

    public static Apply getNewInstance(Senior senior, Lecture lecture, String state){
        return Apply.builder()
                .senior(senior)
                .lecture(lecture)
                .state(state)
                .build();
    }

}
