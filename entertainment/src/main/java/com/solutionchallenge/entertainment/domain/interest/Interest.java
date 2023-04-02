package com.solutionchallenge.entertainment.domain.interest;

import com.solutionchallenge.entertainment.domain.BaseTimeEntity;
import com.solutionchallenge.entertainment.domain.InterestRelation.InterestRelation;
import com.solutionchallenge.entertainment.domain.senior.Senior;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Interest extends BaseTimeEntity {
    @Id
    private Long interestId;

    @Column
    private String content;


    @OneToMany(mappedBy = "interest", orphanRemoval = true)
    private List<InterestRelation> interestRelations = new ArrayList<>();

    public static Interest getNewInstance(String content) {
        return Interest.builder().content(content).build();
    }

    public static Interest getNewInstanceID(String content, Long num) {
        return Interest.builder().content(content).interestId(num).build();
    }
}
