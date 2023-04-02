package com.solutionchallenge.entertainment.controller.dto.request;

import com.solutionchallenge.entertainment.service.dto.GuardianDTO;
import com.solutionchallenge.entertainment.service.dto.InterestDTO;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class GuardianRequest {
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
    private String gender;
    private Date birth;
    private String seniorNickName;
    private String seniorName;
    private String seniorAddress;
    private String seniorPhone;
    private String seniorGender;
    private Date seniorBirth;

    private String seniorEmail;
    private List<String> interests;
    private List<Long> interestIds;

    public GuardianDTO toServiceDto(){
        return GuardianDTO.of(nickName, password, name, address, phone, email, gender, birth, seniorNickName);
    }
    public GurdianInputSeniorRequest toInputRequest(){
        return GurdianInputSeniorRequest.of(nickName,seniorName,seniorAddress,seniorPhone,seniorGender,seniorBirth,seniorEmail);
    }
    public InterestDTO toInterestServiceDto(){
        return InterestDTO.of(interests);
    }
    public InterestDTO toInterestIdServiceDto(){
        return InterestDTO.idOf(interestIds);
    }
}
