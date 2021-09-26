package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.AccountListRequest;
import com.ch.cbsmiddleware.dto.response.AccountListResponse;
import com.ch.cbsmiddleware.service.AccountListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Project cbs-middleware
 * @Author mave on 9/26/21
 */
@RestController
@RequestMapping(value = "/account-list")
@RequiredArgsConstructor
public class AccountListController {

    private final AccountListService accountListService;

    @GetMapping(value = "/")
    public List<AccountListResponse> getAccountListByCustomerCode(@RequestBody AccountListRequest accountListRequest){
        return accountListService.getAccountListByCustomerCode(accountListRequest);
    }
}
