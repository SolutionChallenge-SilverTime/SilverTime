package com.solutionchallenge.entertainment.controller.dto.response;

import com.solutionchallenge.entertainment.domain.apply.Apply;
import com.solutionchallenge.entertainment.domain.tutor.Tutor;
import lombok.*;

import java.util.Date;

@Builder
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponse {
    private String nickName;
    private String password;
    private Long userId;
    private int identity;

    private String name;
    private Date birth;
    private String email;
    private String gender;
    private String address;
    private String career;
    private String phone;
    private String introduction;
    private String profileUrl;

    public UserResponse(Apply apply) {
        this.userId = apply.getSenior().getSeniorId();
        this.name = apply.getSenior().getName();
        this.birth = apply.getSenior().getBirth();
        this.address = apply.getSenior().getAdress();
        this.gender = apply.getSenior().getGender();
    }

    public static UserResponse tutorOf(String nickName, String password, Long userId) {
        return UserResponse.builder().nickName(nickName).password(password).userId(userId).build();

    }

    public static UserResponse tutorOf(Tutor tutor) {
        return UserResponse.builder()
                .profileUrl(tutor.getProfileUrl())
                .nickName(tutor.getNickName())
                .password(tutor.getPassword())
                .name(tutor.getName())
                .birth(tutor.getBirth())
                .email(tutor.getEmail())
                .gender(tutor.getGender())
                .phone(tutor.getPhoneNum())
                .career(tutor.getCareer())
                .introduction(tutor.getIntroduction()).build();
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }
}
