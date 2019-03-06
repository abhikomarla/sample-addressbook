package com.abhijith.challenge.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class AddressBook implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

}
