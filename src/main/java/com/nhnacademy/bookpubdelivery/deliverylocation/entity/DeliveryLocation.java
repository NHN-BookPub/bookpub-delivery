package com.nhnacademy.bookpubdelivery.deliverylocation.entity;

import com.nhnacademy.bookpubdelivery.delivery.entity.Delivery;
import com.sun.istack.NotNull;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 배송위치에 대한 엔티티입니다.
 *
 * @author : 유호철
 * @since : 1.0
 **/
@Entity
@Table(name = "delivery_location")
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_location_number")
    private Long locationNo;

    @ManyToOne
    @JoinColumn(name = "delivery_number")
    private Delivery delivery;
    @NotNull
    @Column(name = "delivery_location_name")
    private String locationName;

    @NotNull
    @Column(name = "delivery_location_date")
    private LocalDateTime locationDate;
}
