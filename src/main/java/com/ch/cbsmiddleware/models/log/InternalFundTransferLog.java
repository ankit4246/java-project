package com.ch.cbsmiddleware.models.log;

import com.ch.cbsmiddleware.constant.Status;
import com.ch.cbsmiddleware.dto.request.InternalFundTransferRequest;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
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
@Table(name = "internal_fund_transfer", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "from_account_number",
                "timestamp"
        })
})
public class InternalFundTransferLog {
    @Id
    @SequenceGenerator(name = "internal_fund_transfer_sequence_gen",
            sequenceName ="internal_fund_transfer_sequence",allocationSize = 1)
    @GeneratedValue(generator = "internal_fund_transfer_sequence_gen",strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "cbs_client_code", nullable = false)
    private String cbsClientCode;

    @Column(name = "from_account_number", nullable = false)
    private String fromAccountNumber;

    @Column(name = "to_account_number", nullable = false)
    private String toAccountNumber;

    @Column(name = "payment_amount", nullable = false)
    private int paymentAmount;

    @Column(name = "remarks", nullable = false)
    private String remarks;

    @Column(name = "timestamp", nullable = false)
    private Timestamp timestamp;

    @Column(name = "voucher_number")
    private String voucherNumber;

    @Column(name = "status", nullable = false)
    private String status;

    public static InternalFundTransferLog buildFromRequest(InternalFundTransferRequest request){
        InternalFundTransferLog internalFundTransfer = InternalFundTransferLog.builder()
                .cbsClientCode(request.getCbsClientCode())
                .fromAccountNumber(request.getFromAccountNumber())
                .toAccountNumber(request.getToAccountNumber())
                .paymentAmount(request.getPaymentAmount())
                .remarks(request.getRemarks())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .status(Status.PENDING)
                .build();
        return internalFundTransfer;
    }

    //Format for apache commons csv writer
    @Override
    public String toString() {
        return id+","+cbsClientCode+","+fromAccountNumber+","+toAccountNumber+","+paymentAmount+","+remarks+","+timestamp+","+voucherNumber+","+status;

    }
}
