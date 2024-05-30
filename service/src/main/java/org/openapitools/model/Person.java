package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.Anschrift;
import org.openapitools.model.Bankverbindung;
import org.openapitools.model.Kommunikationsadresse;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Person
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-30T16:27:00.798725+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class Person {

  private Long id;

  private String vorname;

  private String nachname;

  /**
   * Gets or Sets geschlecht
   */
  public enum GeschlechtEnum {
    U("u"),
    
    M("m"),
    
    W("w"),
    
    X("x"),
    
    D("d");

    private String value;

    GeschlechtEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static GeschlechtEnum fromValue(String value) {
      for (GeschlechtEnum b : GeschlechtEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private GeschlechtEnum geschlecht;

  @Valid
  private List<@Valid Anschrift> anschriften = new ArrayList<>();

  @Valid
  private List<@Valid Kommunikationsadresse> kommunikationsadressen = new ArrayList<>();

  @Valid
  private List<@Valid Bankverbindung> bankverbindungen = new ArrayList<>();

  public Person() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Person(Long id) {
    this.id = id;
  }

  public Person id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Person vorname(String vorname) {
    this.vorname = vorname;
    return this;
  }

  /**
   * Get vorname
   * @return vorname
  */
  
  @Schema(name = "vorname", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("vorname")
  public String getVorname() {
    return vorname;
  }

  public void setVorname(String vorname) {
    this.vorname = vorname;
  }

  public Person nachname(String nachname) {
    this.nachname = nachname;
    return this;
  }

  /**
   * Get nachname
   * @return nachname
  */
  
  @Schema(name = "nachname", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nachname")
  public String getNachname() {
    return nachname;
  }

  public void setNachname(String nachname) {
    this.nachname = nachname;
  }

  public Person geschlecht(GeschlechtEnum geschlecht) {
    this.geschlecht = geschlecht;
    return this;
  }

  /**
   * Get geschlecht
   * @return geschlecht
  */
  
  @Schema(name = "geschlecht", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("geschlecht")
  public GeschlechtEnum getGeschlecht() {
    return geschlecht;
  }

  public void setGeschlecht(GeschlechtEnum geschlecht) {
    this.geschlecht = geschlecht;
  }

  public Person anschriften(List<@Valid Anschrift> anschriften) {
    this.anschriften = anschriften;
    return this;
  }

  public Person addAnschriftenItem(Anschrift anschriftenItem) {
    if (this.anschriften == null) {
      this.anschriften = new ArrayList<>();
    }
    this.anschriften.add(anschriftenItem);
    return this;
  }

  /**
   * Get anschriften
   * @return anschriften
  */
  @Valid 
  @Schema(name = "anschriften", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("anschriften")
  public List<@Valid Anschrift> getAnschriften() {
    return anschriften;
  }

  public void setAnschriften(List<@Valid Anschrift> anschriften) {
    this.anschriften = anschriften;
  }

  public Person kommunikationsadressen(List<@Valid Kommunikationsadresse> kommunikationsadressen) {
    this.kommunikationsadressen = kommunikationsadressen;
    return this;
  }

  public Person addKommunikationsadressenItem(Kommunikationsadresse kommunikationsadressenItem) {
    if (this.kommunikationsadressen == null) {
      this.kommunikationsadressen = new ArrayList<>();
    }
    this.kommunikationsadressen.add(kommunikationsadressenItem);
    return this;
  }

  /**
   * Get kommunikationsadressen
   * @return kommunikationsadressen
  */
  @Valid 
  @Schema(name = "kommunikationsadressen", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("kommunikationsadressen")
  public List<@Valid Kommunikationsadresse> getKommunikationsadressen() {
    return kommunikationsadressen;
  }

  public void setKommunikationsadressen(List<@Valid Kommunikationsadresse> kommunikationsadressen) {
    this.kommunikationsadressen = kommunikationsadressen;
  }

  public Person bankverbindungen(List<@Valid Bankverbindung> bankverbindungen) {
    this.bankverbindungen = bankverbindungen;
    return this;
  }

  public Person addBankverbindungenItem(Bankverbindung bankverbindungenItem) {
    if (this.bankverbindungen == null) {
      this.bankverbindungen = new ArrayList<>();
    }
    this.bankverbindungen.add(bankverbindungenItem);
    return this;
  }

  /**
   * Get bankverbindungen
   * @return bankverbindungen
  */
  @Valid 
  @Schema(name = "bankverbindungen", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bankverbindungen")
  public List<@Valid Bankverbindung> getBankverbindungen() {
    return bankverbindungen;
  }

  public void setBankverbindungen(List<@Valid Bankverbindung> bankverbindungen) {
    this.bankverbindungen = bankverbindungen;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return Objects.equals(this.id, person.id) &&
        Objects.equals(this.vorname, person.vorname) &&
        Objects.equals(this.nachname, person.nachname) &&
        Objects.equals(this.geschlecht, person.geschlecht) &&
        Objects.equals(this.anschriften, person.anschriften) &&
        Objects.equals(this.kommunikationsadressen, person.kommunikationsadressen) &&
        Objects.equals(this.bankverbindungen, person.bankverbindungen);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, vorname, nachname, geschlecht, anschriften, kommunikationsadressen, bankverbindungen);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Person {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    vorname: ").append(toIndentedString(vorname)).append("\n");
    sb.append("    nachname: ").append(toIndentedString(nachname)).append("\n");
    sb.append("    geschlecht: ").append(toIndentedString(geschlecht)).append("\n");
    sb.append("    anschriften: ").append(toIndentedString(anschriften)).append("\n");
    sb.append("    kommunikationsadressen: ").append(toIndentedString(kommunikationsadressen)).append("\n");
    sb.append("    bankverbindungen: ").append(toIndentedString(bankverbindungen)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

