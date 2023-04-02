package com.solutionchallenge.entertainment.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GeoResultDto {

    @JsonProperty("formatted_address")
    private String addressName;

    @JsonProperty("geometry")
    private GeometryDto geometry;

}
