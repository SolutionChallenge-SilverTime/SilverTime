package com.solutionchallenge.entertainment.domain.significantImages;

import com.solutionchallenge.entertainment.domain.BaseTimeEntity;
import com.solutionchallenge.entertainment.domain.significant.Significant;
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
public class SignificantImages extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long significantImageId;

    @Column
    private Long imageUrl;

    @ManyToOne
    @JoinColumn(name="significant_Id")
    private Significant significant;
}
