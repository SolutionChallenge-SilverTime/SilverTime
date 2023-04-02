package com.solutionchallenge.entertainment.domain.apply;

import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import com.solutionchallenge.entertainment.domain.senior.Senior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ApplyRepository extends JpaRepository<Apply,Long> {

    @Transactional
    void deleteBySeniorAndLecture(Senior senior, Lecture lecture);

    Optional<List<Apply>> findAllBySenior(Senior senior);

    Optional<Apply> findBySeniorAndLecture(Senior senior, Lecture lecture);

    List<Apply> findAllByLecture(Lecture lecture);
}
