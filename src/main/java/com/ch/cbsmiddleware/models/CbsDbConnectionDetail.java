package com.ch.cbsmiddleware.models;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

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
@Table(name = "cbs_db_connection_detail")
public class CbsDbConnectionDetail {
    @Id
    @SequenceGenerator(name = "cbs_db_connection_detail_sequence_gen",
            sequenceName ="cbs_db_connection_detail_sequence",allocationSize = 1)
    @GeneratedValue(generator = "cbs_db_connection_detail_sequence_gen",strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "cbs_client_code", nullable = false)
    private String cbsClientCode;

    @Column(name = "db_name", nullable = false)
    private String dbName;

    @Column(name = "db_username", nullable = false)
    private String dbUserName;

    @Column(name = "db_password", nullable = false)
    private String dbPassword;

    @Column(name = "db_driver", nullable = false)
    private String dbDriver;

    @Column(name = "db_url", nullable = false)
    private String dbUrl;
}
