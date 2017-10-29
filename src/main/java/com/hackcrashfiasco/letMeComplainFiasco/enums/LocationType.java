package com.hackcrashfiasco.letMeComplainFiasco.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum LocationType {

    @JsonProperty("internet")
    INTERNET,
    @JsonProperty("not internet")
    NOT_INTERNET

}
