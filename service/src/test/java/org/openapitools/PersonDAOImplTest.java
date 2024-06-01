package org.openapitools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapitools.dao.PersonDAOImpl;
import org.openapitools.model.Anschrift;
import org.openapitools.model.Bankverbindung;
import org.openapitools.model.Kommunikationsadresse;
import org.openapitools.model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonDAOImplTest {

    private PersonDAOImpl personDAO;

    @BeforeEach
    void setUp() throws IOException {
        ArrayList<Person> testData = new ArrayList<>();

        Person person1 = new Person();
        Anschrift anschrift = new Anschrift();
        Bankverbindung bankverbindung = new Bankverbindung();
        Kommunikationsadresse kommunikationsadresse = new Kommunikationsadresse();

        person1.setVorname("John");
        person1.setNachname("Doe");
        bankverbindung.setIban("DE1234");
        kommunikationsadresse.setEmail("johndoe@example.com");
        person1.setAnschriften(List.of(anschrift));
        person1.setBankverbindungen(List.of(bankverbindung));
        person1.setKommunikationsadressen(List.of(kommunikationsadresse));

        Person person2 = new Person();
        person2.setVorname("Jane");
        person2.setNachname("Doe");

        testData.add(person1);
        testData.add(person2);

        personDAO = new PersonDAOImpl(testData);
    }

    @Test
    void searchPersons_byVorname() {
        List<Person> results = personDAO.searchPersons("John", null, null, null);
        assertEquals(1, results.size());
        assertEquals("John", results.get(0).getVorname());
    }

    @Test
    void searchPersons_byNachname() {
        List<Person> results = personDAO.searchPersons(null, "Doe", null, null);
        assertEquals(2, results.size());
        assertEquals("John", results.get(0).getVorname());
        assertEquals("Jane", results.get(1).getVorname());
    }

    @Test
    void searchPersons_byIban() {
        List<Person> results = personDAO.searchPersons(null, null, "DE1234", null);
        assertEquals(1, results.size());
        assertEquals("DE1234", results.get(0).getBankverbindungen().get(0).getIban());
        assertEquals("John", results.get(0).getVorname());
    }

    @Test
    void searchPersons_byNonExistentParam() {
        List<Person> results = personDAO.searchPersons("NonExistent", null, null, null);
        assertTrue(results.isEmpty());
    }

    @Test
    void searchPersons_byMultipleParams() {
        List<Person> results = personDAO.searchPersons("John", "Doe", "DE1234", "johndoe@example.com");
        assertEquals(1, results.size());
    }

    @Test
    void searchPersons() {
        List<Person> results = personDAO.searchPersons("John", "Doe", "DE1234", "johndoe@example.com");
        assertEquals(1, results.size());
        assertEquals(1, results.get(0).getBankverbindungen().size());
        assertEquals(1, results.get(0).getKommunikationsadressen().size());
        assertEquals(1, results.get(0).getAnschriften().size());
    }
}