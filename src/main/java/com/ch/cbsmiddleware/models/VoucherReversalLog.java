package com.ch.cbsmiddleware.models;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * @author bimal on 10/26/21
 * @project cbs-middleware
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)

@Entity
@Table(name = "voucher_reversal")
public class VoucherReversalLog {
    @Id
    @SequenceGenerator(name = "voucher_reversal_sequence_gen",
            sequenceName = "voucher_reversal_sequence", allocationSize = 1)
    @GeneratedValue(generator = "voucher_reversal_sequence_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "voucher_no", nullable = false)
    private String voucherNo;

    @Column(name = "status", nullable = false)
    private String status;

    //Format for apache commons csv writer
    @Override
    public String toString() {
        return voucherNo+ ","+ status;
    }
}
