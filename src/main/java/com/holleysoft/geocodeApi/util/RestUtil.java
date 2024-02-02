package com.holleysoft.geocodeApi.util;

import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class RestUtil {
    WebClient webClient = WebClient.create();
    String key = "0e45d113947a0ca900ecd68644300041";

    RestUtil(){
    }   

    public ResponseEntity<String> getGeocodeByName(String param, String limit){
        ResponseEntity<String> data = null;
        try {
            URI url = new URI("http://api.openweathermap.org/geo/1.0/direct?q=" + param + (limit != null ? "&limit=" +limit : "") + "&appid=" + key);
            data = webClient.get().uri(url).retrieve().toEntity(String.class).block();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return data;
    }

    public ResponseEntity<String> getGeocodeByZip(String zip, String conuntryAbbrev){
        ResponseEntity<String> data = null;
        try {
            URI url = new URI("http://api.openweathermap.org/geo/1.0/zip?zip=" + zip + (conuntryAbbrev != null ? "," + conuntryAbbrev : "") + "&appid=" + key);
            data = webClient.get().uri(url).retrieve().toEntity(String.class).block();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return data;
    }

    public ResponseEntity<String> getGeocodeByCoordinates(String lat, String lon, String limit){
        ResponseEntity<String> data = null;
        try {
            URI url = new URI("http://api.openweathermap.org/geo/1.0/reverse?lat=" + lat + "&lon=" + lon + (limit != null ? "&limit=" + limit : "") + "&appid=" + key);
            data = webClient.get().uri(url).retrieve().toEntity(String.class).block();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return data;
    }
}
