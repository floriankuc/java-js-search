package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Bankverbindung
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-30T16:27:00.798725+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class Bankverbindung {

  private Long id;

  private String iban;

  private String bankname;

  private String bankleitzahl;

  private String bic;

  private String kontonummer;

  private String land;

  public Bankverbindung() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Bankverbindung(Long id) {
    this.id = id;
  }

  public Bankverbindung id(Long id) {
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

  public Bankverbindung iban(String iban) {
    this.iban = iban;
    return this;
  }

  /**
   * Get iban
   * @return iban
  */
  
  @Schema(name = "iban", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("iban")
  public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }

  public Bankverbindung bankname(String bankname) {
    this.bankname = bankname;
    return this;
  }

  /**
   * Get bankname
   * @return bankname
  */
  
  @Schema(name = "bankname", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bankname")
  public String getBankname() {
    return bankname;
  }

  public void setBankname(String bankname) {
    this.bankname = bankname;
  }

  public Bankverbindung bankleitzahl(String bankleitzahl) {
    this.bankleitzahl = bankleitzahl;
    return this;
  }

  /**
   * Get bankleitzahl
   * @return bankleitzahl
  */
  
  @Schema(name = "bankleitzahl", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bankleitzahl")
  public String getBankleitzahl() {
    return bankleitzahl;
  }

  public void setBankleitzahl(String bankleitzahl) {
    this.bankleitzahl = bankleitzahl;
  }

  public Bankverbindung bic(String bic) {
    this.bic = bic;
    return this;
  }

  /**
   * Get bic
   * @return bic
  */
  
  @Schema(name = "bic", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bic")
  public String getBic() {
    return bic;
  }

  public void setBic(String bic) {
    this.bic = bic;
  }

  public Bankverbindung kontonummer(String kontonummer) {
    this.kontonummer = kontonummer;
    return this;
  }

  /**
   * Get kontonummer
   * @return kontonummer
  */
  
  @Schema(name = "kontonummer", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("kontonummer")
  public String getKontonummer() {
    return kontonummer;
  }

  public void setKontonummer(String kontonummer) {
    this.kontonummer = kontonummer;
  }

  public Bankverbindung land(String land) {
    this.land = land;
    return this;
  }

  /**
   * Get land
   * @return land
  */
  
  @Schema(name = "land", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("land")
  public String getLand() {
    return land;
  }

  public void setLand(String land) {
    this.land = land;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Bankverbindung bankverbindung = (Bankverbindung) o;
    return Objects.equals(this.id, bankverbindung.id) &&
        Objects.equals(this.iban, bankverbindung.iban) &&
        Objects.equals(this.bankname, bankverbindung.bankname) &&
        Objects.equals(this.bankleitzahl, bankverbindung.bankleitzahl) &&
        Objects.equals(this.bic, bankverbindung.bic) &&
        Objects.equals(this.kontonummer, bankverbindung.kontonummer) &&
        Objects.equals(this.land, bankverbindung.land);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, iban, bankname, bankleitzahl, bic, kontonummer, land);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Bankverbindung {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    iban: ").append(toIndentedString(iban)).append("\n");
    sb.append("    bankname: ").append(toIndentedString(bankname)).append("\n");
    sb.append("    bankleitzahl: ").append(toIndentedString(bankleitzahl)).append("\n");
    sb.append("    bic: ").append(toIndentedString(bic)).append("\n");
    sb.append("    kontonummer: ").append(toIndentedString(kontonummer)).append("\n");
    sb.append("    land: ").append(toIndentedString(land)).append("\n");
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

