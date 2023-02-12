package com.nhnacademy.bookpubdelivery.delivery.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 배송을 생성하기위한 Dto 입니다.
 *
 * @author : 유호철
 * @since : 1.0
 **/
@Getter
@NoArgsConstructor
public class CreateDeliveryRequestDto {
    @NotNull
    private Long orderNo;
    private String deliveryRequest;
    @NotBlank
    private String recipient;
    @NotBlank
    private String phone;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime requestDate;
    @NotNull
    private String addressDetail;
}
