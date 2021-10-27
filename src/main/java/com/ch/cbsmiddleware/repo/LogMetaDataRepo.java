package com.ch.cbsmiddleware.repo;

import com.ch.cbsmiddleware.models.log.LogMetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author bimal on 10/4/21
 * @project cbs-middleware
 */
@Repository
public interface LogMetaDataRepo extends JpaRepository<LogMetaData, Integer> {
    Optional<LogMetaData> findByLogType(String logType);
}
