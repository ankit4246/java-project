package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.AccountListRequest;
import com.ch.cbsmiddleware.dto.response.ResponseGenerator;
import com.ch.cbsmiddleware.service.AccountListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
 */
@RestController

@RequestMapping(value = "/account-list")
@RequiredArgsConstructor
@Api(tags = "Account APIs")
public class AccountListController extends BaseController{

    private final AccountListService accountListService;

    @ApiOperation(value = "Get list of Accounts associated with a Customer")
    @PostMapping(value = "/")
    public ResponseEntity<?> getAccountListByCustomerCode(@Valid @RequestBody AccountListRequest accountListRequest){
         return ResponseEntity.ok(
                 responseGenerator.getSuccessResponse("retrieve.success","Account List",accountListService.getAccountListByCustomerCode(accountListRequest))
        );
    }
}
