package com.nhnacademy.bookpubdelivery.delivery.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 운송장번호를 반환
 *
 * @author : 유호철
 * @since : 1.0
 **/
@Getter
@AllArgsConstructor
public class CreateDeliveryResponseDto {
    private String invoiceNo;
}
