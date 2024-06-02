package org.openapitools.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.openapitools.dto.PersonDTO;
import org.openapitools.model.Person;
import org.openapitools.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
}

