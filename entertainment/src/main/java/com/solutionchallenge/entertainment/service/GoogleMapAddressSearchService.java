package com.solutionchallenge.entertainment.service;

import com.solutionchallenge.entertainment.controller.dto.response.GeocodingApiResponse;
import com.solutionchallenge.entertainment.controller.dto.response.KakaoApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Slf4j
@Service
@RequiredArgsConstructor
public class GoogleMapAddressSearchService {

    //public final RestTemplate restTemplate;
    public final GoogleMapUriBuilderService googleMapUriBuilderService;

    public GeocodingApiResponse requestAddressSearch(String location){

        if(ObjectUtils.isEmpty(location)) throw new IllegalArgumentException("Location is null");

        URI uri = googleMapUriBuilderService.buildUriByAddressSearch(location);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity<>(headers);

        return new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, GeocodingApiResponse.class).getBody();
    }


}
