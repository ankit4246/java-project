package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.dto.response.ProductData;
import com.ch.cbsmiddleware.dto.response.ProductTypeData;

import java.util.List;

/**
 * @author bimal on 10/27/21
 * @project cbs-middleware
 */
public interface ProductService {
    List<ProductTypeData> listProductTypesOfClient(String cbsClientCode);
    List<ProductData> listProducts(String cbsClientCode, String productTypeCode);

}
