package com.solutionchallenge.entertainment.service;

import com.google.firebase.auth.FirebaseAuthException;
import com.solutionchallenge.entertainment.controller.dto.response.BriefLectureResponse;
import com.solutionchallenge.entertainment.controller.dto.response.GeoResultDto;
import com.solutionchallenge.entertainment.controller.dto.response.GeocodingApiResponse;
import com.solutionchallenge.entertainment.controller.dto.response.KakaoApiResponse;
import com.solutionchallenge.entertainment.domain.category.Category;
import com.solutionchallenge.entertainment.domain.category.CategoryRepository;
import com.solutionchallenge.entertainment.domain.curriculum.Curriculum;
import com.solutionchallenge.entertainment.domain.curriculum.CurriculumRepository;
import com.solutionchallenge.entertainment.domain.instroductionImages.InstroductionImages;
import com.solutionchallenge.entertainment.domain.instroductionImages.InstroductionImagesRepository;
import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import com.solutionchallenge.entertainment.domain.lecture.LectureRepository;
import com.solutionchallenge.entertainment.domain.registration.Registration;
import com.solutionchallenge.entertainment.domain.registration.RegistrationRepository;
import com.solutionchallenge.entertainment.domain.tutor.Tutor;
import com.solutionchallenge.entertainment.domain.tutor.TutorRepository;
import com.solutionchallenge.entertainment.service.dto.TutorLectureDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class TutorLectureService {

    private final KakaoAddressSearchService kakaoAddressSearchService;
    private final KakaoUriBuilderService kakaoUriBuilderService;

    private final GoogleMapUriBuilderService googleMapUriBuilderService;
    private final GoogleMapAddressSearchService googleMapAddressSearchService;
    private final UserLectureService userLectureService;
    private final FirebaseService firebaseService;

    private final LectureRepository lectureRepository;
    private final CurriculumRepository curriculumRepository;
    private final InstroductionImagesRepository instroductionImagesRepository;
    private final RegistrationRepository registrationRepository;
    private final TutorRepository tutorRepository;
    private final CategoryRepository categoryRepository;

    public void register(TutorLectureDTO tutorLectureDTO, List<MultipartFile> lectureImages, List<MultipartFile> curriculumImages) throws Exception {

        Tutor tutor = tutorRepository.findById(tutorLectureDTO.getTutorId()).orElseThrow(()-> new IllegalArgumentException("Tutor doesn't exist"));

        // 여기서 location -> latitude, longitude로 변환해서 lecture 테이블에 반영해줌
        //KakaoApiResponse kakaoApiResponse = kakaoAddressSearchService.requestAddressSearch(tutorLectureDTO.getLocation());
        GeocodingApiResponse geocodingApiResponse = googleMapAddressSearchService.requestAddressSearch(tutorLectureDTO.getLocation());

        double longitude = geocodingApiResponse.getResult().get(0).getGeometry().getLocation().get("lng");
        double latitude = geocodingApiResponse.getResult().get(0).getGeometry().getLocation().get("lat");

        log.info("LAT : {} , LONG : {}", latitude, longitude);

        //Category category = Category.getNewInstance(tutorLectureDTO.getCategory());
        Category category = categoryRepository.findByContent(tutorLectureDTO.getCategory()).orElseThrow(()-> new IllegalArgumentException("Category doesn't exist"));

        Lecture lecture = Lecture.getNewInstance(tutorLectureDTO, latitude, longitude, category);
        Registration registration = Registration.getNewInstance("registered", tutor, lecture);

        List<Curriculum> curriculums = new ArrayList<>();
        for(int i = 0; i < tutorLectureDTO.getCuriculums().size(); i++){
            String content = tutorLectureDTO.getCuriculums().get(i);

            String imageUrl = "";
            if(i < curriculumImages.size()) imageUrl = firebaseService.uploadFiles(curriculumImages.get(i));

            curriculums.add(Curriculum.getNewInstance(content, imageUrl, lecture));
        }

        List<InstroductionImages> introImages = new ArrayList<>();
        for(MultipartFile file : lectureImages){
            String imageUrl = firebaseService.uploadFiles(file);
            introImages.add(InstroductionImages.getNewInstance(imageUrl, lecture));
        }
        lecture.updateRepresentImageUrl(introImages.get(0).getImageUrl());

        //categoryRepository.save(category);
        lectureRepository.save(lecture);
        instroductionImagesRepository.saveAll(introImages);
        curriculumRepository.saveAll(curriculums);
        registrationRepository.save(registration);

    }
//    public void register2(TutorLectureDTO tutorLectureDTO){
//
//        Tutor tutor = tutorRepository.findById(tutorLectureDTO.getTutorId()).orElseThrow(()-> new IllegalArgumentException("Tutor doesn't exist"));
//
//        // 여기서 location -> latitude, longitude로 변환해서 lecture 테이블에 반영해줌
//        //KakaoApiResponse kakaoApiResponse = kakaoAddressSearchService.requestAddressSearch(tutorLectureDTO.getLocation());
//        GeocodingApiResponse geocodingApiResponse = googleMapAddressSearchService.requestAddressSearch(tutorLectureDTO.getLocation());
//
//        double longitude = geocodingApiResponse.getResult().get(0).getGeometry().getLocation().get("lng");
//        double latitude = geocodingApiResponse.getResult().get(0).getGeometry().getLocation().get("lat");
//        Category category = Category.getNewInstance(tutorLectureDTO.getCategory());
//        Lecture lecture = Lecture.getNewInstance(tutorLectureDTO, latitude, longitude, category);
//        Registration registration = Registration.getNewInstance("registered", tutor, lecture);
//
//        List<Curriculum> curriculums = new ArrayList<>();
//        for(String content : tutorLectureDTO.getCuriculums()){
//            // --------------- 이미지도 같이 넣어줘야 함 -------------------
//
//
//
//
//            // ---------------------------------------------------------
//            curriculums.add(Curriculum.getNewInstance(content, lecture));
//        }
//
//        //InstroductionImages instroductionImages = InstroductionImages.getNewInstance(lectureImages, lecture);
//        // --------------- 이미지도 같이 넣어줘야 함 -------------------
//
//
//
//
//        // ---------------------------------------------------------
//        //instroductionImagesRepository.saveAll();
//
//        categoryRepository.save(category);
//        lectureRepository.save(lecture);
//        curriculumRepository.saveAll(curriculums);
//        registrationRepository.save(registration);
//
//    }

    public List<BriefLectureResponse> showAllLecture(Long tutorId, String state) {

        Tutor tutor = tutorRepository.findById(tutorId).orElseThrow(()-> new IllegalArgumentException("TutorId is wrong"));

        List<Registration> registrations =registrationRepository.findAllByTutor(tutor).orElseThrow(()-> new IllegalArgumentException("TutorId is wrong"));

        List<BriefLectureResponse> responses = new ArrayList<>();

        // state : registered: 모집중 , completed: 모집완료, in-progress:진행중, finished: 진행완료
        for(Registration element : registrations){

            if(element.getState().equals("registered") && state.equals("registered")){
                responses.add(BriefLectureResponse.getNewInstance(element.getLecture(),0));
            }
            else if(element.getState().equals("completed") && state.equals("completed")){
                responses.add(BriefLectureResponse.getNewInstance(element.getLecture(),0));
            }
            else if(element.getState().equals("in-progress") && state.equals("in-progress")){
                responses.add(BriefLectureResponse.getNewInstance(element.getLecture(),0));
            }
            else if(element.getState().equals("finished") && state.equals("finished")){
                responses.add(BriefLectureResponse.getNewInstance(element.getLecture(),0));
            }
        }

        return responses;
    }
/*
    public void deleteLecture() {
    }

    public void modifyLecture() {
    }

 */
}
