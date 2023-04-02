package com.solutionchallenge.entertainment.controller.dto;

import com.solutionchallenge.entertainment.controller.dto.request.ReviewRequest;
import com.solutionchallenge.entertainment.controller.dto.response.BriefLectureResponse;
import com.solutionchallenge.entertainment.controller.dto.response.LectureInfoResponse;
import com.solutionchallenge.entertainment.service.UserLectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-lecture")
@CrossOrigin("*")
public class UserLectureController {

    private final UserLectureService userLectureService;

    @GetMapping("/apply")
    public ResponseEntity<?> applyLecture(@RequestParam Long userId, @RequestParam Long lectureId){

        userLectureService.applyLecture(userId, lectureId);

        return ResponseEntity.ok("Apply Lecture Succeed");
    }


    @GetMapping("/applied")
    public ResponseEntity<?> myLecture(@RequestParam String state, @RequestParam Long userId){

        List<BriefLectureResponse> responses = userLectureService.myLecture(state, userId);

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/main")
    public ResponseEntity<?> showMainLecture(@RequestParam Long userId){

        List<BriefLectureResponse> reponses = userLectureService.showAllLecture("all", "new", userId);

        return ResponseEntity.ok(reponses);
    }

    @GetMapping("/all")
    public ResponseEntity<?> showAllLecture(@RequestParam String category, @RequestParam String sort, @RequestParam Long userId){

        List<BriefLectureResponse> reponses = userLectureService.showAllLecture(category, sort, userId);

        return ResponseEntity.ok(reponses);
    }

    @GetMapping("/information")
    public ResponseEntity<?> showLectureInfo(@RequestParam Long lectureId, @RequestParam Long userId){

        LectureInfoResponse response = userLectureService.showLectureInfo(lectureId, userId);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/cancel")
    public ResponseEntity<?> cancelLecture(@RequestParam Long userId, @RequestParam Long lectureId){

        userLectureService.cancelLecture(userId, lectureId);

        return ResponseEntity.ok("Lecture Canceled");
    }

    @PostMapping(value="/review", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> writeReview(@Valid @RequestBody ReviewRequest request){

        userLectureService.writeReview(request.toServiceDto());

        return ResponseEntity.ok("Write Review Succeed");
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchLecture(@RequestParam String query, @RequestParam Long userId){

        List<BriefLectureResponse> responses = userLectureService.showAllLecture(query,"new", userId);

        return ResponseEntity.ok(responses);
    }

}
