package org.openapitools.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openapitools.model.Person;
import com.fasterxml.jackson.core.type.TypeReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-30T16:27:00.798725+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
@Controller
@RequestMapping("${openapi.aPIFuerDasLeistungssystemREO.base-path:/rest/intern}")
public class PersonenApiController implements PersonenApi {

    private final NativeWebRequest request;
    private final List<Person> personList;
    @Autowired
    public PersonenApiController(NativeWebRequest request) {
        List<Person> personList1;
        this.request = request;
        try {
            personList1 = loadPersonData();
        } catch (IOException e) {
            System.err.println("Error loading person data: " + e.getMessage());
            personList1 = new ArrayList<>();
        }
        this.personList = personList1;
    }

    private List<Person> loadPersonData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream("/beispieldaten.json"); // Ensure the JSON file is in the resources folder
        return mapper.readValue(inputStream, new TypeReference<List<Person>>() {});
    }
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

@Override
public ResponseEntity<List<Person>> readPersonenBySearchParams(String vorname, String nachname, String iban, String email) {
    if (vorname == null && nachname == null && iban == null && email == null) {
        return ResponseEntity.badRequest().body(null);
    }

    List<Person> result = personList.stream()
            .filter(person -> (vorname == null || person.getVorname().equalsIgnoreCase(vorname)) &&
                    (nachname == null || person.getNachname().equalsIgnoreCase(nachname)) &&
                    (iban == null || person.getBankverbindungen().stream().anyMatch(bank -> bank.getIban().equalsIgnoreCase(iban))) &&
                    (email == null || person.getKommunikationsadressen().stream().anyMatch(comm -> comm.getEmail().equalsIgnoreCase(email))))
            .collect(Collectors.toList());

    return ResponseEntity.ok(result);
}
}
