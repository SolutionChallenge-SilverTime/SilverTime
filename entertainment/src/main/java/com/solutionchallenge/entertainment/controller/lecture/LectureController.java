package com.solutionchallenge.entertainment.controller.lecture;

import com.solutionchallenge.entertainment.controller.dto.request.RecommendRequest;
import com.solutionchallenge.entertainment.controller.dto.response.DetailLectureResponse;
import com.solutionchallenge.entertainment.controller.dto.response.RecommendResponse;
import com.solutionchallenge.entertainment.service.lecture.LectureService;
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
    private final LectureService lectureService;
    @GetMapping("/recommend")
    ResponseEntity<?> recommend (RecommendRequest request) throws IOException, InterruptedException {
        lectureService.recommend();
        List<RecommendResponse> getrecommendResponse = lectureService.getrecommendResponse(request.getLectureIds());
        return ResponseEntity.ok(getrecommendResponse);
    }
    @GetMapping("/detail/{lectureId}")
    ResponseEntity<?> getDetail(@PathVariable Long lectureId){
        DetailLectureResponse detailLectureResponse = lectureService.getDetail(lectureId);
        return ResponseEntity.ok(detailLectureResponse);
    }

}
