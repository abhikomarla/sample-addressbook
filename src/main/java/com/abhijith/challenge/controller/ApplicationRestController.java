package com.abhijith.test.controller;

import com.abhijith.test.model.incoming.ContactRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationRestController {

    @PutMapping(value = "/addressBooks/{addressBookId}/contacts", headers = "Accept=application/json")
    public ResponseEntity createContact(@PathVariable final String addressBookId,
                                        @NonNull @RequestBody final ContactRequest contact) {
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping(value = "/addressBooks/{addressBookId}/contacts/{contactId}")
    public ResponseEntity getContact(@PathVariable final String addressBookId,
                                          @PathVariable final String contactId) {
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping(value = "/addressBooks/{addressBookId}/contacts")
    public ResponseEntity getAllContacts(@PathVariable final String addressBookId) {
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping(value = "/addressBooks/{addressBookId}/contacts/{contactId}")
    public ResponseEntity deleteContact(@PathVariable final String addressBookId,
                                            @PathVariable final String contactId) {
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping(value = "/addressBooks/contacts")
    public ResponseEntity getUniqueContacts() {
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

}
