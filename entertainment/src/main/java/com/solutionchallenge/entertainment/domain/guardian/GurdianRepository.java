package com.solutionchallenge.entertainment.domain.guardian;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GurdianRepository extends JpaRepository<Guardian,Long> {
    Optional<Guardian> findByEmail(String email);

    Optional<Guardian> findByNickName(String nickName);

    Optional<Guardian> findByNickNameAndPassword(String nickName, String password);
}
