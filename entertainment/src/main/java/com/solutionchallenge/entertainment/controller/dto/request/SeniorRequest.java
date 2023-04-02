package com.solutionchallenge.entertainment.controller.dto.request;

import com.solutionchallenge.entertainment.service.dto.InterestDTO;
import com.solutionchallenge.entertainment.service.dto.SeniorDTO;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class SeniorRequest {
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
    private List<String> interests;
    private List<Long> interestIds;

    public SeniorDTO toServiceDto() {
        return SeniorDTO.of(nickName, password, name, email,address, phone, gender, birth);
    }
    public InterestDTO toInterestServiceDto(){
        return InterestDTO.of(interests);
    }

    public InterestDTO toInterestIdServiceDto(){
        return InterestDTO.idOf(interestIds);
    }

}
