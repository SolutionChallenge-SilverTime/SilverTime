package com.solutionchallenge.entertainment.domain.interest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InterestRepository extends JpaRepository<Interest, Long> {
    Boolean existsByContent(String content);

    Optional<Interest> findByContent(String content);

    Optional<Interest> findById(Long interestId);
}

