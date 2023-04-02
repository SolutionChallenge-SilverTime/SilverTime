package com.solutionchallenge.entertainment.service.dto;

import lombok.*;

import java.security.Key;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class SignificantDTO {
    private String tutorNickName;
    private String gurdianNickName;
    private String seniorName;
    private String title;
    private String lectureName;
    private String content;

    public static SignificantDTO of(String tutorNickName, String gurdianNickName, String seniorName, String title, String lectureName, String content) {
        return new SignificantDTO(tutorNickName, gurdianNickName, seniorName, title, lectureName, content);
    }
}
