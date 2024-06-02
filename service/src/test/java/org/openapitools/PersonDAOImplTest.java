package org.openapitools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapitools.dao.PersonDAOImpl;
import org.openapitools.dto.PersonDTO;
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
        person1.setVorname("John");
        person1.setNachname("Doe");

        Anschrift anschrift = new Anschrift();
        person1.setAnschriften(List.of(anschrift));

        Bankverbindung bankverbindung1 = new Bankverbindung();
        Bankverbindung bankverbindung2 = new Bankverbindung();
        bankverbindung1.setIban("DE1234");
        bankverbindung2.setIban("DE4567");
        person1.setBankverbindungen(List.of(bankverbindung1, bankverbindung2));

        Kommunikationsadresse kommunikationsadresse = new Kommunikationsadresse();
        kommunikationsadresse.setEmail("johndoe@example.com");
        person1.setKommunikationsadressen(List.of(kommunikationsadresse));

        Person person2 = new Person();
        person2.setVorname("Jane");
        person2.setNachname("Doe");

        testData.add(person1);
        testData.add(person2);

        personDAO = new PersonDAOImpl(testData);
    }

    @Test
    void searchPersonsStructure() {
        List<PersonDTO> results = personDAO.searchPersons("John", "Doe", "DE1234", "johndoe@example.com");
        assertEquals(1, results.size());
        assertEquals(1, results.get(0).getNumberOfAnschriften());
        assertEquals(1, results.get(0).getNumberOfKommunikationsadressen());
        assertEquals("DE1234, DE4567", results.get(0).getIbans());
    }

    @Test
    void searchPersons_byVorname() {
        List<PersonDTO> results = personDAO.searchPersons("John", null, null, null);
        assertEquals(1, results.size());
        assertEquals("John", results.get(0).getVorname());
    }

    @Test
    void searchPersons_byNachname() {
        List<PersonDTO> results = personDAO.searchPersons(null, "Doe", null, null);
        assertEquals(2, results.size());
        assertEquals("John", results.get(0).getVorname());
        assertEquals("Jane", results.get(1).getVorname());
    }

    @Test
    void searchPersons_byIban() {
        List<PersonDTO> results = personDAO.searchPersons(null, null, "DE1234", null);
        assertEquals(1, results.size());
        assertTrue(results.get(0).getIbans().contains("DE1234"));
        assertEquals("John", results.get(0).getVorname());
    }

    @Test
    void searchPersons_byNonExistentParam() {
        List<PersonDTO> results = personDAO.searchPersons("NonExistent", null, null, null);
        assertTrue(results.isEmpty());
    }

    @Test
    void searchPersons_byMultipleParams() {
        List<PersonDTO> results = personDAO.searchPersons("John", "Doe", "DE1234", "johndoe@example.com");
        assertEquals(1, results.size());
    }
}