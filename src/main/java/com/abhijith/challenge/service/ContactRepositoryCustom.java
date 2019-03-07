package com.abhijith.challenge.service;

import com.abhijith.challenge.model.entity.Contact;

import java.util.List;

public interface ContactRepositoryCustom {

    List<Contact> getUniqueContactsInAllAddressBooks();

    List<Contact> findAllByAddressId(final String addressBookId);

    Contact findContactByIdAndAddressBook(final String addressBookId, final String contactId);

    void deleteContactByIdAndAddressBook(final String addressBookId, final String contactId);

    boolean findIfDuplicatePresent(String addressBookId, String mobileNumber);
}
