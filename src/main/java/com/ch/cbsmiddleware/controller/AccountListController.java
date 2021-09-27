package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.AccountListRequest;
import com.ch.cbsmiddleware.dto.response.ResponseGenerator;
import com.ch.cbsmiddleware.service.AccountListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
 */
@RestController
@RequestMapping(value = "/account-list")
public class AccountListController extends BaseController{

    private final AccountListService accountListService;

    public AccountListController(ResponseGenerator responseGenerator, AccountListService accountListService) {
        super(responseGenerator);
        this.accountListService = accountListService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> getAccountListByCustomerCode(@Valid @RequestBody AccountListRequest accountListRequest){
         return ResponseEntity.ok(
                 responseGenerator.getSuccessResponse("account-list.retrieve.success", accountListService.getAccountListByCustomerCode(accountListRequest))
        );
    }
}
