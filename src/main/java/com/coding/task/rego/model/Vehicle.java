package com.coding.task.rego.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
public class Vehicle extends BaseEntity implements Serializable {

    @Column(name = "registration_number", nullable = false, unique = true)
    private String registrationNumber;

    @Column(name = "make", nullable = false)
    @EqualsAndHashCode.Exclude
    private String make;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @EqualsAndHashCode.Exclude
    private Person person;

    @Builder
    public Vehicle(Integer id, String registrationNumber, String make, Person person) {
        super(id);
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.person = person;
    }
}
