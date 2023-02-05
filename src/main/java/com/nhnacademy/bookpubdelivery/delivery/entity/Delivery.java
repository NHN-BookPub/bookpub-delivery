package com.nhnacademy.bookpubdelivery.delivery.entity;


import com.nhnacademy.bookpubdelivery.deliverystate.entity.DeliveryState;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 배송관련 entity
 *
 * @author : 유호철
 * @since : 1.0
 **/
@Getter
@Table(name = "delivery")
@Entity
@NoArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_number")
    private Long deliveryNo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_state_number")
    private DeliveryState state;


    @NotNull
    @Column(name = "order_no")
    private Long orderNo;

    @NotNull
    @Column(name = "delivery_invoice_number", unique = true)
    private String invoiceNo;

    @NotNull
    @Column(name = "delivery_company")
    private String company;

    @Column(name = "delivery_request")
    private String request;

    @NotNull
    @Column(name = "delivery_recipient")
    private String recipient;

    @NotNull
    @Column(name = "delivery_recipient_phone")
    private String phone;

    @Column(name = "delivery_finished_at")
    private LocalDateTime finishedAt;

    @NotNull
    @Column(name = "delivery_request_date")
    private LocalDateTime requestDate;

    @NotNull
    @Column(name = "delivery_address_detail")
    private String addressDetail;

    @Builder
    public Delivery(DeliveryState state, Long orderNo,
                    String invoiceNo, String company,
                    String request, String recipient,
                    String phone, LocalDateTime finishedAt,
                    LocalDateTime requestDate,
                    String addressDetail) {
        this.state = state;
        this.orderNo = orderNo;
        this.invoiceNo = invoiceNo;
        this.company = company;
        this.request = request;
        this.recipient = recipient;
        this.phone = phone;
        this.finishedAt = finishedAt;
        this.requestDate = requestDate;
        this.addressDetail = addressDetail;
    }
}
