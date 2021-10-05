package com.ch.cbsmiddleware.models;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author bimal on 10/4/21
 * @project cbs-middleware
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)

@Entity
@Table(name = "cheque_request")
public class ChequeRequestLog {
    @Id
    @SequenceGenerator(name = "cheque_request_sequence_gen",
            sequenceName = "cheque_request_sequence", allocationSize = 1)
    @GeneratedValue(generator = "cheque_request_sequence_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "cbs_client_code", nullable = false)
    private String cbsClientCode;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "cheque_number")
    private String chequeNumber;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "timestamp", nullable = false)
    private Timestamp timestamp;

    @Column(name = "status")
    private String status;

    //Format for apache commons csv writer
    @Override
    public String toString() {
        return id+","+cbsClientCode+","+accountNumber+","+chequeNumber+","+type+","+timestamp+","+status    ;
    }
}

