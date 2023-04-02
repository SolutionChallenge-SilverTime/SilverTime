package com.solutionchallenge.entertainment.domain.lecture;

import com.solutionchallenge.entertainment.domain.BaseTimeEntity;
import com.solutionchallenge.entertainment.domain.apply.Apply;
import com.solutionchallenge.entertainment.domain.category.Category;
import com.solutionchallenge.entertainment.domain.curriculum.Curriculum;
import com.solutionchallenge.entertainment.domain.instroductionImages.InstroductionImages;
import com.solutionchallenge.entertainment.domain.likeLecture.LikeLecture;
import com.solutionchallenge.entertainment.domain.registration.Registration;
import com.solutionchallenge.entertainment.domain.review.Review;
import com.solutionchallenge.entertainment.domain.tutor.Tutor;
import com.solutionchallenge.entertainment.service.dto.TutorLectureDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Lecture extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lectureId;

    @Column
    private String instroduction;
    private Date startDate;
    private Date endDate;
    private String location;
    private int likeCount=0;
    private int presentRegistrant;
    private int maxRegistrant;
    private String state;
    private String title;
    private String activityTime;
    private int week;

    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private String sunday;
    private String representImageUrl;

    private double latitude;
    private double longitude;


    @ManyToOne
    @JoinColumn(name="category_Id")
    private Category category;

    @OneToMany(mappedBy = "lecture", orphanRemoval = true)
    List<Registration> registrations = new ArrayList<>();

    @OneToMany(mappedBy = "lecture", orphanRemoval = true)
    List<Curriculum> curriculums = new ArrayList<>();

    @OneToMany(mappedBy = "lecture", orphanRemoval = true)
    List<Apply> applies = new ArrayList<>();

    @OneToMany(mappedBy = "lecture",orphanRemoval = true)
    List<InstroductionImages> instroductionImages = new ArrayList<>();

    @OneToMany(mappedBy = "lecture",orphanRemoval = true)
    List<LikeLecture> likeLectures = new ArrayList<>();

    public void unLike() {
        this.likeCount -= 1;
    }

    public void like() {
        this.likeCount +=1;
    }

    @OneToMany(mappedBy = "lecture", orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    public static Lecture getNewInstance(TutorLectureDTO tutorLectureDTO, double latitude, double longitude, Category category){
        return Lecture.builder()
                .instroduction(tutorLectureDTO.getInstroduction())
                .startDate(tutorLectureDTO.getStartDate())
                .endDate(tutorLectureDTO.getEndDate())
                .location(tutorLectureDTO.getLocation())
                .likeCount(0)
                .presentRegistrant(0)
                .maxRegistrant(tutorLectureDTO.getMaxRegistrant())
                .category(category)
                .state("in-progress")
                .monday(tutorLectureDTO.getMonday())
                .tuesday(tutorLectureDTO.getTuesday())
                .wednesday(tutorLectureDTO.getWednesday())
                .thursday(tutorLectureDTO.getThursday())
                .friday(tutorLectureDTO.getFriday())
                .saturday(tutorLectureDTO.getSaturday())
                .sunday(tutorLectureDTO.getSunday())
                .representImageUrl("")
                .title(tutorLectureDTO.getTitle())
                .activityTime(tutorLectureDTO.getActivityTime())
                .week(tutorLectureDTO.getWeek())
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }

    public void updateRegistrant(int num) {
        this.presentRegistrant = num;
    }
    public void updateRepresentImageUrl(String imageUrl) {
        this.representImageUrl = imageUrl;
    }
}
