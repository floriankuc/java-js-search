package org.openapitools.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.openapitools.dataLoader.DataLoader;
import org.openapitools.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonDAOImpl implements PersonDAO {

    private final List<Person> personList;

    @Autowired
    public PersonDAOImpl(DataLoader dataLoader) throws IOException {
        dataLoader.loadData("/beispieldaten.json", Person.class);
        this.personList = dataLoader.getData();
    }

    public PersonDAOImpl(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public List<Person> searchPersons(String vorname, String nachname, String iban, String email) {
        return personList.stream()
                .filter(person -> (vorname == null || person.getVorname().equalsIgnoreCase(vorname)) &&
                        (nachname == null || person.getNachname().equalsIgnoreCase(nachname)) &&
                        (iban == null || person.getBankverbindungen().stream().anyMatch(bank -> bank.getIban().equalsIgnoreCase(iban))) &&
                        (email == null || person.getKommunikationsadressen().stream().anyMatch(comm -> comm.getEmail().equalsIgnoreCase(email))))
                .collect(Collectors.toList());
    }
}
