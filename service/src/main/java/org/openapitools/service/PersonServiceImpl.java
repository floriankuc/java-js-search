package org.openapitools.service;

import org.openapitools.dao.PersonDAO;
import org.openapitools.dto.PersonDTO;
import org.openapitools.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDAO personDAO;

    @Autowired
    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public List<PersonDTO> searchPersons(String vorname, String nachname, String iban, String email) {
        if (vorname == null && nachname == null && iban == null && email == null) {
            throw new RuntimeException("At least one search criterion must be provided.");
        }
        return personDAO.searchPersons(vorname, nachname, iban, email);
    }
}
