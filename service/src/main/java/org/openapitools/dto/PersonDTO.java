package org.openapitools.dto;

import org.openapitools.model.Person;

public class PersonDTO {
    private String nachname;
    private String vorname;
    private Person.GeschlechtEnum geschlecht;
    private int numberOfAnschriften;
    private int numberOfKommunikationsadressen;
    private String ibans;

    public PersonDTO(String name, String vorname, Person.GeschlechtEnum geschlecht, int numberOfAnschriften, int numberOfKommunikationsadressen, String ibans) {
        this.nachname = name;
        this.vorname = vorname;
        this.geschlecht = geschlecht;
        this.numberOfAnschriften = numberOfAnschriften;
        this.numberOfKommunikationsadressen = numberOfKommunikationsadressen;
        this.ibans = ibans;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public Person.GeschlechtEnum getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(Person.GeschlechtEnum geschlecht) {
        this.geschlecht = geschlecht;
    }

    public int getNumberOfAnschriften() {
        return numberOfAnschriften;
    }

    public void setNumberOfAnschriften(int numberOfAnschriften) {
        this.numberOfAnschriften = numberOfAnschriften;
    }

    public int getNumberOfKommunikationsadressen() {
        return numberOfKommunikationsadressen;
    }

    public void setNumberOfKommunikationsadressen(int numberOfKommunikationsadressen) {
        this.numberOfKommunikationsadressen = numberOfKommunikationsadressen;
    }

    public String getIbans() {
        return ibans;
    }

    public void setIbans(String ibans) {
        this.ibans = ibans;
    }
}
