package com.solutionchallenge.entertainment.controller;

import com.solutionchallenge.entertainment.controller.dto.request.SeniorRequest;
import com.solutionchallenge.entertainment.service.ImageHandler;
import com.solutionchallenge.entertainment.service.SeniorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth/senior")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SeniorController {
    private final SeniorService seniorService;
    private final ImageHandler imageHandler;
    @PostMapping(value ="signup", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> signUp(@Valid  @RequestPart SeniorRequest seniorRequest, @RequestPart MultipartFile profilImage) throws Exception {
        seniorService.signUp(seniorRequest.toServiceDto(), profilImage,seniorRequest.toInterestIdServiceDto());
        return ResponseEntity.ok("signup Complete");
    }
}



