package com.solutionchallenge.entertainment.service.dto;

import lombok.*;

import java.util.Date;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class SeniorDTO {
    private String nickName;
    private String password;
    private String name;
    private String email;
    private String address;
    private String phone;
    private String gender;
    private Date birth;


    public static SeniorDTO of(String nickName, String password, String name, String email,String address, String phone, String gender, Date birth) {
        return new SeniorDTO(nickName, password, name,email, address, phone,gender,birth);
    }


    public static SeniorDTO of(String nickName,String name, String address, String phone, String gender, Date birth,String email) {
        return SeniorDTO.builder()
                .nickName(nickName)
                .name(name)
                .address(address)
                .phone(phone)
                .gender(gender)
                .email(email)
                .birth(birth).build();
    }

    public static SeniorDTO of(String nickName, String password) {
        return SeniorDTO.builder()
                .nickName(nickName)
                .password(password).build();
    }

    public void SeniorNickEqualsGuardian(String nickName) {
        this.nickName = nickName;
    }
}
