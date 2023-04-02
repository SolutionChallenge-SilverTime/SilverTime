package com.solutionchallenge.entertainment.service.dto;

import com.solutionchallenge.entertainment.domain.tutor.Tutor;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class TutorDTO {
    private String nickName;
    private String password;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String gender;
    private Date birth;
    private String career;
    private String introduction;
    public static TutorDTO of(String nickName, String password, String name, String address, String phone, String email, String gender, Date birth, String career, String introduction) {
        return new TutorDTO(nickName, password, name, address, phone, email, gender, birth, career, introduction);
    }

    public static TutorDTO of(String nickName, String password) {
        return TutorDTO.builder()
                .nickName(nickName)
                .password(password)
                .build();
    }
}
