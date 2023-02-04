package com.nhnacademy.bookpubdelivery.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nhnacademy.bookpubdelivery.delivery.controller.DeliveryController;
import com.nhnacademy.bookpubdelivery.delivery.dto.request.CreateDeliveryRequestDto;
import com.nhnacademy.bookpubdelivery.delivery.dto.response.CreateDeliveryResponseDto;
import com.nhnacademy.bookpubdelivery.delivery.service.DeliveryService;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Some description here.
 *
 * @author : 유호철
 * @since : 1.0
 **/
@WebMvcTest(DeliveryController.class)
class DeliveryControllerTest {

    @MockBean
    DeliveryService service;
    @Autowired
    MockMvc mvc;
    ObjectMapper objectMapper;

    CreateDeliveryRequestDto dto;

    @BeforeEach
    void setUp() {
        dto = new CreateDeliveryRequestDto();
        objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        ReflectionTestUtils.setField(dto, "orderNo", 1L);
        ReflectionTestUtils.setField(dto, "deliveryRequest", "request");
        ReflectionTestUtils.setField(dto, "recipient", "re");
        ReflectionTestUtils.setField(dto, "phone", "010");
        ReflectionTestUtils.setField(dto, "requestDate", LocalDateTime.now());
        ReflectionTestUtils.setField(dto, "addressDetail", "detail");

    }

    @DisplayName("배송이 생성됩니다.")
    @Test
    void deliveryAdd() throws Exception {

        CreateDeliveryResponseDto deliveryResponseDto = new CreateDeliveryResponseDto("1234");

        when(service.createDelivery(any()))
                .thenReturn(deliveryResponseDto);

        mvc.perform(post("/delivery")
                        .content(
                                objectMapper.writeValueAsString(dto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.invoiceNo").value(deliveryResponseDto.getInvoiceNo()))
                .andDo(print());

    }
}