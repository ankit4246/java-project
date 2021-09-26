package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.dto.request.TransactionRequest;
import com.ch.cbsmiddleware.service.TransactionRequestService;
import org.springframework.stereotype.Service;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Service
public class TransactionRequestServiceImpl implements TransactionRequestService {

    @Override
    public String requestTransaction(TransactionRequest request) {
        String transactionId = "7288AB";
        return transactionId;
    }
}
