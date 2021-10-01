package com.ch.cbsmiddleware.auth;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * @author bimal on 10/1/21
 * @project cbs-middleware
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @SequenceGenerator(name = "admin_sequence_gen",
            sequenceName ="admin_sequence",allocationSize = 1)
    @GeneratedValue(generator = "admin_sequence_gen",strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;
}
