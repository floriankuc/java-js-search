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
 * Anschrift
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-30T16:27:00.798725+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class Anschrift {

  private Long id;

  private String strasse;

  private String hausnummer;

  private String plz;

  private String ort;

  private String land;

  public Anschrift() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Anschrift(Long id) {
    this.id = id;
  }

  public Anschrift id(Long id) {
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

  public Anschrift strasse(String strasse) {
    this.strasse = strasse;
    return this;
  }

  /**
   * Get strasse
   * @return strasse
  */
  
  @Schema(name = "strasse", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("strasse")
  public String getStrasse() {
    return strasse;
  }

  public void setStrasse(String strasse) {
    this.strasse = strasse;
  }

  public Anschrift hausnummer(String hausnummer) {
    this.hausnummer = hausnummer;
    return this;
  }

  /**
   * Get hausnummer
   * @return hausnummer
  */
  
  @Schema(name = "hausnummer", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("hausnummer")
  public String getHausnummer() {
    return hausnummer;
  }

  public void setHausnummer(String hausnummer) {
    this.hausnummer = hausnummer;
  }

  public Anschrift plz(String plz) {
    this.plz = plz;
    return this;
  }

  /**
   * Get plz
   * @return plz
  */
  
  @Schema(name = "plz", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("plz")
  public String getPlz() {
    return plz;
  }

  public void setPlz(String plz) {
    this.plz = plz;
  }

  public Anschrift ort(String ort) {
    this.ort = ort;
    return this;
  }

  /**
   * Get ort
   * @return ort
  */
  
  @Schema(name = "ort", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ort")
  public String getOrt() {
    return ort;
  }

  public void setOrt(String ort) {
    this.ort = ort;
  }

  public Anschrift land(String land) {
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
    Anschrift anschrift = (Anschrift) o;
    return Objects.equals(this.id, anschrift.id) &&
        Objects.equals(this.strasse, anschrift.strasse) &&
        Objects.equals(this.hausnummer, anschrift.hausnummer) &&
        Objects.equals(this.plz, anschrift.plz) &&
        Objects.equals(this.ort, anschrift.ort) &&
        Objects.equals(this.land, anschrift.land);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, strasse, hausnummer, plz, ort, land);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Anschrift {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    strasse: ").append(toIndentedString(strasse)).append("\n");
    sb.append("    hausnummer: ").append(toIndentedString(hausnummer)).append("\n");
    sb.append("    plz: ").append(toIndentedString(plz)).append("\n");
    sb.append("    ort: ").append(toIndentedString(ort)).append("\n");
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

