package com.aether.boiler.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by keshav.gupta on 16/04/18.
 */

@Data
@Entity
@Table(name = "restaurant")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@DynamicUpdate
public class Restaurant extends AuditedBaseEntity{

    @Column(name = "name")
    String name;
    @Column(name = "description")
    String description;
    @Column(name = "address")
    String address;
}
