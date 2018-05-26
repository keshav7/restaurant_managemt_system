package com.aether.boiler.core.domain;

import com.aether.boiler.core.enums.OrderState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Created by keshav.gupta on 16/04/18.
 */
@Data
@Entity
@Table(name = "orders")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@DynamicUpdate
public class Order extends AuditedBaseEntity {

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

    @Column(name = "state", columnDefinition = "VARCHAR(20)", nullable = false)
    @Enumerated(EnumType.STRING)
    OrderState state;

    @Column(name = "price")
    Double price;
}
