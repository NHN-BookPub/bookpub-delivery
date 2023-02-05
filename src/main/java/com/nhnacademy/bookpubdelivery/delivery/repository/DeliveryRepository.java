package com.nhnacademy.bookpubdelivery.delivery.repository;

import com.nhnacademy.bookpubdelivery.delivery.entity.Delivery;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 배송 entity 에 db 와 연동하기위한 repo 입니다.
 *
 * @author : 유호철
 * @since : 1.0
 **/
public interface DeliveryRepository extends JpaRepository<Delivery,Long>, DeliveryRepositoryCustom {
    /**
     * 운송장번호를 통해 delivery 값을 확인합니다.
     *
     * @param invoiceNo the invoice no
     * @return the optional
     */
    Optional<Delivery> findByInvoiceNo(String invoiceNo);
}