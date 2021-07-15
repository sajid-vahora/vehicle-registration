package com.vehicle.regisration.io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PersonResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-07T12:54:25.965Z")


public class PersonResponse {
  @JsonProperty("personId")
  private Integer personId = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("vehicles")
  @Valid
  private List<VehicleResponse> vehicles = null;

  public PersonResponse personId(Integer personId) {
    this.personId = personId;
    return this;
  }

  /**
   * Get personId
   * @return personId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getPersonId() {
    return personId;
  }

  public void setPersonId(Integer personId) {
    this.personId = personId;
  }

  public PersonResponse firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  **/
  @ApiModelProperty(value = "")


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public PersonResponse lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  **/
  @ApiModelProperty(value = "")


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public PersonResponse vehicles(List<VehicleResponse> vehicles) {
    this.vehicles = vehicles;
    return this;
  }

  public PersonResponse addVehiclesItem(VehicleResponse vehiclesItem) {
    if (this.vehicles == null) {
      this.vehicles = new ArrayList<VehicleResponse>();
    }
    this.vehicles.add(vehiclesItem);
    return this;
  }

  /**
   * Get vehicles
   * @return vehicles
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<VehicleResponse> getVehicles() {
    return vehicles;
  }

  public void setVehicles(List<VehicleResponse> vehicles) {
    this.vehicles = vehicles;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonResponse personResponse = (PersonResponse) o;
    return Objects.equals(this.personId, personResponse.personId) &&
        Objects.equals(this.firstName, personResponse.firstName) &&
        Objects.equals(this.lastName, personResponse.lastName) &&
        Objects.equals(this.vehicles, personResponse.vehicles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(personId, firstName, lastName, vehicles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonResponse {\n");
    
    sb.append("    personId: ").append(toIndentedString(personId)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    vehicles: ").append(toIndentedString(vehicles)).append("\n");
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

