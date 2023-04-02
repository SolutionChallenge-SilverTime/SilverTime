package com.solutionchallenge.entertainment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
@RequiredArgsConstructor
public class GoogleMapUriBuilderService {

    private static final String GOOGLE_LOCAL_SEARCH_ADDRESS_URL =  "https://maps.googleapis.com/maps/api/geocode/json";

    public URI buildUriByAddressSearch(String location){
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(GOOGLE_LOCAL_SEARCH_ADDRESS_URL);
        uriBuilder.queryParam("address", location);
        uriBuilder.queryParam("key", "AIzaSyADDl-QllKjZzGT5rz7sVdkNU9mExb9vXQ");
        uriBuilder.queryParam("language", "ko");

        URI uri =uriBuilder.build().encode().toUri();
        log.info("Request location : {} , Built URI : {} ", location, uri);

        return uri;
    }


}
