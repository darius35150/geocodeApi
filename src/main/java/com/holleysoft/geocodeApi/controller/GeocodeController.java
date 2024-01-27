package com.holleysoft.geocodeApi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.holleysoft.geocodeApi.model.geocodedata.GeocodeData;
import com.holleysoft.geocodeApi.service.GeocodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/geocode")
public class GeocodeController {
    GeocodeService geocodeService;
    public GeocodeController(GeocodeService geocodeService){
        this.geocodeService = geocodeService;
    }

    @GetMapping("/byName/")
    public ResponseEntity<GeocodeData> getGeocodeByName(
        @RequestParam("q") String param,
        @RequestParam("limit") String limit
        ) {
        ResponseEntity<GeocodeData> geocoodeResponse = geocodeService.getGeocodeByName(param, limit);
        return geocoodeResponse;
    }
    
}
