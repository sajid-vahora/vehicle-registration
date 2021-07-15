package com.coding.task.rego.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "persons")
@Getter
@Setter
@NoArgsConstructor
public class Person extends BaseEntity implements Serializable {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotBlank
    private String lastName;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    @Singular (ignoreNullCollections = true)
    private Set<Vehicle> vehicles = new HashSet<>();

    @Builder
    public Person(Integer id, String firstName, String lastName, Set<Vehicle> vehicles) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.vehicles = vehicles;
    }

    public Person addVehicle(Vehicle vehicle) {
        vehicle.setPerson(this);
        this.vehicles.add(vehicle);
        return this;
    }

    public Person removeVehicle(Vehicle vehicle) {
        vehicle.setPerson(null);
        this.vehicles.remove(vehicle);
        return this;
    }
}
