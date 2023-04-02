package com.solutionchallenge.entertainment.controller.dto;

import com.google.firebase.auth.FirebaseAuthException;
import com.solutionchallenge.entertainment.controller.dto.request.TutorLectureRequest;
import com.solutionchallenge.entertainment.controller.dto.response.BriefLectureResponse;
import com.solutionchallenge.entertainment.service.TutorLectureService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tutor-lecture")
@CrossOrigin("*")
public class TutorLectureController {

    private final TutorLectureService tutorLectureService;

    @PostMapping(value = "/register", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> register(@Valid @RequestPart TutorLectureRequest request, @RequestPart List<MultipartFile> lectureImages, @RequestPart List<MultipartFile> curriculumImages) throws Exception {

        tutorLectureService.register(request.toServiceDto(), lectureImages, curriculumImages);

        return ResponseEntity.ok("Register Succeed");
    }

    @GetMapping("/my-lecture")
    public ResponseEntity<?> showAllLecture(@RequestParam Long tutorId, @RequestParam String state){

        List<BriefLectureResponse> responses = tutorLectureService.showAllLecture(tutorId, state);

        return ResponseEntity.ok(responses);
    }

}
