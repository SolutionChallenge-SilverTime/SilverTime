package com.solutionchallenge.entertainment.controller.dto.request;

import com.solutionchallenge.entertainment.service.dto.SignificantDTO;
import lombok.*;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class SignificantRequest {
    @NotNull
    private String gurdianNickName;
    private String tutorNickName;
    @NotNull
    private String seniorName;
    @NotNull
    private String title;
    @NotNull
    private String lectureName;
    @NotNull
    private String content;

    public SignificantDTO toSeriveDto() {
        return SignificantDTO.of(tutorNickName,gurdianNickName,seniorName,title,lectureName,content);
    }
}
