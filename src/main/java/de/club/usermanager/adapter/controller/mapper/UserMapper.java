package de.club.usermanager.adapter.controller.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;


public record UserMapper (
        @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
        Long id,

        @JsonProperty(value = "firstName")
        String firstName,

        @JsonProperty(value = "lastName")
        String lastName,

        @JsonProperty(value = "email")
        String email
)
{



}
