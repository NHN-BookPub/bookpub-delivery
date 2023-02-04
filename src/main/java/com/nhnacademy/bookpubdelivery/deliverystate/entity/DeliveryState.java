package com.nhnacademy.bookpubdelivery.deliverystate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 배송 상태에대한 entity
 *
 * @author : 유호철
 * @since : 1.0
 **/
@Entity
@Table(name = "delivery_state")
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_state_number")
    private Integer stateNo;

    @Column(name = "delivery_state_name", unique = true)
    private String stateName;
}
