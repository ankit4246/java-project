package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.dto.request.AccountListRequest;
import com.ch.cbsmiddleware.dto.response.AccountData;

import java.util.List;

/**
 * @Project cbs-middleware
 * @Author mave on 9/26/21
 */
public interface AccountListService {
    List<AccountData> getAccountListByCustomerCode(AccountListRequest accountListRequest);
}
