package com.ch.cbsmiddleware.models;

import com.ch.cbsmiddleware.dto.request.TransactionRequest;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
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
@Table(name = "transaction_detail", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "account_number",
                "transaction_timestamp"
        })
})
public class TransactionDetail {
    @Id
    @SequenceGenerator(name = "transaction_detail_sequence_gen",
            sequenceName ="transaction_detail_sequence",allocationSize = 1)
    @GeneratedValue(generator = "transaction_detail_sequence_gen",strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "cbs_client_code", nullable = false)
    private String cbsClientCode;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "payment_amount", nullable = false)
    private int paymentAmount;

    @Column(name = "payment_gl")
    private String paymentGL;

    @Column(name = "transaction_timestamp", nullable = false)
    private Timestamp transactionTimestamp;

    @Column(name = "customer_commission_gl")
    private String customerCommissionGL;

    @Column(name = "customer_commission_amount", nullable = false)
    private int customerCommissionAmount;

    @Column(name = "gateway_commission_gl")
    private String gatewayCommissionGL;

    @Column(name = "gateway_commission_amount", nullable = false)
    private int gatewayCommissionAmount;

    @Column(name = "client_commission_gl")
    private String clientCommissionGL;

    @Column(name = "client_commission_amount", nullable = false)
    private int clientCommissionAmount;

    @Column(name = "beneficiary_number", nullable = false)
    private String beneficiaryNumber;

    @Column(name = "remarks", nullable = false)
    private String remarks;

    @Column(name = "service_code", nullable = false)
    private String serviceCode;

    @Column(name = "transaction_id", unique = true)
    private String transactionId;

    @Column(name = "voucher_number")
    private String voucherNumber;

    @Column(name = "transaction_status", nullable = false)
    private String transactionStatus;

    public static TransactionDetail buildFromRequest(TransactionRequest request){
        return TransactionDetail.builder()
                .cbsClientCode(request.getCbsClientCode())
                .accountNumber(request.getAccountNumber())
                .beneficiaryNumber(request.getBeneficiaryNumber())
                .mobileNumber(request.getMobileNumber())
                .paymentAmount(request.getPaymentAmount())
                .paymentGL(request.getPaymentGL())
                .transactionTimestamp(request.getTransactionTimestamp())
                .customerCommissionGL(request.getCustomerCommissionGL())
                .customerCommissionAmount(request.getCustomerCommissionAmount())
                .gatewayCommissionGL(request.getGatewayCommissionGL())
                .gatewayCommissionAmount(request.getGatewayCommissionAmount())
                .clientCommissionGL(request.getClientCommissionGL())
                .clientCommissionAmount(request.getClientCommissionAmount())
                .remarks(request.getRemarks())
                .serviceCode(request.getServiceCode())
                .transactionStatus(Status.PENDING)
                .build();
    }

    //Format for apache commons csv writer
    @Override
    public String toString() {
        return cbsClientCode+","+mobileNumber+","+accountNumber+","+beneficiaryNumber+","+paymentAmount+"," +
                paymentGL+","+transactionTimestamp+","+customerCommissionGL+","+customerCommissionAmount+","+
                gatewayCommissionGL+","+gatewayCommissionAmount+","+clientCommissionGL+","+
                clientCommissionAmount+","+remarks+","+serviceCode+","+transactionId+","+
                voucherNumber+","+ transactionStatus;
    }
}
