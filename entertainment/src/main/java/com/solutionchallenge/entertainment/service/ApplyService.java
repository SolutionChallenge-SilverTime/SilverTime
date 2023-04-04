package com.solutionchallenge.entertainment.service;

import com.solutionchallenge.entertainment.controller.dto.response.UserResponse;
import com.solutionchallenge.entertainment.domain.apply.Apply;
import com.solutionchallenge.entertainment.domain.apply.ApplyRepository;
import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import com.solutionchallenge.entertainment.service.lecture.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplyService {
    private final ApplyRepository applyRepository;
    private final LectureService lectureService;
    public List<UserResponse> getAppliedSeniors( Long lectureId) {
        Lecture lecture = lectureService.findById(lectureId);
        List<Apply> applies = applyRepository.findAllByLecture(lecture);
        List<UserResponse> appliedSeniors = applies.stream().map(UserResponse::new).collect(Collectors.toList());
        return appliedSeniors;

    }
}
