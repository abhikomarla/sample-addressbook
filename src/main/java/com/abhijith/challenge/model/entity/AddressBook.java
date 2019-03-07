package com.abhijith.challenge.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany
    @JoinColumn(name="CONTACT_ID")
    private List<Contact> contacts = new ArrayList<>();

    public AddressBook(final String id, final String name,
                       final String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

}
