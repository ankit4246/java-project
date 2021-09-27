package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.dto.response.ProductTypeData;
import com.ch.cbsmiddleware.service.ProductTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Override
    public List<ProductTypeData> listProductTypesOfClient(String cbsClientCode) {
        List<ProductTypeData> productTypeDataList = List.of(
                new ProductTypeData("123", "Product One"),
                new ProductTypeData("456", "Product Two")
        );

        return productTypeDataList;
    }
}
