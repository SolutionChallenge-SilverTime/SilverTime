package com.solutionchallenge.entertainment.domain.tutor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TutorRepository extends JpaRepository<Tutor,Long> {
    Optional<Tutor> findByNickName(String nickName);

    Optional<Tutor> findByEmail(String email);

    Optional<Tutor> findByNickNameAndPassword(String nickName, String password);
}
