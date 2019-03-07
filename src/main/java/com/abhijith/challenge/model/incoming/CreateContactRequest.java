package com.abhijith.challenge.model.incoming;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class CreateContactRequest implements Serializable {

    private String correlationId;

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private String homePhone;

}
