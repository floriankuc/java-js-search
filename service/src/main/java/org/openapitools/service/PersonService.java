package org.openapitools.service;

import org.openapitools.dto.PersonDTO;
import org.openapitools.model.Person;
import java.util.List;

public interface PersonService {
    List<PersonDTO> searchPersons(String vorname, String nachname, String iban, String email);
}
