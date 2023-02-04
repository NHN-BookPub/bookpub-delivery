package com.nhnacademy.bookpubdelivery.delivery.service;

import com.nhnacademy.bookpubdelivery.delivery.dto.request.CreateDeliveryRequestDto;
import com.nhnacademy.bookpubdelivery.delivery.dto.response.CreateDeliveryResponseDto;

/**
 * 배송 서비스 인터페이스 입니다.
 *
 * @author : 유호철
 * @since : 1.0
 **/
public interface DeliveryService {
    /**
     * 배송정보를 생성하는 메서드입니다.
     *
     * @param dto 배송생성정보가 기입
     * @return 배송될Dto 로 반환해줍니다.
     */
    CreateDeliveryResponseDto createDelivery(CreateDeliveryRequestDto dto);
}
