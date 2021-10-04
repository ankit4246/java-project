package com.ch.cbsmiddleware.models;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;

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
@Table(name = "log_metadata")
@ToString
public class LogMetaData {
    @Id
    @SequenceGenerator(name = "log_metadata_sequence_gen",
            sequenceName ="log_metadata_sequence",allocationSize = 1)
    @GeneratedValue(generator = "log_metadata_sequence_gen",strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "log_type", nullable = false, unique = true)
    private String logType;
}
