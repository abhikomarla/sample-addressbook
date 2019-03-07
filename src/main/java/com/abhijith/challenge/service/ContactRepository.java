package com.abhijith.challenge.service;

import com.abhijith.challenge.model.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ContactRepository extends JpaRepository<Contact, String>, ContactRepositoryCustom {
}
