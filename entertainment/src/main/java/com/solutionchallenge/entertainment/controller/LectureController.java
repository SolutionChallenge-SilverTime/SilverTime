package com.solutionchallenge.entertainment.controller;

import com.solutionchallenge.entertainment.controller.dto.request.RecommendRequest;
import com.solutionchallenge.entertainment.controller.dto.response.DetailLectureResponse;
import com.solutionchallenge.entertainment.controller.dto.response.RecommendResponse;
import com.solutionchallenge.entertainment.service.LectureRecommendService;
import com.solutionchallenge.entertainment.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/lecture")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LectureController {
    private final LectureRecommendService lectureRecommendService;
    private final LectureService lectureService;
    @GetMapping("/recommend")
    ResponseEntity<?> recommend (RecommendRequest request) throws IOException, InterruptedException {
        lectureRecommendService.recommend();
        List<RecommendResponse> getrecommendResponse = lectureRecommendService.getrecommendResponse(request.getLectureIds());
        return ResponseEntity.ok(getrecommendResponse);
    }
    @GetMapping("/detail/{lectureId}")
    ResponseEntity<?> getDetail(@PathVariable Long lectureId){
        DetailLectureResponse detailLectureResponse = lectureRecommendService.getDetail(lectureId);
        return ResponseEntity.ok(detailLectureResponse);
    }

}
