package com.abhijith.challenge.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity(name = "contact")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@NamedNativeQuery(name = "Contact.getContactByIdAndAddressBook",
        query = "SELECT * FROM CONTACT c "
                + "WHERE c.addressBookId = ? AND c.id = ?", resultClass = Contact.class)
public class Contact implements Serializable {

    public Contact() {
        this.id = UUID.randomUUID().toString();
    }

    @Id
    @Column (updatable = false, nullable = false)
    private String id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String mobileNumber;

    @Column
    private String homePhone;

    @Column
    @JoinColumn(foreignKey = @ForeignKey (name = "addressbook_id"))
    private String addressBookId;

}
