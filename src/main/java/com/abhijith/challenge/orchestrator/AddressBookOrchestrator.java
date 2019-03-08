package com.abhijith.challenge.orchestrator;

import com.abhijith.challenge.model.entity.AddressContactMapping;
import com.abhijith.challenge.model.entity.AddressContactMappingId;
import com.abhijith.challenge.model.entity.Contact;
import com.abhijith.challenge.model.incoming.CreateContactRequest;
import com.abhijith.challenge.model.outgoing.CreateContactResponse;
import com.abhijith.challenge.service.AddressBookRepository;
import com.abhijith.challenge.service.AddressContactMappingRepository;
import com.abhijith.challenge.service.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Autowired
    private AddressContactMappingRepository addressContactMappingRepository;

    @Autowired
    private AddressBookRepository addressBookRepository;

    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ResponseEntity saveContact(final String addressBookId, final CreateContactRequest contactRequest) {
        CreateContactResponse createContactResponse = new CreateContactResponse();
        createContactResponse.setCorrelationId(contactRequest.getCorrelationId());
        HttpStatus status;

        if (addressBookRepository.existsById(addressBookId)) {

            CreateContactRequest.ContactDto contactDto = contactRequest.getContact();
            Contact contact = new Contact(contactDto.getFirstName(), contactDto.getLastName(),
                    contactDto.getMobileNumber(), contactDto.getHomePhone());

            AddressContactMapping mapping = new AddressContactMapping();
            AddressContactMappingId mappingId = new AddressContactMappingId();
            mappingId.setContactId(contact.getId());
            mappingId.setAddressBookId(addressBookId);
            mapping.setAddressContactMappingId(mappingId);

            addressContactMappingRepository.save(mapping);
            contactRepository.save(contact);

            //contact saved successfully
            status = HttpStatus.CREATED;
            createContactResponse.setMessage("Successfully created");
            String link = "/v1/address-books/" + addressBookId + "/contacts/" + contact.getId();
            createContactResponse.getParams().put("link", link);
        } else {
            status = HttpStatus.BAD_REQUEST;
            createContactResponse.setMessage("Invalid address book Id");
        }

        createContactResponse.setTime((new SimpleDateFormat(DATE_FORMAT)).format(new Date()));
        createContactResponse.setCode(status.value());
        ResponseEntity<CreateContactResponse> responseEntity = new ResponseEntity<>(createContactResponse, status);
        return responseEntity;
    }
}
