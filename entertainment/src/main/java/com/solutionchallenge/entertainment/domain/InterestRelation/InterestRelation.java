package com.solutionchallenge.entertainment.domain.InterestRelation;

import com.solutionchallenge.entertainment.domain.interest.Interest;
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
public class InterestRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interestRelationId;

    @ManyToOne
    @JoinColumn(name="senior_Id")
    private Senior senior;

    @ManyToOne
    @JoinColumn(name = "interest_Id")
    private Interest interest;

    public static InterestRelation getNewInstance(Senior senior, Interest interest) {
        return InterestRelation.builder().senior(senior).interest(interest).build();
    }
}
