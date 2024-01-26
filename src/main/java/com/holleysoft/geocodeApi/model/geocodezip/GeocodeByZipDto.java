package com.holleysoft.geocodeApi.model.geocodezip;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class GeocodeByZipDto {
    String zip;
    String name;
    Long lat;
    Long lon;
    String country;
}
