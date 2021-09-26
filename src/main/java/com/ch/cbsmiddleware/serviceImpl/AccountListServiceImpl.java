package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.dto.request.AccountListRequest;
import com.ch.cbsmiddleware.dto.response.AccountListResponse;
import com.ch.cbsmiddleware.dto.response.CustomerDetailByClientCodeResponse;
import com.ch.cbsmiddleware.service.AccountListService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project cbs-middleware
 * @Author mave on 9/26/21
 */
@Service
public class AccountListServiceImpl implements AccountListService {
    @Override
    public List<AccountListResponse> getAccountListByCustomerCode(AccountListRequest accountListRequest) {
        List<AccountListResponse> accountListResponses = List.of(
                new AccountListResponse("accountNo101",
                        "accountName101",
                        "currancyCode101",
                        "currancyName101",
                        "branchCode101",
                        "accoutnSatus101",
                        "accountType101"),
                new AccountListResponse("accountNo101",
                        "accountName101",
                        "currancyCode101",
                        "currancyName101",
                        "branchCode101",
                        "accoutnSatus101",
                        "accountType101")
        );

        return accountListResponses;
    }
}
