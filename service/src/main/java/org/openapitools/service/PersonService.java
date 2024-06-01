package org.openapitools.service;

import org.openapitools.model.Person;
import java.util.List;

public interface PersonService {
    List<Person> searchPersons(String vorname, String nachname, String iban, String email);
}
