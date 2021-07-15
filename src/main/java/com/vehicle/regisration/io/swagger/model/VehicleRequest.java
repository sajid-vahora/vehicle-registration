package com.vehicle.regisration.io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * VehicleRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-07T10:58:46.967Z")


public class VehicleRequest   {
  @JsonProperty("make")
  private String make = null;

  @JsonProperty("registrationNumber")
  private String registrationNumber = null;

  public VehicleRequest make(String make) {
    this.make = make;
    return this;
  }

  /**
   * Get make
   * @return make
  **/
  @ApiModelProperty(value = "")


  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public VehicleRequest registrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
    return this;
  }

  /**
   * Get registrationNumber
   * @return registrationNumber
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VehicleRequest vehicleRequest = (VehicleRequest) o;
    return Objects.equals(this.make, vehicleRequest.make) &&
        Objects.equals(this.registrationNumber, vehicleRequest.registrationNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(make, registrationNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VehicleRequest {\n");

    sb.append("    make: ").append(toIndentedString(make)).append("\n");
    sb.append("    registrationNumber: ").append(toIndentedString(registrationNumber)).append("\n");
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

