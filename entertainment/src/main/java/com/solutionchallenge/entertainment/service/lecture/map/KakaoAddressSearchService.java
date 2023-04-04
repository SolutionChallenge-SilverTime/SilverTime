package com.solutionchallenge.entertainment.service.lecture.map;

import com.solutionchallenge.entertainment.controller.dto.response.KakaoApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import org.springframework.http.HttpHeaders;

@Slf4j
@Service
@RequiredArgsConstructor
public class KakaoAddressSearchService {

    //public final RestTemplate restTemplate;
    public final KakaoUriBuilderService kakaoUriBuilderService;

//    @Value("${kakao.rest.api.key}") // 인텔리제이 환경변수로 key값 넣어주고 실행할 것.
//    private String kakaoRestApiKey;

    public KakaoApiResponse requestAddressSearch(String location){

        if(ObjectUtils.isEmpty(location)) throw new IllegalArgumentException("Location is null");

        URI uri = kakaoUriBuilderService.buildUriByAddressSearch(location);

        HttpHeaders headers = new HttpHeaders();

        //headers.set(HttpHeaders.AUTHORIZATION, "KakaoAK " + kakaoRestApiKey);

        HttpEntity httpEntity = new HttpEntity<>(headers);

        return new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, KakaoApiResponse.class).getBody();
    }


}
