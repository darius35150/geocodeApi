package com.holleysoft.geocodeApi.model.geocodedata;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class GeocodeData {
    String name;
    GeocodeLocalNamesDto local_names;
    Long lat;
    Long lon;
    String country;
    String state;
}
