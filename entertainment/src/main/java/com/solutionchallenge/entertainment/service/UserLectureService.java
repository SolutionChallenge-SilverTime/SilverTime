package com.solutionchallenge.entertainment.service;

import com.solutionchallenge.entertainment.controller.dto.response.BriefLectureResponse;
import com.solutionchallenge.entertainment.controller.dto.response.LectureInfoResponse;
import com.solutionchallenge.entertainment.domain.apply.Apply;
import com.solutionchallenge.entertainment.domain.apply.ApplyRepository;
import com.solutionchallenge.entertainment.domain.category.Category;
import com.solutionchallenge.entertainment.domain.category.CategoryRepository;
import com.solutionchallenge.entertainment.domain.curriculum.Curriculum;
import com.solutionchallenge.entertainment.domain.curriculum.CurriculumRepository;
import com.solutionchallenge.entertainment.domain.instroductionImages.InstroductionImages;
import com.solutionchallenge.entertainment.domain.instroductionImages.InstroductionImagesRepository;
import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import com.solutionchallenge.entertainment.domain.lecture.LectureRepository;
import com.solutionchallenge.entertainment.domain.likeLecture.LikeLecture;
import com.solutionchallenge.entertainment.domain.likeLecture.LikeLectureRespository;
import com.solutionchallenge.entertainment.domain.registration.RegistrationRepository;
import com.solutionchallenge.entertainment.domain.review.ReviewRepository;
import com.solutionchallenge.entertainment.domain.review.Review;
import com.solutionchallenge.entertainment.domain.senior.Senior;
import com.solutionchallenge.entertainment.domain.senior.SeniorRepository;
import com.solutionchallenge.entertainment.domain.tutor.Tutor;
import com.solutionchallenge.entertainment.domain.tutor.TutorRepository;
import com.solutionchallenge.entertainment.service.dto.LectureDistance;
import com.solutionchallenge.entertainment.service.dto.ReviewDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserLectureService {

    private static final double RADIUS_KM = 1.0;
    private static final int MAX_REVIEW = 10;
    private final SeniorRepository seniorRepository;
    private final ApplyRepository applyRepository;
    private final LectureRepository lectureRepository;
    private final TutorRepository tutorRepository;
    private final RegistrationRepository registrationRepository;
    private final InstroductionImagesRepository instroductionImagesRepository;
    private final CurriculumRepository curriculumRepository;
    private final ReviewRepository reviewRepository;
    private final LikeLectureRespository likeLectureRespository;
    private final CategoryRepository categoryRepository;

    public void applyLecture(Long userId, Long lectureId){

        Senior user = seniorRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("User doesn't exist"));
        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(()-> new IllegalArgumentException("Lecture doesn't exist"));
        if(lecture.getPresentRegistrant() < lecture.getMaxRegistrant()){
            lecture.updateRegistrant(lecture.getPresentRegistrant()+1);
            lectureRepository.save(lecture);
        }
        else throw new IllegalArgumentException("This lecture is full");
        Apply apply = Apply.getNewInstance(user, lecture, "applied");

        applyRepository.save(apply);
    }

    public LectureInfoResponse showLectureInfo(Long lectureId, Long userId) {
        Senior senior = seniorRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("User doesn't exist"));
        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(()-> new IllegalArgumentException("Lecture doesn't exist"));
        Tutor tutor = registrationRepository.findByLecture(lecture).orElseThrow(()-> new IllegalArgumentException("Tutor doesn't exist")).getTutor();
        List<Curriculum> curriculums = curriculumRepository.findAllByLecture(lecture).orElseThrow(()-> new IllegalArgumentException("Curriculum doesn't exist"));
        List<InstroductionImages> introImages = instroductionImagesRepository.findAllByLecture(lecture).orElseThrow(()-> new IllegalArgumentException("Images doesn't exist"));
        List<Review> reviews = reviewRepository.findAllByLecture(lecture)
                                                .orElseThrow(()-> new IllegalArgumentException("Review doesn't exist"))
                                                .stream()
                                                .sorted(Comparator.comparing(Review::getCreateDate).reversed())
                                                .limit(MAX_REVIEW)
                                                .collect(Collectors.toList());

        List<Map<String,String>> reviewResult = new ArrayList<Map<String,String>>();
        List<String> lectureIntroImagesUrl = new ArrayList<>();
        List<String> curriculumContents = new ArrayList<>();
        List<String> curriculumImagesUrl = new ArrayList<>();

        for(Review element : reviews){
            Map<String,String> temp = new HashMap<>();
            temp.put(element.getSenior().getName(),element.getContent());
            reviewResult.add(temp);
        }
        for(Curriculum element : curriculums ){
            curriculumContents.add(element.getContent());
            curriculumImagesUrl.add(element.getImageUrl());
        }
        for(InstroductionImages element : introImages){
            lectureIntroImagesUrl.add(element.getImageUrl());
        }
        LectureInfoResponse response = LectureInfoResponse.getNewInstance(lecture, tutor, curriculumContents, curriculumImagesUrl, lectureIntroImagesUrl,reviewResult,senior.getLatitude(),senior.getLongitude(),lecture.getLatitude(),lecture.getLongitude());

        return response;
    }

    public List<Lecture> lectureCategoryFilter(String inputCategory){
        List<Lecture> lectures;
        if(inputCategory.equals("all")){
            lectures = lectureRepository.findAll();
        }
        else if(inputCategory.equals("health") || inputCategory.equals("education") || inputCategory.equals("hobby") || inputCategory.equals("social")){
            Category category = categoryRepository.findByContent(inputCategory).orElseThrow(()-> new IllegalArgumentException("Category doesn't exist"));
            lectures = lectureRepository.findAllByCategory(category).orElseThrow(()-> new IllegalArgumentException("Lecture doesn't exist"));
        }
        else{
            lectures = lectureRepository.findByTitleContains(inputCategory).orElseThrow(()-> new IllegalArgumentException("Lecture doesn't exist"));
        }

        return lectures;
    }

    public List<LectureDistance> lectureSortNew(Category category, Senior senior){
         return lectureCategoryFilter(category.getContent()).stream()
                    .map(lecture -> LectureDistance.builder()
                            .inputlecture(lecture)
                            .userLatitude(senior.getLatitude())
                            .userLongitude(senior.getLongitude())
                            .distance(calculateDistance(lecture.getLatitude(), lecture.getLongitude(), senior.getLatitude(), senior.getLongitude()))
                            .likeCount(lecture.getLikeCount())
                            .modifiedDate(lecture.getModifiedDate())
                            .build())
                    .filter(lectureDistance -> lectureDistance.getDistance() <= RADIUS_KM)
                    .sorted(Comparator.comparing(LectureDistance::getModifiedDate).reversed())
                    .collect(Collectors.toList());
    }
    public List<LectureDistance> lectureSortDistance(Category category, Senior senior){
         return lectureCategoryFilter(category.getContent()).stream()
                    .map(lecture -> LectureDistance.builder()
                            .inputlecture(lecture)
                            .userLatitude(senior.getLatitude())
                            .userLongitude(senior.getLongitude())
                            .distance(calculateDistance(lecture.getLatitude(), lecture.getLongitude(), senior.getLatitude(), senior.getLongitude()))
                            .likeCount(lecture.getLikeCount())
                            .modifiedDate(lecture.getModifiedDate())
                            .build())
                    .filter(lectureDistance -> lectureDistance.getDistance() <= RADIUS_KM)
                    .sorted(Comparator.comparing(LectureDistance::getDistance))
                    .collect(Collectors.toList());
    }
    public List<LectureDistance> lectureSortLike(Category category, Senior senior){
         return lectureCategoryFilter(category.getContent()).stream()
                    .map(lecture -> LectureDistance.builder()
                            .inputlecture(lecture)
                            .userLatitude(senior.getLatitude())
                            .userLongitude(senior.getLongitude())
                            .distance(calculateDistance(lecture.getLatitude(), lecture.getLongitude(), senior.getLatitude(), senior.getLongitude()))
                            .likeCount(lecture.getLikeCount())
                            .modifiedDate(lecture.getModifiedDate())
                            .build())
                    .filter(lectureDistance -> lectureDistance.getDistance() <= RADIUS_KM)
                    .sorted(Comparator.comparing(LectureDistance::getLikeCount).reversed())
                    .collect(Collectors.toList());
    }

    public List<BriefLectureResponse> showAllLecture(String category, String sort, Long userId) {

        Senior senior = seniorRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("Senior doesn't exist"));

        Category categoryObject = new Category();
        if(category.equals("education") || category.equals("health") || category.equals("hobby") || category.equals("social") || category.equals("all")) {
            categoryObject = categoryRepository.findByContent(category).orElseThrow(() -> new IllegalArgumentException("Senior doesn't exist"));
        }
        else categoryObject = Category.getNewInstance(category);

        List<LectureDistance> finalLecture = new ArrayList<>();
        if(sort.equals("new")){
            finalLecture = lectureSortNew(categoryObject, senior);
        }
        else if(sort.equals("distance")){
            finalLecture = lectureSortDistance(categoryObject, senior);
        }
        else if(sort.equals("like")){
            finalLecture = lectureSortLike(categoryObject, senior);
        }

        List<BriefLectureResponse> responses = new ArrayList<>();
        for(LectureDistance element : finalLecture){
            responses.add(BriefLectureResponse.getNewInstance(element.getInputlecture(),Math.round(element.getDistance()*1000)));
        }

        return responses;

    }


    public void cancelLecture(Long userId, Long lectureId) {

        Senior senior = seniorRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("Senior doesn't exist"));
        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(()-> new IllegalArgumentException("Senior doesn't exist"));

        Apply apply = applyRepository.findBySeniorAndLecture(senior, lecture).orElseThrow(()-> new IllegalArgumentException("Apply doesn't exist"));
        if(lecture.getPresentRegistrant() > 0 && apply.getState().equals("applied")){
            lecture.updateRegistrant(lecture.getPresentRegistrant()-1);
            lectureRepository.save(lecture);
            applyRepository.deleteBySeniorAndLecture(senior, lecture);
        }
        else throw new IllegalArgumentException("There is no applicant");

    }

    // 통과
    public List<BriefLectureResponse> myLecture(String state, Long userId) {

        // state : applied: 수강 전 , completed: 수강 완료, in-progress:수강 중, interest: 관심 있는

        List<BriefLectureResponse> responses = new ArrayList<>();
        Senior senior = seniorRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("Senior doesn't exist"));

        if(state.equals("interest")){
            List<LikeLecture> likeLectures = likeLectureRespository.findAllBySenior(senior).orElseThrow(()-> new IllegalArgumentException("UserId is wrong"));
            for(LikeLecture element : likeLectures){
                double distance = calculateDistance(senior.getLatitude(),senior.getLongitude(),element.getLecture().getLatitude(),element.getLecture().getLongitude());
                responses.add(BriefLectureResponse.getNewInstance(element.getLecture(),Math.round(distance)*1000
                ));
            }
        }
        else{
            List<Apply> applies = applyRepository.findAllBySenior(senior).orElseThrow(()-> new IllegalArgumentException("UserId is wrong"));
            for(Apply element : applies){
                double distance = calculateDistance(senior.getLatitude(),senior.getLongitude(),element.getLecture().getLatitude(),element.getLecture().getLongitude());
                if(element.getState().equals("completed") && state.equals("completed")){
                    responses.add(BriefLectureResponse.getNewInstance(element.getLecture(),Math.round(distance)*1000));
                }
                else if(element.getState().equals("applied") && state.equals("applied")){
                    responses.add(BriefLectureResponse.getNewInstance(element.getLecture(),Math.round(distance)*1000));
                }
                else if(element.getState().equals("in-progress") && state.equals("in-progress")){
                    responses.add(BriefLectureResponse.getNewInstance(element.getLecture(),Math.round(distance)*1000));
                }
            }
        }

        return responses;
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        double earthRadius = 6371; //Kilometers
        return earthRadius * Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));
    }

    public void writeReview(ReviewDTO reviewDTO) {

        Senior senior = seniorRepository.findById(reviewDTO.getSeniorId()).orElseThrow(()-> new IllegalArgumentException("Senior doesn't exist"));
        Lecture lecture = lectureRepository.findById(reviewDTO.getLectureId()).orElseThrow(()-> new IllegalArgumentException("Lecture doesn't exist"));

        reviewRepository.save(Review.getNewInstance(senior,lecture,reviewDTO.getContent(),reviewDTO.getScore()));
    }
}
