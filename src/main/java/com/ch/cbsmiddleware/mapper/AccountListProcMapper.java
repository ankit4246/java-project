package com.ch.cbsmiddleware.mapper;

import com.ch.cbsmiddleware.dto.response.AccountListResponse;

import java.util.List;

/**
 * @Project cbs-middleware
 * @Author mave on 10/6/21
 */
public interface AccountListProcMapper {
   List<AccountListResponse> getAcountListByCustomerCode(String customerCode);
}
