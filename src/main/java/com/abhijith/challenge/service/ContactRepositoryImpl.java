package com.abhijith.challenge.service;

import com.abhijith.challenge.model.entity.Contact;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

    @Override
    public List<Contact> findAllByAddressId(String addressBookId) {
        return null;
    }

    @Override
    public Contact findContactByIdAndAddressBook(final String addressBookId, final String contactId) {
        TypedQuery<Contact> query = entityManager.createQuery("SELECT c FROM contact c where " +
                "c.addressBookId = :addressBookId AND c.id = :contactId", Contact.class);
        query.setParameter("addressBookId", addressBookId);
        query.setParameter("contactId", contactId);

        return query.getSingleResult();
    }

    @Override
    public void deleteContactByIdAndAddressBook(final String addressBookId, final String contactId) {

    }
}
