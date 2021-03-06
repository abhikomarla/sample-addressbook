package com.abhijith.challenge.service;

import com.abhijith.challenge.model.entity.Contact;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class ContactRepositoryImpl implements ContactRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Contact> findAllByAddressId(final String addressBookId) {
        TypedQuery<Contact> query = entityManager.createQuery("SELECT c FROM contact c where "
                + "c.id in (SELECT m.addressContactMappingId.contactId FROM "
                + "addresscontactmapping m where m.addressContactMappingId.addressBookId = :addressBookId)",
                Contact.class);
        query.setParameter("addressBookId", addressBookId);
        return query.getResultList();
    }

    @Override
    public Contact findContactByIdAndAddressBook(final String addressBookId, final String contactId) {
        TypedQuery<Contact> query = entityManager.createQuery("SELECT c FROM contact c where "
                + "c.id = (SELECT m.addressContactMappingId.contactId FROM "
                + "addresscontactmapping m where m.addressContactMappingId.addressBookId = :addressBookId "
                + "AND m.addressContactMappingId.contactId = :contactId)", Contact.class);
        query.setParameter("addressBookId", addressBookId);
        query.setParameter("contactId", contactId);

        return query.getSingleResult();
    }

    @Override
    public void deleteContactByIdAndAddressBook(final String addressBookId, final String contactId) {
        Query query = entityManager.createQuery("DELETE FROM addresscontactmapping where "
                + "addressContactMappingId.addressBookId = :addressBookId "
                + "AND addressContactMappingId.contactId = :contactId");
        query.setParameter("addressBookId", addressBookId);
        query.setParameter("contactId", contactId);
        query.executeUpdate();
    }

    @Override
    public List<Contact> getUniqueContactsInAllAddressBooks() {
        TypedQuery<Contact> query = entityManager.createQuery("SELECT c FROM contact c WHERE "
                + "c.id in (SELECT DISTINCT m.addressContactMappingId.contactId from addresscontactmapping m)",
                Contact.class);
        return query.getResultList();
    }
}
