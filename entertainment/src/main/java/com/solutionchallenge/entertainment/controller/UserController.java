package com.solutionchallenge.entertainment.controller;

import com.solutionchallenge.entertainment.controller.dto.request.UserRequest;
import com.solutionchallenge.entertainment.controller.dto.response.UserResponse;
import com.solutionchallenge.entertainment.domain.tutor.TutorRepository;
import com.solutionchallenge.entertainment.security.TokenProvider;
import com.solutionchallenge.entertainment.service.GuardianService;
import com.solutionchallenge.entertainment.service.SeniorService;
import com.solutionchallenge.entertainment.service.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth/signin")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    private final SeniorService seniorService;
    private final GuardianService guardianService;
    private final TutorService tutorService;
    private final TokenProvider tokenProvider;
    @PostMapping()
    public ResponseEntity<?> signin(@Valid @RequestBody UserRequest userRequest) {
        UserResponse userResponse = setIdentity(userRequest.getIdentity(), userRequest);
//        final String token = tokenProvider.create(userResponse);
        userResponse.setIdentity(userRequest.getIdentity());
        return ResponseEntity.ok(userResponse);
    }

    private UserResponse setIdentity(int identity, UserRequest userRequest) {
        if(identity==0){
            return seniorService.signIn(userRequest.toSeniorServiceDto());
        } else if (identity==1) {
            return guardianService.signIn(userRequest.toGuardianServiceDto());
        }
        return tutorService.signIn(userRequest.toTutorServiceDto());
    }
}
