package com.ch.cbsmiddleware.repo;

import com.ch.cbsmiddleware.models.VoucherRequestLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bimal on 10/25/21
 * @project cbs-middleware
 */
@Repository
public interface VoucherRequestLogRepo extends JpaRepository<VoucherRequestLog, Integer> {
}
