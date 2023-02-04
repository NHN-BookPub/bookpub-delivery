package com.nhnacademy.bookpubdelivery.exception;

/**
 * 배송상태코드관련 excepiton 입니다.
 *
 * @author : 유호철
 * @since : 1.0
 **/
public class DeliveryStateNotFoundException extends RuntimeException {
    public static final String MESSAGE = "배송상태값이없습니다.";

    public DeliveryStateNotFoundException() {
        super(MESSAGE);
    }
}
