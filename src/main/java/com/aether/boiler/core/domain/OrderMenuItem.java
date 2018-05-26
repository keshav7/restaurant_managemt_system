package com.aether.boiler.core.domain;

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
@Table(name = "order_menu_item")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@DynamicUpdate
public class OrderMenuItem {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @OneToOne
    @JoinColumn(name = "order_id")
    Order order;
    @OneToOne
    @JoinColumn(name = "menu_item_id")
    MenuItem menuItem;
    @Column
    Integer quantity;
}
