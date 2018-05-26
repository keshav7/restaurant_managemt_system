package com.aether.boiler.core.domain;

import com.aether.boiler.core.enums.MenuItemType;
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
@Table(name = "menu_item")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@DynamicUpdate
public class MenuItem extends AuditedBaseEntity{

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    Restaurant restaurant;
    @Column(name = "name")
    String name;
    @Column(name = "type", columnDefinition = "VARCHAR(20)", nullable = false)
    @Enumerated(EnumType.STRING)
    MenuItemType type;
    @Column(name = "description")
    String description;
    @Column(name = "price")
    Double price;
}
