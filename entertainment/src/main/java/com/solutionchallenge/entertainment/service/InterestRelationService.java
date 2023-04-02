package com.solutionchallenge.entertainment.service;

import com.solutionchallenge.entertainment.domain.InterestRelation.InterestRelation;
import com.solutionchallenge.entertainment.domain.InterestRelation.InterestRelationRepository;
import com.solutionchallenge.entertainment.domain.interest.Interest;
import com.solutionchallenge.entertainment.domain.interest.InterestRepository;
import com.solutionchallenge.entertainment.domain.senior.Senior;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class InterestRelationService {
    private final InterestRelationRepository interestRelationRepository;
    public void create(Senior senior, Interest interest){
        InterestRelation interestRelation = InterestRelation.getNewInstance(senior, interest);
        interestRelationRepository.save(interestRelation);
    }
}
