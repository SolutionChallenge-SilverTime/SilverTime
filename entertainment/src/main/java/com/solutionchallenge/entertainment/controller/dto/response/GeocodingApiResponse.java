package com.solutionchallenge.entertainment.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GeocodingApiResponse {

    @JsonProperty("status")
    private String status;

    @JsonProperty("results")
    private List<GeoResultDto> result;

}
