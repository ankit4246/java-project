package com.ch.cbsmiddleware.models;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author bimal on 10/25/21
 * @project cbs-middleware
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)

@Entity
@Table(name = "voucher_request")
public class VoucherRequestLogOld {
    @Id
    @SequenceGenerator(name = "voucher_request_sequence_gen",
            sequenceName ="voucher_request_sequence",allocationSize = 1)
    @GeneratedValue(generator = "voucher_request_sequence_gen",strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "cbs_client_code", nullable = false)
    private String cbsClientCode;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @Column(name = "transaction_id", nullable = false)
    private String transactionId;

    @Column(name = "transaction_timestamp", nullable = false)
    private Timestamp transactionTimestamp;

    @Column(name = "customer_commission_gl")
    private String customerCommissionGL;

    @Column(name = "customer_commission_amount", nullable = false)
    private int customerCommissionAmount;

    @Column(name = "client_commission_gl")
    private String clientCommissionGL;

    @Column(name = "client_commission_amount", nullable = false)
    private int clientCommissionAmount;

    @Column(name = "status", nullable = false)
    private String status;

    //Format for apache commons csv writer
    @Override
    public String toString() {
        return cbsClientCode+","+ mobileNumber+","+ transactionId +","+
                transactionTimestamp+","+customerCommissionGL+","+customerCommissionAmount+","+
                clientCommissionGL+","+ clientCommissionAmount+","+status;
    }
}
