package com.solutionchallenge.entertainment.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GeometryDto {

    @JsonProperty("location")
    private Map<String,Double> location;


}
