package com.nhnacademy.bookpubdelivery.delivery.controller;

import com.nhnacademy.bookpubdelivery.delivery.dto.request.CreateDeliveryRequestDto;
import com.nhnacademy.bookpubdelivery.delivery.dto.response.CreateDeliveryResponseDto;
import com.nhnacademy.bookpubdelivery.delivery.service.DeliveryService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 배송 관련 controller 입니다.
 *
 * @author : 유호철
 * @since : 1.0
 **/
@Slf4j
@RestController
@RequestMapping
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService deliveryService;

    /**
     * 배송생성입니다.
     * 생성에 성공하면 200 이 반환됩니다.
     *
     * @param dto the dto
     * @return the response entity
     */
    @PostMapping("/delivery")
    public ResponseEntity<CreateDeliveryResponseDto> deliveryAdd(@Valid @RequestBody CreateDeliveryRequestDto dto) {
        log.info("call() ");
        CreateDeliveryResponseDto result = deliveryService.createDelivery(dto);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }
}
