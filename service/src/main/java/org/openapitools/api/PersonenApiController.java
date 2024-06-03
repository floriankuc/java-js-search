package org.openapitools.api;

import org.openapitools.dto.PersonDTO;
import org.openapitools.dto.SearchParamsDTO;
import org.openapitools.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.annotation.Generated;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-30T16:27:00.798725+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
@Controller
@RequestMapping("${openapi.aPIFuerDasLeistungssystemREO.base-path:/rest/intern}")
public class PersonenApiController implements PersonenApi {

    private final NativeWebRequest request;
    private final PersonService personService;
    private final Validator validator;

    @Autowired
    public PersonenApiController(NativeWebRequest request, PersonService personService, Validator validator) {
        this.request = request;
        this.personService = personService;
        this.validator = validator;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<PersonDTO>> readPersonenBySearchParams(String vorname, String nachname, String iban, String email) {
        if (!validateSearchParams(vorname, nachname, iban, email)) {
            throw new IllegalArgumentException("Mindestens ein Parameter darf nicht null sein");
        }

        SearchParamsDTO searchParams = new SearchParamsDTO();
        searchParams.setVorname(vorname);
        searchParams.setNachname(nachname);
        searchParams.setIban(iban);
        searchParams.setEmail(email);

        validateSearchParamsDTO(searchParams);

        // demo application will be run locally
        // therefore imitating async behaviour
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        List<PersonDTO> result = personService.searchPersons(
                searchParams.getVorname(),
                searchParams.getNachname(),
                searchParams.getIban(),
                searchParams.getEmail()
        );

        if (result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person nicht gefunden");
        } else {
            return ResponseEntity.ok(result);
        }
    }

    private boolean validateSearchParams(String vorname, String nachname, String iban, String email) {
        return vorname != null || nachname != null || iban != null || email != null;
    }

    private void validateSearchParamsDTO(SearchParamsDTO searchParamsDTO) {
        Set<ConstraintViolation<SearchParamsDTO>> violations = validator.validate(searchParamsDTO);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
