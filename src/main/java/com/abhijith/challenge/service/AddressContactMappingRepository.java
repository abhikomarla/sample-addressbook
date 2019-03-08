package com.abhijith.challenge.service;

import com.abhijith.challenge.model.entity.AddressContactMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressContactMappingRepository extends JpaRepository<AddressContactMapping, String> {
}
