package com.holleysoft.geocodeApi.service;

import org.json.JSONArray;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.holleysoft.geocodeApi.model.geocodedata.GeocodeData;
import java.util.*;

import com.holleysoft.geocodeApi.util.RestUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GeocodeService {
    RestUtil restUtil;
    public GeocodeService(RestUtil restUtil){
        this.restUtil = restUtil;
    }

    public ResponseEntity<String> getGeocodeByName(String param, String limit){
        ResponseEntity<String> geocoodeResponse = restUtil.getGeocodeByName(param, limit);
        mapDataToGeocodeDataDto(geocoodeResponse);
        return geocoodeResponse;
    }

    private ResponseEntity<List<GeocodeData>> mapDataToGeocodeDataDto(ResponseEntity<String> geocodeResponse){
        List<GeocodeData> geocodeDataList = new ArrayList();
        JSONArray jsonArray = new JSONArray(geocodeResponse.getBody().toString());
        BeanUtils.copyProperties(jsonArray, geocodeDataList);
        for(GeocodeData data : geocodeDataList)
            log.info(data.toString());
        return null;
    }
}
