package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.config.MyBatisConfig;
import com.ch.cbsmiddleware.dto.response.AccountListResponse;
import com.ch.cbsmiddleware.dto.response.ProductData;
import com.ch.cbsmiddleware.service.ProductListService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Service
@RequiredArgsConstructor
public class ProductListServiceImpl implements ProductListService {

    private final MyBatisConfig myBatisConfig;

    @Override
    public List<ProductData> listProducts(String cbsClientCode, String productTypeCode) {
        SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(cbsClientCode);

        SqlSession session = factory.openSession();

        List<ProductData> productDataList = session.selectList("getProductList");

        session.close();

        return productDataList;
    }
}
