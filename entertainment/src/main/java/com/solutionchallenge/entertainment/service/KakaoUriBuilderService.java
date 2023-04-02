package com.solutionchallenge.entertainment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
@RequiredArgsConstructor
public class KakaoUriBuilderService {

    private static final String KAKAO_LOCAL_SEARCH_ADDRESS_URL =  "https://dapi.kakao.com/v2/local/search/address.json";

    public URI buildUriByAddressSearch(String location){
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(KAKAO_LOCAL_SEARCH_ADDRESS_URL);
        uriBuilder.queryParam("query", location);

        URI uri =uriBuilder.build().encode().toUri();
        log.info("Request location : {} , Built URI : {} ", location, uri);

        return uri;
    }


}
