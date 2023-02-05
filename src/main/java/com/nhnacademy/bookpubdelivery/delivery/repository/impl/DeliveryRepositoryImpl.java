package com.nhnacademy.bookpubdelivery.delivery.repository.impl;

import com.nhnacademy.bookpubdelivery.delivery.entity.Delivery;
import com.nhnacademy.bookpubdelivery.delivery.repository.DeliveryRepositoryCustom;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

/**
 * queryDsl 실구현체
 *
 * @author : 유호철
 * @since : 1.0
 **/
public class DeliveryRepositoryImpl extends QuerydslRepositorySupport implements DeliveryRepositoryCustom {
    public DeliveryRepositoryImpl() {
        super(Delivery.class);
    }
}
