package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.response.HttpResponse;
import com.ch.cbsmiddleware.dto.response.ResponseGenerator;
import com.ch.cbsmiddleware.service.ProductListService;
import lombok.Getter;
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
public class ProductListController extends BaseController{

    private final ProductListService productListService;

    public ProductListController(ResponseGenerator responseGenerator, ProductListService productListService) {
        super(responseGenerator);
        this.productListService = productListService;
    }

    @GetMapping("/list-product")
    public ResponseEntity<?> listProducts(@NotBlank @RequestParam("cbsClientCode") String cbsClientCode,
                                          @RequestParam(value = "productTypeCode", required = false) String productTypeCode){

        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("retrieve.success","Product List", productListService.listProducts(cbsClientCode,
                        productTypeCode))
        );
    }

}
