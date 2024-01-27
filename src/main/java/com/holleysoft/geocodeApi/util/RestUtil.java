package com.holleysoft.geocodeApi.util;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import com.holleysoft.geocodeApi.model.geocodedata.GeocodeData;

public class RestUtil {
    WebClient webClient;
    String key = "0e45d113947a0ca900ecd68644300041";

    RestUtil(WebClient webClient){
        this.webClient = webClient;
    }   

    public ResponseEntity<GeocodeData> getGeocodeByName(String param, String limit){
        ResponseEntity<GeocodeData> data = null;
        try {
            URI url = new URI("http://api.openweathermap.org/geo/1.0/direct?" + param + (limit != null ? "&limit=" +limit : "") + "&appid=" + key);
            data = webClient.get().uri(url).retrieve().toEntity(GeocodeData.class).block();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return data;
    }
}
