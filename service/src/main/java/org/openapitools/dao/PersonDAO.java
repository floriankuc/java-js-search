package org.openapitools.dao;

import org.openapitools.model.Person;

import java.io.IOException;
import java.util.List;

public interface PersonDAO {
    List<Person> searchPersons(String vorname, String nachname, String iban, String email);
}
