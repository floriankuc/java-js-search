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
