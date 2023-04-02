package com.solutionchallenge.entertainment.service.dto;

import lombok.*;

import java.util.Date;
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class GuardianDTO {
    private String nickName;
    private String password;
    private String name;
    private String email;
    private String address;
    private String phone;
    private String gender;
    private Date birth;
    private String seniorNickname;

    public static GuardianDTO of(String nickName, String password, String name, String address, String phone, String email, String gender, Date birth, String seniorNickName) {
        return new GuardianDTO(nickName, password, name, email, address, phone, gender, birth, seniorNickName);
    }

    public static GuardianDTO of(String nickName, String password) {
        return GuardianDTO.builder().nickName(nickName).password(password).build();
    }
}
