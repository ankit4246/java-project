package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.response.HttpResponse;
import com.ch.cbsmiddleware.service.ProductListService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@RestController
@RequiredArgsConstructor
public class ProductListController {

    private final ProductListService productListService;

    @GetMapping("/list-product")
    public ResponseEntity<?> listProducts(@RequestParam("cbsClientCode") String cbsClientCode,
                                          @RequestParam(value = "productTypeCode", required = false) String productTypeCode){

        return ResponseEntity.ok(
                HttpResponse.getSuccessResponse("list of products", productListService.listProducts(cbsClientCode,
                        productTypeCode))
        );
    }

}
