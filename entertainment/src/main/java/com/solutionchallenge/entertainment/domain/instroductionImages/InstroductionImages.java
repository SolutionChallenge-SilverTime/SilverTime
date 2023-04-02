package com.solutionchallenge.entertainment.domain.instroductionImages;

import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import com.solutionchallenge.entertainment.service.dto.TutorLectureDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class InstroductionImages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long instroductionImageId;

    @Column
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "lecture_Id")
    private Lecture lecture;

    public static InstroductionImages getNewInstance(String imageUrl, Lecture lecture) {
        return InstroductionImages.builder()
                .imageUrl(imageUrl)
                .lecture(lecture)
                .build();
    }


}
