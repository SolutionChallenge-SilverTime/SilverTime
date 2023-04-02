package com.solutionchallenge.entertainment.domain.significant;

import com.solutionchallenge.entertainment.domain.BaseTimeEntity;
import com.solutionchallenge.entertainment.domain.guardian.Guardian;
import com.solutionchallenge.entertainment.domain.significantImages.SignificantImages;
import com.solutionchallenge.entertainment.domain.tutor.Tutor;
import com.solutionchallenge.entertainment.service.dto.SignificantDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Significant extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long significantId;

    @Column
    private String title;
    private String content;
    private String lectureName;
    private String seniorName;

    @ManyToOne
    @JoinColumn(name="guardian_Id")
    private Guardian guardian;

    @ManyToOne
    @JoinColumn(name="tutor_Id")
    private Tutor tutor;

    @OneToMany(mappedBy = "significant", orphanRemoval = true)
    private List<SignificantImages> significantImages = new ArrayList<>();

    public static Significant getNewInstance(SignificantDTO significantDTO, Guardian guardian, Tutor tutor) {
        return Significant.builder()
                .title(significantDTO.getTitle())
                .content(significantDTO.getContent())
                .lectureName(significantDTO.getLectureName())
                .seniorName(significantDTO.getSeniorName())
                .guardian(guardian)
                .tutor(tutor)
                .build();
    }
}
