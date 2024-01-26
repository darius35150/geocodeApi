package com.holleysoft.geocodeApi.util;

import org.springframework.web.reactive.function.client.WebClient;

public class RestUtil {
    WebClient webClient;

    RestUtil(WebClient webClient){
        this.webClient = webClient;
    }
}
