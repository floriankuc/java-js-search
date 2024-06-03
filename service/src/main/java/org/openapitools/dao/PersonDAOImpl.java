package org.openapitools.dao;

import org.openapitools.dataLoader.DataLoader;
import org.openapitools.dto.PersonDTO;
import org.openapitools.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
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
    public List<PersonDTO> searchPersons(String vorname, String nachname, String iban, String email) {
        return personList.stream()
                .filter(person -> matchesVorname(person, vorname))
                .filter(person -> matchesNachname(person, nachname))
                .filter(person -> matchesIban(person, iban))
                .filter(person -> matchesEmail(person, email))
                .map(this::convertToPersonDTO)
                .collect(Collectors.toList());
    }

    private boolean matchesVorname(Person person, String vorname) {
        return vorname == null || person.getVorname().equalsIgnoreCase(vorname);
    }

    private boolean matchesNachname(Person person, String nachname) {
        return nachname == null || person.getNachname().equalsIgnoreCase(nachname);
    }

    private boolean matchesIban(Person person, String iban) {
        return iban == null || person.getBankverbindungen().stream()
                .anyMatch(bank -> bank.getIban().equalsIgnoreCase(iban));
    }

    private boolean matchesEmail(Person person, String email) {
        return email == null || person.getKommunikationsadressen().stream()
                .anyMatch(comm -> comm.getEmail().equalsIgnoreCase(email));
    }

    private PersonDTO convertToPersonDTO(Person person) {
        return new PersonDTO(
                person.getNachname(),
                person.getVorname(),
                person.getGeschlecht(),
                person.getAnschriften().size(),
                person.getKommunikationsadressen().size(),
                person.getBankverbindungen().stream()
                        .map(bank -> bank.getIban())
                        .collect(Collectors.joining(", "))
        );
    }
}
