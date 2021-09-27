package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.dto.response.ProductTypeData;

import java.util.List;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
public interface ProductTypeService {
    List<ProductTypeData> listProductTypesOfClient(String cbsClientCode);
}
