package com.abhijith.challenge.model.entity;

import lombok.Data;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Entity (name = "addresscontactmapping")
public class AddressContactMapping implements Serializable {

    @EmbeddedId
    private AddressContactMappingId addressContactMappingId;

}

