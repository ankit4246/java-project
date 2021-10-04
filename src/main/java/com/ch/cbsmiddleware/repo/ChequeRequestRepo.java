package com.ch.cbsmiddleware.repo;

import com.ch.cbsmiddleware.models.ChequeRequestLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bimal on 10/4/21
 * @project cbs-middleware
 */
@Repository
public interface ChequeRequestRepo extends JpaRepository<ChequeRequestLog, Integer> {
}
