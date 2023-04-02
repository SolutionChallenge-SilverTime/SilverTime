package com.solutionchallenge.entertainment.controller.dto.request;

import com.solutionchallenge.entertainment.domain.guardian.Guardian;
import com.solutionchallenge.entertainment.domain.senior.Senior;
import com.solutionchallenge.entertainment.service.dto.GuardianDTO;
import com.solutionchallenge.entertainment.service.dto.SeniorDTO;
import com.solutionchallenge.entertainment.service.dto.TutorDTO;
import lombok.*;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class UserRequest {
    @NotNull
    private int identity;
    @NotNull
    private String nickName;
    @NotNull
    private String password;

    public SeniorDTO toSeniorServiceDto(){
        return SeniorDTO.of(nickName, password);
    }
    public GuardianDTO toGuardianServiceDto(){
        return GuardianDTO.of(nickName, password);
    }
    public TutorDTO toTutorServiceDto(){
        return TutorDTO.of(nickName, password);
    }
}
