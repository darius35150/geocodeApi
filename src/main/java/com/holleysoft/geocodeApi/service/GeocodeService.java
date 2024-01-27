package com.holleysoft.geocodeApi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.holleysoft.geocodeApi.model.geocodedata.GeocodeData;
import com.holleysoft.geocodeApi.util.RestUtil;

@Service
public class GeocodeService {
    RestUtil restUtil;
    public GeocodeService(RestUtil restUtil){
        this.restUtil = restUtil;
    }

    public ResponseEntity<GeocodeData> getGeocodeByName(String param, String limit){
        ResponseEntity<GeocodeData> geocoodeResponse = restUtil.getGeocodeByName(param, limit);
        return geocoodeResponse;
    }
}
