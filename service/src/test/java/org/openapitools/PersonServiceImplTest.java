package org.openapitools;

import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openapitools.dao.PersonDAO;
import org.openapitools.model.Person;
import org.openapitools.service.PersonServiceImpl;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonServiceImplTest {

    @Mock
    private PersonDAO personDAO;

    @InjectMocks
    private PersonServiceImpl personService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSearchPersons_AllNullCriteria_ShouldThrowException() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            personService.searchPersons(null, null, null, null);
        });
        assertEquals("At least one search criterion must be provided.", exception.getMessage());
    }
}
    //package org.openapitools;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.openapitools.dao.PersonDAO;
//import org.openapitools.model.Anschrift;
//import org.openapitools.model.Bankverbindung;
//import org.openapitools.model.Kommunikationsadresse;
//import org.openapitools.model.Person;
//import org.openapitools.service.PersonServiceImpl;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.lenient;
//
//@ExtendWith(MockitoExtension.class)
//@ExtendWith(MockitoExtension.class)
//class PersonServiceImplTest {
//
//    @Mock
//    private PersonDAO personDAO;
//
//    @InjectMocks
//    private PersonServiceImpl personService;
//
//    private List<Person> testData;
//
//    @BeforeEach
//    void setUp() throws IOException {
//        testData = new ArrayList<>();
//        Person testPerson = new Person();
////        Person testPerson = new Person(1L, "John", "Doe", Person.GeschlechtEnum.M, List.of(new Anschrift(1L)), List.of(new Kommunikationsadresse(1L)), List.of(new Bankverbindung(1L)));
//        testData.add(testPerson);
//
////        when(personDAO.loadPersonData()).thenReturn(testData);
//        System.out.println("TESTDATA " + testData);
//        lenient().when(personDAO.searchPersons(any(), any(), any(), any()))
//                .thenAnswer(invocation -> {
//                    String vorname = invocation.getArgument(0);
//                    String nachname = invocation.getArgument(1);
//                    String iban = invocation.getArgument(2);
//                    String email = invocation.getArgument(3);
//
//                    return testData.stream()
//                            .filter(person -> (vorname == null || person.getVorname().equalsIgnoreCase(vorname)) &&
//                                    (nachname == null || person.getNachname().equalsIgnoreCase(nachname)) &&
//                                    (iban == null || person.getBankverbindungen().stream().anyMatch(bank -> bank.getIban().equalsIgnoreCase(iban))) &&
//                                    (email == null || person.getKommunikationsadressen().stream().anyMatch(comm -> comm.getEmail().equalsIgnoreCase(email))))
//                            .collect(Collectors.toList());
//                });
//
//    }
//
//    @Test
//    void searchPersons() {
//        List<Person> result = personService.searchPersons("John", null, null, null);
//        assertEquals(1, result.size());
//        assertEquals("John", result.get(0).getVorname());
//    }
//
//
//
////    @Test
////    void searchPersonsWithNullArguments() {
////        List<Person> result = personService.searchPersons(null, null, null, null);
////        assertEquals(1, result.size()); // Since we have only one test data
////    }
//
//    @Test
//    void searchPersonsWithNullArguments() {
//        assertThrows(RuntimeException.class, () -> personService.searchPersons(null, null, null, null));
//    }
//    @Test
//    void searchPersonsWithNonExistingName() {
//        List<Person> result = personService.searchPersons("NonExistent", null, null, null);
//        assertEquals(0, result.size());
//    }
//
//    // Add more test cases for different scenarios
//}
