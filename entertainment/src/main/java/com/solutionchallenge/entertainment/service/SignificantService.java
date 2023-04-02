package com.solutionchallenge.entertainment.service;

import com.solutionchallenge.entertainment.controller.dto.response.SignificantResponse;
import com.solutionchallenge.entertainment.domain.guardian.Guardian;
import com.solutionchallenge.entertainment.domain.guardian.GurdianRepository;
import com.solutionchallenge.entertainment.domain.significant.Significant;
import com.solutionchallenge.entertainment.domain.significant.SignificantRepository;
import com.solutionchallenge.entertainment.domain.tutor.Tutor;
import com.solutionchallenge.entertainment.service.dto.SignificantDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class SignificantService {
    private final SignificantRepository significantRepository;
    private final GuardianService guardianService;
    private final TutorService tutorService;
    public void create(SignificantDTO significantDTO) {
        Guardian guardian = guardianService.findByNickName(significantDTO.getGurdianNickName());
        Tutor tutor = tutorService.findByNickName(significantDTO.getTutorNickName());
//        Tutor tutor = tutorService.findByNickName(turtorNickName);
        Significant significant = Significant.getNewInstance(significantDTO, guardian, tutor);
        significantRepository.save(significant);
    }

    public List<SignificantResponse> tutorSendingList(String nickName) {
        Tutor tutor = tutorService.findByNickName(nickName);
        List<Significant> significants = significantRepository.findByTutorOrderByCreateDateDesc(tutor);
        List<SignificantResponse> significantResponses = significants.stream().map(SignificantResponse::new).collect(Collectors.toList());
        return significantResponses;
    }

    public List<SignificantResponse> guardianReceiveList(String nickName) {
        Guardian guardian = guardianService.findByNickName(nickName);
        List<Significant> significants = significantRepository.findByGuardianOrderByCreateDateDesc(guardian);
        List<SignificantResponse> significantResponses = significants.stream().map(SignificantResponse::new).collect(Collectors.toList());
        return significantResponses;
    }
}
