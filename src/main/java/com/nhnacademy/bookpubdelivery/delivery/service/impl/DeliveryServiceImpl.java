package com.nhnacademy.bookpubdelivery.delivery.service.impl;

import com.nhnacademy.bookpubdelivery.delivery.entity.Delivery;
import com.nhnacademy.bookpubdelivery.delivery.repository.DeliveryRepository;
import com.nhnacademy.bookpubdelivery.deliverystate.repository.DeliveryStateRepository;
import com.nhnacademy.bookpubdelivery.delivery.dto.request.CreateDeliveryRequestDto;
import com.nhnacademy.bookpubdelivery.delivery.dto.response.CreateDeliveryResponseDto;
import com.nhnacademy.bookpubdelivery.deliverystate.entity.DeliveryState;
import com.nhnacademy.bookpubdelivery.exception.DeliveryStateNotFoundException;
import com.nhnacademy.bookpubdelivery.delivery.service.DeliveryService;
import java.math.BigInteger;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 배송 서비스입니다.
 *
 * @author : 유호철
 * @since : 1.0
 **/
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final DeliveryStateRepository stateRepository;
    private static final String DELIVERY_READY = "배송준비";

    @Transactional
    @Override
    public CreateDeliveryResponseDto createDelivery(CreateDeliveryRequestDto dto) {

        DeliveryState deliveryState = stateRepository.findByStateName(DELIVERY_READY)
                .orElseThrow(DeliveryStateNotFoundException::new);

        String uuid = makeInvoiceNo();
        Delivery delivery = Delivery.builder()
                .state(deliveryState)
                .company("NHN 택배")
                .invoiceNo(uuid)
                .request(dto.getDeliveryRequest())
                .requestDate(dto.getRequestDate())
                .orderNo(dto.getOrderNo())
                .recipient(dto.getRecipient())
                .addressDetail(dto.getAddressDetail())
                .phone(dto.getPhone())
                .build();

        deliveryRepository.save(delivery);

        return new CreateDeliveryResponseDto(uuid);
    }

    private String makeInvoiceNo() {
        String uuid = String.format("%040d",
                        new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16))
                .substring(0, 13);
        if (deliveryRepository.findByInvoiceNo(uuid).isEmpty()) {
            return uuid.subSequence(0, 13).toString();

        }
        return makeInvoiceNo();
    }
}
