package com.solutionchallenge.entertainment.service;

import com.solutionchallenge.entertainment.controller.dto.response.*;
import com.solutionchallenge.entertainment.domain.category.CategoryRepository;
import com.solutionchallenge.entertainment.domain.curriculum.Curriculum;
import com.solutionchallenge.entertainment.domain.curriculum.CurriculumRepository;
import com.solutionchallenge.entertainment.domain.instroductionImages.InstroductionImages;
import com.solutionchallenge.entertainment.domain.instroductionImages.InstroductionImagesRepository;
import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import com.solutionchallenge.entertainment.domain.registration.RegistrationRepository;
import com.solutionchallenge.entertainment.domain.review.Review;
import com.solutionchallenge.entertainment.domain.review.ReviewRepository;
import com.solutionchallenge.entertainment.domain.tutor.Tutor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class LectureRecommendService {
    private final LectureService lectureService;
    private final RegistrationRepository registrationRepository;
    private final CurriculumRepository curriculumRepository;
    private final InstroductionImagesRepository instroductionImagesRepository;
    private final ReviewRepository reviewRepository;
    public void recommend() throws IOException, InterruptedException {
        String venvPath = "/Users/hwangsolhee/opt/anaconda3/etc/silvertime"; // 가상환경 경로
        String scriptPath = "/path/to/your/script.py"; // Python 스크립트 경로

        String[] command = {
                "/bin/bash",
                "-c",
                "source " + venvPath + "/bin/activate && python " + scriptPath
        };

        // Create a new process builder with the command
        ProcessBuilder pb = new ProcessBuilder(command);

        // Start the process
        Process process = pb.start();

        // Wait for the process to finish
        int exitCode = process.waitFor();

        // Print the exit code of the process
        System.out.println("Python script exited with code " + exitCode);

    }

    public List<RecommendResponse> getrecommendResponse(Long[] lectureIds) {
        List<Lecture> getLectures = new ArrayList<>();
        for (Long lecureId: lectureIds) {
            Lecture getLecture = lectureService.findbyId(lecureId);
            getLectures.add(getLecture);
        }
        List<RecommendResponse> recommendResponses = getLectures.stream().map(RecommendResponse::new).collect(Collectors.toList());
        return recommendResponses;
    }

    public DetailLectureResponse getDetail(Long lectureId) {
        Lecture lecture = lectureService.findbyId(lectureId);
        String categoryToKorean = categoryToKorean(lecture.getCategory().getCategoryId());
        Tutor tutor = registrationRepository.findByLecture(lecture).get().getTutor();
        List<Review> reviews = reviewRepository.findAllByLecture(lecture).get();
        List<Curriculum> curriculums = curriculumRepository.findAllByLecture(lecture).orElseThrow(()->new IllegalArgumentException("없는 lecture입니다"));
        List<InstroductionImages> instroductionImages = instroductionImagesRepository.findAllByLecture(lecture).orElseThrow(()->new IllegalArgumentException("없는 강의"));
        List<ReviewResponse> reviewResponses = reviews.stream().map(ReviewResponse::new).collect(Collectors.toList());
        List<CurrriculumnsResponse> currriculumnsResponses = curriculums.stream().map(CurrriculumnsResponse::new).collect(Collectors.toList());
        List<InstroductionImagesResponse> instroductionImagesResponses = instroductionImages.stream().map(InstroductionImagesResponse::new).collect(Collectors.toList());
        DetailLectureResponse detailLectureResponse = DetailLectureResponse.of(lecture, tutor, currriculumnsResponses, instroductionImagesResponses,categoryToKorean,reviewResponses);
        return detailLectureResponse;
    }
    private String categoryToKorean(Long categoryId){
        if(categoryId==0){
            return "교육";
        } else if (categoryId==1) {
            return "취미";
        } else if (categoryId==2) {
            return "건강";
        } else if (categoryId==3) {
            return "친목";
        }
        return "";
    }
}
