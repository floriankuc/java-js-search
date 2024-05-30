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
 * Kommunikationsadresse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-30T16:27:00.798725+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class Kommunikationsadresse {

  private Long id;

  private String email;

  private String telefon;

  public Kommunikationsadresse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Kommunikationsadresse(Long id) {
    this.id = id;
  }

  public Kommunikationsadresse id(Long id) {
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

  public Kommunikationsadresse email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  
  @Schema(name = "email", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Kommunikationsadresse telefon(String telefon) {
    this.telefon = telefon;
    return this;
  }

  /**
   * Get telefon
   * @return telefon
  */
  
  @Schema(name = "telefon", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("telefon")
  public String getTelefon() {
    return telefon;
  }

  public void setTelefon(String telefon) {
    this.telefon = telefon;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Kommunikationsadresse kommunikationsadresse = (Kommunikationsadresse) o;
    return Objects.equals(this.id, kommunikationsadresse.id) &&
        Objects.equals(this.email, kommunikationsadresse.email) &&
        Objects.equals(this.telefon, kommunikationsadresse.telefon);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, email, telefon);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Kommunikationsadresse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    telefon: ").append(toIndentedString(telefon)).append("\n");
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

