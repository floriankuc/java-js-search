package org.openapitools.dao;

import org.openapitools.dto.PersonDTO;
import org.openapitools.model.Person;

import java.io.IOException;
import java.util.List;

public interface PersonDAO {
    List<PersonDTO> searchPersons(String vorname, String nachname, String iban, String email);
}
