package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.models.ChequeRequestLog;

import java.io.IOException;

/**
 * @author bimal on 10/4/21
 * @project cbs-middleware
 */
public interface CsvFileWriter {
    void writeChequeRequest(ChequeRequestLog chequeRequestLog);

}
