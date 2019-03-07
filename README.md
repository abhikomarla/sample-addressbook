# SAMPLE ADDRESS BOOK

A sample address book application built using spring boot, h2 database and JPA.

### Getting started

To compile the application, use command
mvn clean compile

To run the application, use command

mvn spring-boot:run

### Important assumptions
* The creation of a contact record has been made to avoid duplicate insertions. A combination of address book id and 
the mobile number is used to check if the combination already exists. If the combination exists, the creation is not 
allowed.

* At the start of the application 2 address book records are created in memory with identifiers 1000 and 1001 

### This Rest API exposes 5 Rest endpoints as below

* PUT : /v1/address-books/{address-book-id}/contacts  
    Create a contact record under an address book
    ```
    Sample request: 
    {
        "correlationId": "8a7fb6a0-9d31-4e00-a66a-3c562439184e",
        "contact": {
            "firstName": "Abhijith",
            "lastName": "Komarla",
            "mobileNumber": "04*******",
            "homePhone": "03*******", 
        }
    }
    ```

    ```
    Sample response: 
    {
        "code": 201,
        "message": "Successfully created",
        "time": "2019-03-08T02:08:08.442+1100",
        "params": {
            "link": "/addressBooks/1001/contacts/6628a910-d1a9-4a39-bc8b-7372e9869606"
        },
        "correlationId": "8a7fb6a0-9d31-4e00-a66a-3c562439184e"
    }
    ```

* GET : /v1/address-books/{address-book-id}/contacts/{contact-id}  
    Retrieve a contact record under an address book 
    ```
    Sample response: 
    {
        "id": "d0765767-9d40-4342-9485-3a57a339a013",
        "firstName": "Abhijith",
        "lastName": "Komarla",
        "mobileNumber": "04********",
        "homePhone": "03********",
        "addressBookId": "1001"
    }
    ```
 
* GET : /v1/address-books/{address-book-id}/contacts  
    Retrieve all the contacts under an address book
    ```
    Sample response
    [
        {
            "id": "a7430f13-7da1-491c-a6d0-0175e68a745d",
            "firstName": "Abhijith",
            "lastName": "Komarla",
            "mobileNumber": "04********",
            "homePhone": "03********",
            "addressBookId": "1001"
        }
    ]
    ```

* DELETE : /v1/address-books/{address-book-id}/contacts/{contact-id}  
    Delete a contact record under an address book

* GET :  /v1/address-books/unique-contacts  
    Retrieve unique set of contact records across all the address books
    ```
    Sample response
    [
        {
            "id": "a7430f13-7da1-491c-a6d0-0175e68a745d",
            "firstName": "Abhijith",
            "lastName": "Komarla",
            "mobileNumber": "04********",
            "homePhone": "03********",
            "addressBookId": "1001"
        }
    ]
    ```
