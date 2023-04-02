package com.solutionchallenge.entertainment.controller.dto.request;

import com.solutionchallenge.entertainment.service.dto.TutorDTO;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class TutorRequest {
    @NotNull
    private String nickName;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private String phone;
    @NotNull
    private String email;
    @NotNull
    private String gender;
    @NotNull
    private Date birth;
    @NotNull
    private String career;
    @NotNull
    private String introduction;

    public TutorDTO toServiceDto(){
        return TutorDTO.of(nickName, password, name, address, phone, email, gender, birth, career, introduction);
    }
}
