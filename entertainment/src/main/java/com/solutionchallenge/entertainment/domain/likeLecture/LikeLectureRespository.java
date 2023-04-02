package com.solutionchallenge.entertainment.domain.likeLecture;

import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import com.solutionchallenge.entertainment.domain.senior.Senior;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeLectureRespository extends JpaRepository<LikeLecture, Long> {
    Boolean existsByLectureAndSenior(Lecture lecture, Senior senior);

    Optional<LikeLecture> findByLectureAndSenior(Lecture lecture, Senior senior);
    Optional<List<LikeLecture>> findAllBySenior(Senior senior);
}
