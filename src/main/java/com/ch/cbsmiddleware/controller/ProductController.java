package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * @author bimal on 10/27/21
 * @project cbs-middleware
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "Product API")
public class ProductController extends BaseController{

    private final ProductService productService;

    @ApiOperation(value = "Lists various finance options offered by a Client")
    @GetMapping("list-product-types")
    public ResponseEntity<?> listProductTypesOfClient(@NotBlank @RequestParam("cbsClientCode") String cbsClientCode ){
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("retrieve.success","Product Types", productService.listProductTypesOfClient(cbsClientCode))
        );
    }
    @ApiOperation(value = "Lists all products listed within a particular Product-type")
    @GetMapping("/list-product")
    public ResponseEntity<?> listProducts(@NotBlank @RequestParam("cbsClientCode") String cbsClientCode,
                                          @RequestParam(value = "productTypeCode", required = false) String productTypeCode){

        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("retrieve.success","Product List", productService.listProducts(cbsClientCode,
                        productTypeCode))
        );
    }

}
