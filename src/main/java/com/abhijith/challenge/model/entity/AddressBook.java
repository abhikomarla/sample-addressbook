package com.abhijith.challenge.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity (name = "addressbook")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@NoArgsConstructor
public class AddressBook implements Serializable {

    @Id
    @Column (updatable = false, nullable = false)
    private String id;

    @Column
    private String name;

    @Column
    private String description;

    public AddressBook(final String id, final String name,
                       final String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

}
