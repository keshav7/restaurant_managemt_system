package com.aether.boiler.core.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Created by keshav.gupta on 16/04/18.
 */

@Data
@Entity
@Table(name = "customer")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@DynamicUpdate
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "address")
    String address;
    @Column(name = "phone_number")
    String phoneNumber;
    @Column(name = "email")
    String email;
    @Column(name = "country")
    String country;
    @Column(name = "city")
    String city;
}
