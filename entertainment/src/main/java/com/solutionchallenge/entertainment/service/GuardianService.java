package com.solutionchallenge.entertainment.service;

import com.solutionchallenge.entertainment.controller.dto.response.UserResponse;
import com.solutionchallenge.entertainment.domain.guardian.Guardian;
import com.solutionchallenge.entertainment.domain.guardian.GurdianRepository;
import com.solutionchallenge.entertainment.domain.senior.Senior;
import com.solutionchallenge.entertainment.service.dto.GuardianDTO;
import com.solutionchallenge.entertainment.service.dto.InterestDTO;
import com.solutionchallenge.entertainment.service.dto.SeniorDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
@RequiredArgsConstructor
public class GuardianService {
    private final GurdianRepository gurdianRepository;
    private final ImageHandler imageHandler;
    private final SeniorService seniorService;
    private final InterestService interestService;
    private final FirebaseService firebaseService;

    public void signUp(GuardianDTO guardianDTO, MultipartFile profilImage, SeniorDTO seniorDTO, InterestDTO interestDTO) throws Exception{
        validateDuplicate(guardianDTO);
//        seniorDTO.SeniorNickEqualsGuardian(guardianDTO.getNickName());
        Senior getSenior = setSenior(guardianDTO.getSeniorNickname(), seniorDTO);
        interestService.create(getSenior,interestDTO.getContents());
        interestService.setRelation(getSenior,interestDTO.getInterestIds());
        Guardian guardian = Guardian.newInstance(guardianDTO, getSenior);
//        String imageUrl = imageHandler.pareseFileInfo(profilImage, guardianDTO.getNickName());
        String imageUrl = firebaseService.uploadFiles(profilImage);
        guardian.updateProfile(imageUrl);
        gurdianRepository.save(guardian);
    }
    private void validateDuplicate(GuardianDTO guardianDTO){
        gurdianRepository.findByEmail(guardianDTO.getEmail())
                .ifPresent(m-> {
                    log.error("이미일 중복, email : {}", guardianDTO.getEmail());
                    throw new IllegalArgumentException("GurdianEmail already exists");
                });
        gurdianRepository.findByNickName(guardianDTO.getNickName())
                .ifPresent(m-> {
                    log.error("닉네임 중복, email : {}", guardianDTO.getNickName());
                    throw new IllegalArgumentException("GurdianNickname already exists");
                });
    }
    private Senior setSenior(String seniorNickName, SeniorDTO seniorDTO){
        if(StringUtils.hasText(seniorNickName)){
            return seniorService.findByNickName(seniorNickName);
        }
        return seniorService.gurdianInputSenior(seniorDTO);
    }

    public Guardian findByNickName(String nickName) {
        return gurdianRepository.findByNickName(nickName)
                .orElseThrow(() -> new IllegalArgumentException(nickName + " 은 없는 닉네임입니다"));
    }


    public UserResponse signIn(GuardianDTO guardianDTO) {
        Guardian guardian = gurdianRepository.findByNickNameAndPassword(guardianDTO.getNickName(), guardianDTO.getPassword())
                .orElseThrow(() -> new IllegalArgumentException("틀린 로그인 정보입니다"));

        return UserResponse.tutorOf(guardian.getNickName(), guardian.getPassword(), guardian.getGuardianId());
    }
}
