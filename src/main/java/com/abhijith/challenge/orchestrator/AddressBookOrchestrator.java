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
        Contact contact = new Contact();
        contact.setFirstName(contactRequest.getFirstName());
        contact.setLastName(contactRequest.getLastName());
        contact.setHomePhone(contactRequest.getHomePhone());
        contact.setMobileNumber(contactRequest.getMobileNumber());
        contact.setAddressBookId(addressBookId);
        contactRepository.save(contact);
        System.out.println("Stored Contact id:: " + contact.getId());
        CreateContactResponse createContactResponse = new CreateContactResponse();
        createContactResponse.setMessage("Successfully created");
        createContactResponse.setTime((new SimpleDateFormat(DATE_FORMAT)).format(new Date()));
        createContactResponse.getParams().put("contactId", contact.getId());
        String link = "/addressBooks/" + addressBookId + "/contacts/" + contact.getId();
        createContactResponse.getParams().put("link", link);
        ResponseEntity<CreateContactResponse> responseEntity = new ResponseEntity<>(createContactResponse,
                HttpStatus.CREATED);
        return responseEntity;
    }
}
