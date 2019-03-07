package com.abhijith.challenge.model.incoming;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class CreateContactRequest implements Serializable {

    private String correlationId;

    @Valid
    @NotNull
    private ContactDto contact;

    @Data
    public static class ContactDto implements Serializable {

        @NotEmpty
        @NotNull
        private String firstName;

        private String lastName;

        @NotEmpty
        @NotNull
        private String mobileNumber;

        private String homePhone;
    }

}
