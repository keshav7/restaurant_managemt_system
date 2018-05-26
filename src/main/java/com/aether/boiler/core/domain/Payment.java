package com.aether.boiler.core.domain;

import com.aether.boiler.core.enums.PaymentType;
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
@Table(name = "payment")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@DynamicUpdate
public class Payment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @OneToOne
    @JoinColumn(name = "order_id")
    Order orderId;
    @Column(name = "price")
    Double price;
    @Column(name = "payment_type", columnDefinition = "VARCHAR(20)", nullable = false)
    @Enumerated(EnumType.STRING)
    PaymentType paymentType;

}
