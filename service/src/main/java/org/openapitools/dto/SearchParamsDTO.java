package org.openapitools.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class SearchParamsDTO {

    @Pattern(regexp = "^[a-zA-ZäöüÄÖÜß]*$", message = "Vorname may not contain numbers")
    private String vorname;

    @Pattern(regexp = "^[a-zA-ZäöüÄÖÜß]*$", message = "Nachname may not contain numbers")
    private String nachname;

    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = "^[A-Z]{2}[0-9]{2}[A-Z0-9]{4}[0-9]{7}([A-Z0-9]?){0,16}$", message = "IBAN should be valid")
    private String iban;

    // Getters and Setters

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
