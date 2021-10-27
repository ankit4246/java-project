package com.ch.cbsmiddleware.repo;

import com.ch.cbsmiddleware.models.log.InternalFundTransferLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bimal on 9/27/21
 * @project cbs-middleware
 */
@Repository
public interface InternalFundTransferRepo extends JpaRepository<InternalFundTransferLog, Integer>{
}
