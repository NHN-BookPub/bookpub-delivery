package com.nhnacademy.bookpubdelivery.deliverystate.repository;

import com.nhnacademy.bookpubdelivery.deliverystate.entity.DeliveryState;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 배송상태 repo 입니다.
 *
 * @author : 유호철
 * @since : 1.0
 **/
public interface DeliveryStateRepository extends JpaRepository<DeliveryState, Integer> {

    Optional<DeliveryState> findByStateName(String name);
}
