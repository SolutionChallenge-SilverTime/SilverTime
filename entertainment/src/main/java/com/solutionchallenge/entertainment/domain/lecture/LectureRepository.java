package com.solutionchallenge.entertainment.domain.lecture;

import com.solutionchallenge.entertainment.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    Optional<Lecture> findByLectureId(Long lectureId);
    Optional<List<Lecture>> findAllByCategory(Category category);

    Optional<List<Lecture>> findByTitleLike(String category);

    Optional<List<Lecture>> findByTitleContains(String category);
}
