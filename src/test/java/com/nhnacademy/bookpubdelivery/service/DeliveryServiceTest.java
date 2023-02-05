package com.nhnacademy.bookpubdelivery.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.nhnacademy.bookpubdelivery.delivery.entity.Delivery;
import com.nhnacademy.bookpubdelivery.delivery.repository.DeliveryRepository;
import com.nhnacademy.bookpubdelivery.delivery.service.DeliveryService;
import com.nhnacademy.bookpubdelivery.deliverystate.repository.DeliveryStateRepository;
import com.nhnacademy.bookpubdelivery.delivery.dto.request.CreateDeliveryRequestDto;
import com.nhnacademy.bookpubdelivery.dummy.Dummy;
import com.nhnacademy.bookpubdelivery.exception.DeliveryStateNotFoundException;
import com.nhnacademy.bookpubdelivery.delivery.service.impl.DeliveryServiceImpl;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * 배송관련 ServiceTest
 *
 * @author : 유호철
 * @since : 1.0
 **/
@ExtendWith(SpringExtension.class)
@Import(DeliveryServiceImpl.class)
class DeliveryServiceTest {

    @Autowired
    DeliveryService deliveryService;
    @MockBean
    DeliveryRepository deliveryRepository;

    @MockBean
    DeliveryStateRepository deliveryStateRepository;

    ArgumentCaptor<Delivery> captor;

    CreateDeliveryRequestDto dto = new CreateDeliveryRequestDto();

    Delivery delivery;

    @BeforeEach
    void setUp() {
        delivery = Dummy.deliveryDummy();
        captor = ArgumentCaptor.forClass(Delivery.class);
        ReflectionTestUtils.setField(dto, "orderNo", 1L);
        ReflectionTestUtils.setField(dto, "deliveryRequest", "request");
        ReflectionTestUtils.setField(dto, "recipient", "re");
        ReflectionTestUtils.setField(dto, "phone", "010");
        ReflectionTestUtils.setField(dto, "requestDate", LocalDateTime.now());
    }

    @Test
    @DisplayName("배송을 생성 테스트 state 값없어서 실패")
    void createDelivery() {
        when(deliveryStateRepository.findByStateName(anyString()))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> deliveryService.createDelivery(dto))
                .isInstanceOf(DeliveryStateNotFoundException.class)
                .hasMessageContaining(DeliveryStateNotFoundException.MESSAGE);
    }

    @Test
    @DisplayName("배송 생성 테스트 성공")
    void createDeliverySuccess(){
        when(deliveryStateRepository.findByStateName(anyString()))
                .thenReturn(Optional.of(delivery.getState()));

        deliveryService.createDelivery(dto);

        verify(deliveryRepository).save(captor.capture());

        Delivery result = captor.getValue();

        assertThat(result.getRequest()).isEqualTo(dto.getDeliveryRequest());
        assertThat(result.getPhone()).isEqualTo(dto.getPhone());
        assertThat(result.getRecipient()).isEqualTo(dto.getRecipient());
        assertThat(result.getRequestDate()).isBefore(LocalDateTime.now());
    }
}