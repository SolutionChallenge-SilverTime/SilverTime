package com.solutionchallenge.entertainment.service;

import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import com.solutionchallenge.entertainment.domain.lecture.LectureRepository;
import com.solutionchallenge.entertainment.domain.likeLecture.LikeLecture;
import com.solutionchallenge.entertainment.domain.likeLecture.LikeLectureRespository;
import com.solutionchallenge.entertainment.domain.senior.Senior;
import com.solutionchallenge.entertainment.service.dto.LikeLectureDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LikeLectureService {
    private final LikeLectureRespository likeLectureRespository;
    private final SeniorService seniorService;
    private final LectureTestService lectureTestService;
    private final LectureRepository lectureRepository;
    public void likeUnlike(LikeLectureDTO likeLectureDTO) {
        Lecture lecture = lectureTestService.findById(likeLectureDTO.getLectureId());
        Senior senior = seniorService.findBySeniorId(likeLectureDTO.getSeniorId());
//        Senior senior = seniorService.findByNickName(seniorNickName);
        //조항요 취소
        if(likeLectureRespository.existsByLectureAndSenior(lecture,senior)){
            unLike(lecture,senior);
            return;
        }
        like(lecture, senior);
    }

    private void like(Lecture lecture, Senior senior) {
        LikeLecture likeLecture = LikeLecture.getNewInstance(lecture, senior);
        lecture.like();
        lectureRepository.save(lecture);
        likeLectureRespository.save(likeLecture);
    }

    private void unLike(Lecture lecture, Senior senior) {
        LikeLecture getLikeLecture = likeLectureRespository.findByLectureAndSenior(lecture, senior).get();
        lecture.unLike();
        lectureRepository.save(lecture);
        likeLectureRespository.delete(getLikeLecture);
    }
}
