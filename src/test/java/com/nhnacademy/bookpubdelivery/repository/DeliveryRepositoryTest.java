package com.nhnacademy.bookpubdelivery.repository;

import static com.nhnacademy.bookpubdelivery.dummy.Dummy.deliveryDummy;
import static org.assertj.core.api.Assertions.assertThat;
import com.nhnacademy.bookpubdelivery.delivery.entity.Delivery;
import com.nhnacademy.bookpubdelivery.delivery.repository.DeliveryRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

/**
 * 배송 test
 *
 * @author : 유호철
 * @since : 1.0
 **/
@DataJpaTest
class DeliveryRepositoryTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    DeliveryRepository deliveryRepository;

    Delivery delivery;
    @BeforeEach
    void setUp() {
        delivery = deliveryDummy();
        entityManager.persist(delivery.getState());
        entityManager.persist(delivery);
    }

    @Test
    void deliverySaveTest() {
        Optional<Delivery> result = deliveryRepository.findById(delivery.getDeliveryNo());

        assertThat(result).isPresent();
        assertThat(result.get().getOrderNo()).isEqualTo(delivery.getOrderNo());
        assertThat(result.get().getDeliveryNo()).isEqualTo(delivery.getDeliveryNo());
        assertThat(result.get().getPhone()).isEqualTo(delivery.getPhone());
        assertThat(result.get().getCompany()).isEqualTo(delivery.getCompany());
        assertThat(result.get().getRecipient()).isEqualTo(delivery.getRecipient());
        assertThat(result.get().getRequest()).isEqualTo(delivery.getRequest());
        assertThat(result.get().getInvoiceNo()).isEqualTo(delivery.getInvoiceNo());
    }

    @Test
    void findDeliveryInvoice(){
        Optional<Delivery> result = deliveryRepository.findByInvoiceNo(delivery.getInvoiceNo());

        assertThat(result).isPresent();
        assertThat(result.get().getOrderNo()).isEqualTo(delivery.getOrderNo());
        assertThat(result.get().getDeliveryNo()).isEqualTo(delivery.getDeliveryNo());
        assertThat(result.get().getPhone()).isEqualTo(delivery.getPhone());
        assertThat(result.get().getCompany()).isEqualTo(delivery.getCompany());
        assertThat(result.get().getRecipient()).isEqualTo(delivery.getRecipient());
        assertThat(result.get().getRequest()).isEqualTo(delivery.getRequest());
        assertThat(result.get().getInvoiceNo()).isEqualTo(delivery.getInvoiceNo());
    }
}