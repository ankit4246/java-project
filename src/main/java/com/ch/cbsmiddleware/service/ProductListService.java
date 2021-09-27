package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.dto.response.ProductData;

import java.util.List;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
public interface ProductListService {
    List<ProductData> listProducts(String cbsClientCode, String productTypeCode);
}
