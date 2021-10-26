package com.ch.cbsmiddleware.repo;

import com.ch.cbsmiddleware.models.VoucherReversalLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bimal on 10/26/21
 * @project cbs-middleware
 */
@Repository
public interface VoucherReversalLogRepo extends JpaRepository<VoucherReversalLog, Integer> {
}
