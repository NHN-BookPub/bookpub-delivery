package com.nhnacademy.bookpubdelivery.dummy;

import com.nhnacademy.bookpubdelivery.delivery.entity.Delivery;
import com.nhnacademy.bookpubdelivery.deliverystate.entity.DeliveryState;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 배송 더미
 * 
 * @author : 유호철
 * @since : 1.0
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Dummy {
    public static Delivery deliveryDummy(){
        return Delivery.builder()
                .state(new DeliveryState(null,"state"))
                .orderNo(1L)
                .recipient("수령인")
                .requestDate(LocalDateTime.now())
                .company("회사")
                .finishedAt(LocalDateTime.now())
                .invoiceNo("uuid")
                .phone("phone")
                .addressDetail("detail")
                .build();
    }
}
