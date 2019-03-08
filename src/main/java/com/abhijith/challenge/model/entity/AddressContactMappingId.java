package com.abhijith.challenge.model.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class AddressContactMappingId implements Serializable {

    private String addressBookId;
    private String contactId;
}
