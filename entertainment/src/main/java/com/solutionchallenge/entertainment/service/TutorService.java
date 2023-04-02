package com.solutionchallenge.entertainment.service;

import com.solutionchallenge.entertainment.controller.dto.response.UserResponse;
import com.solutionchallenge.entertainment.domain.guardian.GurdianRepository;
import com.solutionchallenge.entertainment.domain.senior.SeniorRepository;
import com.solutionchallenge.entertainment.domain.tutor.Tutor;
import com.solutionchallenge.entertainment.domain.tutor.TutorRepository;
import com.solutionchallenge.entertainment.service.dto.TutorDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
@RequiredArgsConstructor
public class TutorService {
    private final TutorRepository tutorRepository;
    private final SeniorRepository seniorRepository;
    private final GurdianRepository gurdianRepository;
    private final ImageHandler imageHandler;
    private final FirebaseService firebaseService;


    public void signUp(TutorDTO tutorDTO, MultipartFile profileImage) throws Exception {
        validDuplicate(tutorDTO);
        Tutor tutor = Tutor.getNewInstance(tutorDTO);
//        String profileUrl = imageHandler.pareseFileInfo(profileImage, tutorDTO.getNickName());
        String profileUrl = firebaseService.uploadFiles(profileImage);
        tutor.updateProfileUrl(profileUrl);
        tutorRepository.save(tutor);

    }

    private void validDuplicate(TutorDTO tutorDTO) {
        tutorRepository.findByEmail(tutorDTO.getEmail())
                .ifPresent(m-> {
                    log.error("이미일 중복, email : {}", tutorDTO.getEmail());
                    throw new IllegalArgumentException("tutorEmail already exists");
                });
        tutorRepository.findByNickName(tutorDTO.getNickName())
                .ifPresent(m->{
                    log.error("닉네임 증복, nickname : {}",tutorDTO.getNickName());
                    throw new IllegalArgumentException("tutor already exists");
                });
        gurdianRepository.findByNickName(tutorDTO.getNickName())
                .ifPresent(m->{
                    log.error("닉네임 증복, nickname : {}",tutorDTO.getNickName());
                    throw new IllegalArgumentException("guardian already exists");
                });
        seniorRepository.findByNickName(tutorDTO.getNickName())
                .ifPresent(m->{
                    log.error("닉네임 증복, nickname : {}",tutorDTO.getNickName());
                    throw new IllegalArgumentException("SeniorNickName already exists");
                });
    }
    public Tutor findByNickName(String nickName){
        return tutorRepository.findByNickName(nickName)
                .orElseThrow(() -> new IllegalArgumentException(nickName + " 는 없는 닉네임입니다"));
    }
    public Tutor findByTuturId(Long tutorId){
        return tutorRepository.findById(tutorId).orElseThrow(()-> new IllegalArgumentException("없는 tutorId 입니다"));
    }

    public UserResponse signIn(TutorDTO tutorDTO) {
        Tutor tutor = tutorRepository.findByNickNameAndPassword(tutorDTO.getNickName(), tutorDTO.getPassword())
                .orElseThrow(() -> new IllegalArgumentException("로그인 정보가 틀렸습니다"));
        return UserResponse.tutorOf(tutor.getNickName(), tutor.getPassword(), tutor.getTutorId());
    }

    public UserResponse getMypage(Long userId) {
        Tutor tutor = findByTuturId(userId);
        return UserResponse.tutorOf(tutor);
    }
}
