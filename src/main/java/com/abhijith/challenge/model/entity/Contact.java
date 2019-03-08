package com.abhijith.challenge.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity(name = "contact")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Contact implements Serializable {

    protected Contact() { }

    public Contact(final String firstName, final String lastName,
                   final String mobileNumber, final String homePhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.homePhone = homePhone;

        //to make sure the id is same for a same combination of first name and mobile number
        StringBuffer buffer = new StringBuffer();
        buffer.append(firstName).append(mobileNumber);
        this.id = Integer.toString(Math.abs(buffer.toString().hashCode()));
        System.out.println("Hashcode :: " + this.id);
    }

    @Id
    @Column
    private String id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String mobileNumber;

    @Column
    private String homePhone;

}
