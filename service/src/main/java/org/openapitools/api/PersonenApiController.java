package org.openapitools.api;

import org.openapitools.dto.PersonDTO;
import org.openapitools.dto.SearchParamsDTO;
import org.openapitools.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.Generated;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.*;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-30T16:27:00.798725+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
@Controller
@RequestMapping("${openapi.aPIFuerDasLeistungssystemREO.base-path:/rest/intern}")
public class PersonenApiController implements PersonenApi {

    private final NativeWebRequest request;
    private final PersonService personService;
    private final Validator validator;

    private static final Set<String> VALID_PARAMS = Set.of("vorname", "nachname", "iban", "email");

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
    public ResponseEntity<List<PersonDTO>> readPersonenBySearchParams(
            @Valid @RequestParam(value = "vorname", required = false) String vorname,
            @Valid @RequestParam(value = "nachname", required = false) String nachname,
            @Valid @RequestParam(value = "iban", required = false) String iban,
            @Valid @RequestParam(value = "email", required = false) String email,
            HttpServletRequest httpServletRequest) {

        validateAdditionalParameters(httpServletRequest);
        validateAtLeastOneParameter(vorname, nachname, iban, email);
        validateSearchParams(vorname, nachname, iban, email);

        // Simulate async behavior for demo purposes
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        List<PersonDTO> result = personService.searchPersons(vorname, nachname, iban, email);

        if (result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person nicht gefunden");
        } else {
            return ResponseEntity.ok(result);
        }
    }

    private void validateAdditionalParameters(HttpServletRequest httpServletRequest) {
        for (String paramName : httpServletRequest.getParameterMap().keySet()) {
            if (!VALID_PARAMS.contains(paramName)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid search parameter: " + paramName);
            }
        }
    }

    private void validateAtLeastOneParameter(String vorname, String nachname, String iban, String email) {
        if (vorname == null && nachname == null && iban == null && email == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "At least one search parameter must be set");
        }
    }

    private void validateSearchParams(String vorname, String nachname, String iban, String email) {
        SearchParamsDTO searchParams = new SearchParamsDTO(vorname, nachname, iban, email);
        Set<ConstraintViolation<SearchParamsDTO>> violations = validator.validate(searchParams);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
