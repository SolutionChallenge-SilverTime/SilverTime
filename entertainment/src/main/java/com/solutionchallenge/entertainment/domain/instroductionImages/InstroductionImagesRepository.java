package com.solutionchallenge.entertainment.domain.instroductionImages;

import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InstroductionImagesRepository extends JpaRepository<InstroductionImages,Long> {

    Optional<List<InstroductionImages>> findAllByLecture(Lecture lecture);

}
