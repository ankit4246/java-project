package com.ch.cbsmiddleware.mapper;

import com.ch.cbsmiddleware.dto.response.ProductData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Project cbs-middleware
 * @Author mave on 10/25/21
 */
@Mapper
public interface ProductListProcMapper {
    List<ProductData> getProductList();
}
