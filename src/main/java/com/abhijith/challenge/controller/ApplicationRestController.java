package com.abhijith.challenge.controller;

import com.abhijith.challenge.model.entity.Contact;
import com.abhijith.challenge.model.incoming.CreateContactRequest;
import com.abhijith.challenge.orchestrator.AddressBookOrchestrator;
import com.abhijith.challenge.service.ContactRepositoryImpl;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/address-books")
public class ApplicationRestController {

    @Autowired
    private ContactRepositoryImpl contactRepository;

    @Autowired
    private AddressBookOrchestrator addressBookOrchestrator;

    @PutMapping(value = "/{addressBookId}/contacts", headers = "Accept=application/json")
    public ResponseEntity createContact(@PathVariable @NonNull @NotEmpty final String addressBookId,
                                        @NonNull @Valid @RequestBody final CreateContactRequest contact) {
        return addressBookOrchestrator.saveContact(addressBookId, contact);
    }

    @GetMapping(value = "/{addressBookId}/contacts/{contactId}")
    public ResponseEntity getContact(@PathVariable final String addressBookId,
                                          @PathVariable final String contactId) {
        Contact contact = contactRepository.findContactByIdAndAddressBook(addressBookId, contactId);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @GetMapping(value = "/{addressBookId}/contacts")
    public ResponseEntity getAllContacts(@PathVariable final String addressBookId) {
        List<Contact> contacts = contactRepository.findAllByAddressId(addressBookId);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{addressBookId}/contacts/{contactId}")
    public ResponseEntity deleteContact(@PathVariable final String addressBookId,
                                            @PathVariable final String contactId) {
        contactRepository.deleteContactByIdAndAddressBook(addressBookId, contactId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/unique-contacts")
    public ResponseEntity getUniqueContacts() {
        List<Contact> contacts = contactRepository.getUniqueContactsInAllAddressBooks();
        return new ResponseEntity(contacts, HttpStatus.OK);
    }

}
