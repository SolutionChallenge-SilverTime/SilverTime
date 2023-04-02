package com.solutionchallenge.entertainment.service;

import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import com.solutionchallenge.entertainment.domain.lecture.LectureRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LectureTestService {
    private final LectureRepository lectureRepository;
    public Lecture findById(Long lectureId){
        return lectureRepository.findByLectureId(lectureId).orElseThrow(() -> new IllegalArgumentException("없는 lecture ID "));
    }
}
