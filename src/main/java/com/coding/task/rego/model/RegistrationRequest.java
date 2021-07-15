package com.coding.task.rego.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

/**
 * RegistrationRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-07T12:54:25.965Z")


public class RegistrationRequest {
  @JsonProperty("vehicleId")
  private Integer vehicleId = null;

  public RegistrationRequest registrationNumber(Integer vehicleId) {
    this.vehicleId = vehicleId;
    return this;
  }

  public Integer getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(Integer vehicleId) {
    this.vehicleId = vehicleId;
  }

  /**
   * Get registrationNumber
   * @return registrationNumber
  **/
  @ApiModelProperty(value = "")




  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistrationRequest registrationRequest = (RegistrationRequest) o;
    return Objects.equals(this.vehicleId, registrationRequest.vehicleId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vehicleId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegistrationRequest {\n");
    
    sb.append("    registrationNumber: ").append(toIndentedString(vehicleId)).append("\n");
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

