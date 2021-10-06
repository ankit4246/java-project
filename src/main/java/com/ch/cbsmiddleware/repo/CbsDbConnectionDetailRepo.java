package com.ch.cbsmiddleware.repo;

import com.ch.cbsmiddleware.models.CbsDbConnectionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author bimal on 10/5/21
 * @project cbs-middleware
 */
@Repository
public interface CbsDbConnectionDetailRepo extends JpaRepository<CbsDbConnectionDetail, Integer> {
    Optional<CbsDbConnectionDetail> findByCbsClientCode(String cbsClientCode);


}
