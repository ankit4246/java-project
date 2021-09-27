package com.ch.cbsmiddleware.models;

import com.ch.cbsmiddleware.dto.request.InternalFundTransferRequest;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;

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
@Table(name = "internal_fund_transfer", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "from_account_number",
                "transaction_timestamp"
        })
})
public class InternalFundTransfer {
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

    @Column(name = "transaction_timestamp", nullable = false)
    private Timestamp transactionTimestamp;

    @Column(name = "voucher_number")
    private String voucherNumber;

    @Column(name = "transaction_status", nullable = false)
    private String transactionStatus;

    public static InternalFundTransfer buildFromRequest(InternalFundTransferRequest request){
        InternalFundTransfer internalFundTransfer = InternalFundTransfer.builder()
                .cbsClientCode(request.getCbsClientCode())
                .fromAccountNumber(request.getFromAccountNumber())
                .toAccountNumber(request.getToAccountNumber())
                .paymentAmount(request.getPaymentAmount())
                .remarks(request.getRemarks())
                .transactionTimestamp(request.getTransactionTimestamp())
                .transactionStatus(TransactionStatus.PENDING)
                .build();
        return internalFundTransfer;
    }
}
