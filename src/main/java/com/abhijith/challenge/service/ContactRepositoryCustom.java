package com.abhijith.challenge.service;

import com.abhijith.challenge.model.entity.Contact;

import java.util.List;

public interface ContactRepositoryCustom {

    List<Contact> getUniqueContactsInAllAddressBooks();
}
