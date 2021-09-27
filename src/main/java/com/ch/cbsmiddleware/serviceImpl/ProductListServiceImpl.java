package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.dto.response.ProductData;
import com.ch.cbsmiddleware.service.ProductListService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Service
public class ProductListServiceImpl implements ProductListService {

    @Override
    public List<ProductData> listProducts(String cbsClientCode, String productTypeCode) {
        return List.of(
                new ProductData("123", "ABC", "012", "Saving Account"),
                new ProductData("123", "ABC", "012", "Saving Account")

        );
    }
}
