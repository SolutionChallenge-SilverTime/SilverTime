package com.solutionchallenge.entertainment.domain.senior;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeniorRepository extends JpaRepository<Senior,Long> {
    Optional<Senior> findByEmail(String email);

    Optional<Senior> findBySeniorId(Long seniorId);
    Optional<Senior> findByNickName(String nickName);

    Optional<Senior> findByNickNameAndPassword(String nickName, String password);
}
