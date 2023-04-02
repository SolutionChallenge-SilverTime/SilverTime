package com.solutionchallenge.entertainment.service;

import com.solutionchallenge.entertainment.controller.dto.response.UserResponse;
import com.solutionchallenge.entertainment.domain.senior.Senior;
import com.solutionchallenge.entertainment.domain.senior.SeniorRepository;
import com.solutionchallenge.entertainment.service.dto.InterestDTO;
import com.solutionchallenge.entertainment.service.dto.SeniorDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
@RequiredArgsConstructor
public class SeniorService {
    private final SeniorRepository seniorRepository;
    private final ImageHandler imageHandler;
    private final InterestService interestService;
    private final FirebaseService firebaseService;
    public void signUp(SeniorDTO seniorDTO, MultipartFile profileImage, InterestDTO interestDTO) throws Exception{
        validateNickNameDuplicate(seniorDTO.getNickName());
        validateEmailDuplicate(seniorDTO.getEmail());
        Senior getSenior = Senior.getNewInstance(seniorDTO);
//        String profileUrl = imageHandler.pareseFileInfo(profileImage,getSenior.getNickName());
        String profileUrl = firebaseService.uploadFiles(profileImage);
        getSenior.saveProfilUrl(profileUrl);
        Senior savedSenior = seniorRepository.save(getSenior);
        //관심사 등록
//        interestService.create(savedSenior, interestDTO.getContents());
        interestService.setRelation(savedSenior, interestDTO.getInterestIds());

    }
    public Senior gurdianInputSenior(SeniorDTO seniorDTO){
        validateEmailDuplicate(seniorDTO.getEmail());
        Senior getSenior = Senior.getSeniorInfo(seniorDTO);
        getSenior.saveProfilUrl("empty");
        return seniorRepository.save(getSenior);
    }
//    private void validateDuplicate(SeniorDTO seniorDTO){
//        seniorRepository.findByEmail(seniorDTO.getEmail())
//                .ifPresent(m-> {
//                    log.error("이미일 중복, email : {}", seniorDTO.getEmail());
//                    throw new IllegalArgumentException("SeniorEmail already exists");
//                });
//        seniorRepository.findByNickName(seniorDTO.getNickName())
//                .ifPresent(m->{
//                    log.error("닉네임 증복, nickname : {}",seniorDTO.getNickName());
//                    throw new IllegalArgumentException("SeniorNickName already exists");
//                });
//    }

    private void validateNickNameDuplicate(String nickName) {
        seniorRepository.findByNickName(nickName)
                .ifPresent(m->{
                    log.error("닉네임 증복, nickname : {}",nickName);
                    throw new IllegalArgumentException( nickName + " already exists");
                });
    }
    private void validateEmailDuplicate(String email){
        seniorRepository.findByEmail(email)
                .ifPresent(m-> {
                    log.error("이미일 중복, email : {}", email);
                    throw new IllegalArgumentException( email+ " already exists");
                });
    }
    public Senior findByNickName(String nickName ){
        return seniorRepository.findByNickName(nickName).orElseThrow(()-> new IllegalArgumentException("없는 유저입니다"));
    }
    public Senior findBySeniorId(Long seniorId){
        return seniorRepository.findBySeniorId(seniorId).orElseThrow(() -> new IllegalArgumentException("없는 id 유저"));
    }

    public UserResponse signIn(SeniorDTO seniorDTO) {
        Senior senior = seniorRepository.findByNickNameAndPassword(seniorDTO.getNickName(), seniorDTO.getPassword())
                .orElseThrow(()-> new IllegalArgumentException("로그인 정보가 틀렸습니다"));
        return UserResponse.tutorOf(senior.getNickName(), senior.getPassword(), senior.getSeniorId());
    }
}
