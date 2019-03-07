package com.abhijith.challenge;

import com.abhijith.challenge.model.entity.AddressBook;
import com.abhijith.challenge.service.AddressBookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SampleAddressBookApplication {

    public static void main(final String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SampleAddressBookApplication.class, args);

        AddressBookRepository addressBookRepository = context.getBean(AddressBookRepository.class);
        addressBookRepository.save(new AddressBook("1000", "Business", "Business contacts"));
        addressBookRepository.save(new AddressBook("1001", "Personal", "Personal contacts"));

    }
}
