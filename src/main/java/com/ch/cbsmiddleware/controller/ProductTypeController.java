package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.response.HttpResponse;
import com.ch.cbsmiddleware.dto.response.ResponseGenerator;
import com.ch.cbsmiddleware.service.ProductTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@RestController
@RequiredArgsConstructor
public class ProductTypeController extends BaseController{

    private final ProductTypeService productTypeService;

    @GetMapping("list-product-types")
    public ResponseEntity<?> listProductTypesOfClient(@NotBlank @RequestParam("cbsClientCode") String cbsClientCode ){
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("retrieve.success","Product Types", productTypeService.listProductTypesOfClient(cbsClientCode))
        );
    }
}
