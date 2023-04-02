package com.solutionchallenge.entertainment.controller;

import com.google.firebase.auth.FirebaseAuthException;
import com.solutionchallenge.entertainment.controller.dto.request.GurdianInputSeniorRequest;
import com.solutionchallenge.entertainment.controller.dto.request.GuardianRequest;
import com.solutionchallenge.entertainment.service.FireBaseInitializer;
import com.solutionchallenge.entertainment.service.FirebaseService;
import com.solutionchallenge.entertainment.service.GuardianService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/auth/gurdian")
@RequiredArgsConstructor
@CrossOrigin("*")
public class GuardianController {
    private final GuardianService guardianService;
    private final FirebaseService firebaseService;
    //어르신 정보를 한번에 보낸다는 전제하
    @PostMapping(value = "signup", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> signUp(@Valid @RequestPart GuardianRequest guardianRequest, @RequestPart MultipartFile profileImage) throws Exception {
        GurdianInputSeniorRequest gurdianInputSeniorRequest= guardianRequest.toInputRequest();
        guardianService.signUp(guardianRequest.toServiceDto(), profileImage,gurdianInputSeniorRequest.toServiceDto(), guardianRequest.toInterestIdServiceDto());
        return ResponseEntity.ok("signup complete");
    }
    @PostMapping("/test")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException, FirebaseAuthException{
        if(file.isEmpty()){
            return "is empty";
        }
        return firebaseService.uploadFiles(file);
    }

}



