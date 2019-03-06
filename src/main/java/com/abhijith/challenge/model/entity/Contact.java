package com.abhijith.challenge.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Contact implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private String homePhone;
}
