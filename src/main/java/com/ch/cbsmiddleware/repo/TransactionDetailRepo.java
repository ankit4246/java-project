package com.ch.cbsmiddleware.repo;

import com.ch.cbsmiddleware.models.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author bimal on 9/27/21
 * @project cbs-middleware
 */
@Repository
public interface TransactionDetailRepo extends JpaRepository<TransactionDetail, Integer> {

    Optional<TransactionDetail> findByTransactionId(String transactionId);
}
