package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.config.MyBatisConfig;
import com.ch.cbsmiddleware.dto.response.ProductData;
import com.ch.cbsmiddleware.dto.response.ProductTypeData;
import com.ch.cbsmiddleware.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bimal on 10/27/21
 * @project cbs-middleware
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final MyBatisConfig myBatisConfig;

    @Override
    public List<ProductTypeData> listProductTypesOfClient(String cbsClientCode) {
        List<ProductTypeData> productTypeDataList = List.of(
                new ProductTypeData("123", "Product One"),
                new ProductTypeData("456", "Product Two")
        );

        return productTypeDataList;
    }

    @Override
    public List<ProductData> listProducts(String cbsClientCode, String productTypeCode) {
        SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(cbsClientCode);

        SqlSession session = factory.openSession();

        List<ProductData> productDataList = session.selectList("getProductList");

        session.close();

        return productDataList;
    }
}
