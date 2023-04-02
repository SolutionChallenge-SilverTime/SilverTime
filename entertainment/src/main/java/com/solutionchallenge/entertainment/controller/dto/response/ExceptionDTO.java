package com.solutionchallenge.entertainment.controller.dto.response;

import lombok.*;

@Builder
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)

public class ExceptionDTO {
    private String error;
}
