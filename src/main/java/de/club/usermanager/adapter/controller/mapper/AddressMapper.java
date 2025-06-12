package de.club.usermanager.adapter.controller.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AddressMapper(
        @JsonProperty(value = "streetName")
        String streetName,

        @JsonProperty(value = "streetNumber")
        long streetNumber,

        @JsonProperty(value = "zipCode")
        long zipCode,

        @JsonProperty(value = "city")
        String city,

        @JsonProperty(value = "country")
        String country
) {
}
