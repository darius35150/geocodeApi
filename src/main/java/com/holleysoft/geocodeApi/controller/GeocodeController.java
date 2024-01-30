package com.holleysoft.geocodeApi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.holleysoft.geocodeApi.model.geocodedata.GeocodeData;
import com.holleysoft.geocodeApi.model.geocodezip.GeocodeByZipDto;
import com.holleysoft.geocodeApi.service.GeocodeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/geocode")
public class GeocodeController {
    GeocodeService geocodeService;
    public GeocodeController(GeocodeService geocodeService){
        this.geocodeService = geocodeService;
    }

    @GetMapping("/byName")
    public ResponseEntity<List<GeocodeData>> getGeocodeByName(
        @RequestParam("q") String param,
        @RequestParam(value = "limit", required=false) String limit
        ) {
        ResponseEntity<List<GeocodeData>> geocoodeResponse = geocodeService.getGeocodeByName(param, limit);
        return geocoodeResponse;
    }

    @GetMapping("/byZip/{zip}")
    public ResponseEntity<GeocodeByZipDto> getMethodName(@PathVariable String zip, @RequestParam(value = "countryAbbrev", required = false) String countryAbbrev) {

        ResponseEntity<GeocodeByZipDto> zipResponse = geocodeService.getGeocodeByZip(zip, countryAbbrev);
        return zipResponse;
    }
    
    
}
