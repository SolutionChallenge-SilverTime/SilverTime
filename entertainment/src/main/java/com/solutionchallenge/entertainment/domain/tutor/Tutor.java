package com.solutionchallenge.entertainment.domain.tutor;

import com.solutionchallenge.entertainment.domain.BaseTimeEntity;
import com.solutionchallenge.entertainment.domain.registration.Registration;
import com.solutionchallenge.entertainment.domain.significant.Significant;
import com.solutionchallenge.entertainment.service.dto.TutorDTO;
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
public class Tutor extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tutorId;

    @Column
    private String name;
    private String nickName;
    private String password;
    private String phoneNum;
    private Date birth;
    private String gender;
    private String profileUrl;
    private String address;
    private String email;
    private String career;
    private String introduction;

    @OneToMany(mappedBy = "tutor", orphanRemoval = true)
    private List<Significant> significants = new ArrayList<>();

    @OneToMany(mappedBy = "tutor", orphanRemoval = true)
    private List<Registration> registrations = new ArrayList<>();

    public static Tutor getNewInstance(TutorDTO tutorDTO) {
        return Tutor.builder()
                .name(tutorDTO.getName())
                .nickName(tutorDTO.getNickName())
                .password(tutorDTO.getPassword())
                .email(tutorDTO.getEmail())
                .address(tutorDTO.getAddress())
                .gender(tutorDTO.getGender())
                .phoneNum(tutorDTO.getPhone())
                .career(tutorDTO.getCareer())
                .introduction(tutorDTO.getIntroduction())
                .birth(tutorDTO.getBirth())
                .build();
    }
    public void updateProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }
}
