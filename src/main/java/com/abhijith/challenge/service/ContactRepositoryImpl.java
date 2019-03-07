package com.abhijith.challenge.service;

import com.abhijith.challenge.model.entity.Contact;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class ContactRepositoryImpl implements ContactRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Contact> getUniqueContactsInAllAddressBooks() {
        return null;
    }
}
