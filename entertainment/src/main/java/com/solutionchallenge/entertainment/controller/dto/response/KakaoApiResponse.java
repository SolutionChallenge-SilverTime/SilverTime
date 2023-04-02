package com.solutionchallenge.entertainment.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class KakaoApiResponse {

    @JsonProperty("meta")
    private MetaDto metaDto;

    @JsonProperty("documents")
    private List<DocumentDto> documents;

}
