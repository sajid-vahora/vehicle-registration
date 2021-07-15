package com.vehicle.regisration.io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * VehicleResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-07T10:58:46.967Z")


public class VehicleResponse   {
  @JsonProperty("vehicleId")
  private Integer vehicleId = null;

  @JsonProperty("make")
  private String make = null;

  @JsonProperty("registrationNumber")
  private String registrationNumber = null;

  public VehicleResponse vehicleId(Integer vehicleId) {
    this.vehicleId = vehicleId;
    return this;
  }

  /**
   * Get vehicleId
   * @return vehicleId
  **/
  @ApiModelProperty(value = "")


  public Integer getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(Integer vehicleId) {
    this.vehicleId = vehicleId;
  }

  public VehicleResponse make(String make) {
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

  public VehicleResponse registrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
    return this;
  }

  /**
   * Get registrationNumber
   * @return registrationNumber
  **/
  @ApiModelProperty(value = "")


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
    VehicleResponse vehicleResponse = (VehicleResponse) o;
    return Objects.equals(this.vehicleId, vehicleResponse.vehicleId) &&
        Objects.equals(this.make, vehicleResponse.make) &&
        Objects.equals(this.registrationNumber, vehicleResponse.registrationNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vehicleId, make, registrationNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VehicleResponse {\n");

    sb.append("    vehicleId: ").append(toIndentedString(vehicleId)).append("\n");
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

