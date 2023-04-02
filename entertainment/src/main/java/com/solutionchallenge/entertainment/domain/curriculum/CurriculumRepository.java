package com.solutionchallenge.entertainment.domain.curriculum;

import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CurriculumRepository extends JpaRepository<Curriculum,Long> {

    Optional<List<Curriculum>> findAllByLecture(Lecture lecture);
}
