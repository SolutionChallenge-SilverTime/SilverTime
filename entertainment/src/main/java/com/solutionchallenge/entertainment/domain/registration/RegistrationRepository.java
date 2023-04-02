package com.solutionchallenge.entertainment.domain.registration;

import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import com.solutionchallenge.entertainment.domain.tutor.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Registration,Long> {
    Optional<List<Registration>> findAllByTutor(Tutor tutor);

    Optional<Registration> findByLecture(Lecture lecture);

    //Optional<Registration> findByLecture(Lecture lecture);

    
}
