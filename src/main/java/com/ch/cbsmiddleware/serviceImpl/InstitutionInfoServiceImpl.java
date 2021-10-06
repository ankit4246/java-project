package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.config.MyBatisConfig;
import com.ch.cbsmiddleware.dto.response.BranchData;
import com.ch.cbsmiddleware.dto.response.InstitutionData;
import com.ch.cbsmiddleware.service.InstitutionInfoService;
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
public class InstitutionInfoServiceImpl implements InstitutionInfoService {

    private final MyBatisConfig myBatisConfig;

    @Override
    public List<BranchData> findBranchList(String cbsClientCode) {
        SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(cbsClientCode);

        SqlSession session = factory.openSession();

        List<BranchData> branchDataList = session.selectList("findBranchList");

        session.close();

        return branchDataList;
    }

    @Override
    public InstitutionData getInstitutionData(String cbsClientCode) {

        SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(cbsClientCode);

        SqlSession session = factory.openSession();
        InstitutionData institutionData = session.selectOne("getInstitutionData");
        session.close();

        return institutionData;
    }
}
