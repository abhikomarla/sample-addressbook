package com.abhijith.challenge.orchestrator;

import com.abhijith.challenge.model.entity.Contact;
import com.abhijith.challenge.model.incoming.CreateContactRequest;
import com.abhijith.challenge.model.outgoing.CreateContactResponse;
import com.abhijith.challenge.service.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class AddressBookOrchestrator {

    @Autowired
    private ContactRepository contactRepository;

    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

    public ResponseEntity saveContact(final String addressBookId, final CreateContactRequest contactRequest) {
        CreateContactResponse createContactResponse = new CreateContactResponse();
        createContactResponse.setCorrelationId(contactRequest.getCorrelationId());
        HttpStatus status = null;
        if (contactRepository.findIfDuplicatePresent(addressBookId, contactRequest.getContact().getMobileNumber())) {
            status = HttpStatus.CONFLICT;
            createContactResponse.setMessage("Duplicate contact found");
            createContactResponse.setCode(HttpStatus.CONFLICT.value());
        } else {
            Contact contact = new Contact();
            contact.setFirstName(contactRequest.getContact().getFirstName());
            contact.setLastName(contactRequest.getContact().getLastName());
            contact.setHomePhone(contactRequest.getContact().getHomePhone());
            contact.setMobileNumber(contactRequest.getContact().getMobileNumber());
            contact.setAddressBookId(addressBookId);
            contactRepository.save(contact);
            status = HttpStatus.CREATED;
            createContactResponse.setMessage("Successfully created");
            String link = "/addressBooks/" + addressBookId + "/contacts/" + contact.getId();
            createContactResponse.getParams().put("link", link);
        }
        createContactResponse.setTime((new SimpleDateFormat(DATE_FORMAT)).format(new Date()));
        ResponseEntity<CreateContactResponse> responseEntity = new ResponseEntity<>(createContactResponse, status);
        return responseEntity;
    }
}
