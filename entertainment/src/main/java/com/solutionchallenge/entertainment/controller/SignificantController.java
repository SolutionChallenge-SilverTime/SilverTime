package com.solutionchallenge.entertainment.controller;

import com.solutionchallenge.entertainment.controller.dto.request.SignificantRequest;
import com.solutionchallenge.entertainment.controller.dto.response.SignificantResponse;
import com.solutionchallenge.entertainment.service.SignificantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/significant")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SignificantController {
    private final SignificantService significantService;
    @PostMapping("/send")
    public ResponseEntity<?> sendSignificant(@Valid @RequestBody SignificantRequest significantRequest){
        significantService.create(significantRequest.toSeriveDto());
        return ResponseEntity.ok("send");
    }
    @GetMapping("/2/{nickName}")
    public ResponseEntity<?> turtorSendingList(@PathVariable String nickName) {
        List<SignificantResponse> significantResponse = significantService.tutorSendingList(nickName);
        return ResponseEntity.ok(significantResponse);
    }

    @GetMapping("/1/{nickName}")
    public ResponseEntity<?> guardianReceiveList(@PathVariable String nickName) {
        List<SignificantResponse> significantResponses = significantService.guardianReceiveList(nickName);
        return ResponseEntity.ok(significantResponses);
    }

}
