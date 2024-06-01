package org.openapitools.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openapitools.model.Person;
import com.fasterxml.jackson.core.type.TypeReference;

import org.openapitools.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-30T16:27:00.798725+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
@Controller
@RequestMapping("${openapi.aPIFuerDasLeistungssystemREO.base-path:/rest/intern}")
public class PersonenApiController implements PersonenApi {

    private final NativeWebRequest request;
    private final PersonService personService;


    @Autowired
    public PersonenApiController(NativeWebRequest request, PersonService personService) {
        this.request = request;
        this.personService = personService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<Person>> readPersonenBySearchParams(String vorname, String nachname, String iban, String email) {
        if (!validateSearchParams(vorname, nachname, iban, email)) {
            throw new IllegalArgumentException("Mindestens ein Parameter darf nicht null sein");

        }

        List<Person> result = personService.searchPersons(vorname, nachname, iban, email);
        return ResponseEntity.ok(result);
    }

    private boolean validateSearchParams(String vorname, String nachname, String iban, String email) {
        return vorname != null || nachname != null || iban != null || email != null;
    }
}
