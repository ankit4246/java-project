package com.ch.cbsmiddleware.models;

import com.ch.cbsmiddleware.dto.request.VoucherRequest;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author bimal on 9/27/21
 * @project cbs-middleware
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)

@Entity
@Table(name = "voucher_request", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "account_number",
                "transaction_timestamp"
        })
})
public class VoucherRequestLog {
    @Id
    @SequenceGenerator(name = "voucher_request_sequence_gen",
            sequenceName = "voucher_request_sequence", allocationSize = 1)
    @GeneratedValue(generator = "voucher_request_sequence_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "cbs_client_code", nullable = false)
    private String cbsClientCode;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "payment_amount", nullable = false)
    private BigDecimal paymentAmount;

    @Column(name = "transaction_timestamp", nullable = false)
    private Timestamp transactionTimestamp;

    @Column(name = "customer_commission_amount", nullable = false)
    private BigDecimal customerCommissionAmount;

    @Column(name = "client_commission_amount", nullable = false)
    private BigDecimal clientCommissionAmount;

    @Column(name = "beneficiary_number", nullable = false)
    private String beneficiaryNumber;

    @Column(name = "remarks", nullable = false)
    private String remarks;

    @Column(name = "service")
    private String service;

    @Column(name = "service_code", nullable = false)
    private int serviceCode;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "transaction_id", unique = true)
    private long transactionId;

    @Column(name = "voucher_number")
    private String voucherNumber;

    @Column(name = "transaction_status", nullable = false)
    private String status;

    public static VoucherRequestLog buildFromRequest(VoucherRequest request) {
        return VoucherRequestLog.builder()
                .cbsClientCode(request.getCbsClientCode())
                .accountNumber(request.getAccountNumber())
                .beneficiaryNumber(request.getBeneficiaryNumber())
                .mobileNumber(request.getMobileNumber())
                .paymentAmount(request.getPaymentAmount())
                .transactionTimestamp(new Timestamp(System.currentTimeMillis()))
                .customerCommissionAmount(request.getCustomerCommissionAmount())
                .clientCommissionAmount(request.getClientCommissionAmount())
                .remarks(request.getRemarks())
                .service(request.getService())
                .serviceCode(request.getServiceCode())
                .serviceType(request.getServiceType())
                .status(Status.PENDING)
                .build();
    }

    //Format for apache commons csv writer
    @Override
    public String toString() {
        return String.join(",", Fields.VOUCHER_REQUEST_LOG_FIELDS);
    }
}
