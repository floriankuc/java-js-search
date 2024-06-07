package org.openapitools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.openapitools.api.PersonenApiController;
import org.openapitools.dto.PersonDTO;
import org.openapitools.model.Person;
import org.openapitools.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PersonenApiController.class)
class PersonenApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testReadPersonenBySearchParams_AllNullParams_ShouldReturnBadRequest() throws Exception {
        mockMvc.perform(get("/rest/intern/personen"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testReadPersonenBySearchParams_ValidParams_ShouldReturnResults() throws Exception {
        List<PersonDTO> mockResults = new ArrayList<>();
        mockResults.add(new PersonDTO("Anton", "Test", Person.GeschlechtEnum.M, 1, 1, "DE123"));
        when(personService.searchPersons(any(), any(), any(), any())).thenReturn(mockResults);

        mockMvc.perform(get("/rest/intern/personen?vorname=Anton"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testReadPersonenBySearchParams_NonExistingParams_ShouldReturnNotFound() throws Exception {
        mockMvc.perform(get("/rest/intern/personen?vorname=Anton"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testReadPersonenBySearchParams_IllegalArgumentException_ShouldReturnBadRequest() throws Exception {
        mockMvc.perform(get("/rest/intern/personen?test=Invalid"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testReadPersonenBySearchParams_InvalidVorname_ShouldReturnValidationError() throws Exception {
        mockMvc.perform(get("/rest/intern/personen?vorname=123"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testReadPersonenBySearchParams_InvalidNachname_ShouldReturnValidationError() throws Exception {
        mockMvc.perform(get("/rest/intern/personen?nachname=123"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testReadPersonenBySearchParams_InvalidEmail_ShouldReturnValidationError() throws Exception {
        mockMvc.perform(get("/rest/intern/personen?email=invalid_email"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testReadPersonenBySearchParams_InvalidIban_ShouldReturnValidationError() throws Exception {
        mockMvc.perform(get("/rest/intern/personen?iban=invalid_iban"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
