package com.nhnacademy.bookpubdelivery.exception;

/**
 * Some description here.
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
