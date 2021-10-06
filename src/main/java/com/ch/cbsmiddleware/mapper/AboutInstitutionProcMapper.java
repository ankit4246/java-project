package com.ch.cbsmiddleware.mapper;

import com.ch.cbsmiddleware.dto.response.BranchData;
import com.ch.cbsmiddleware.dto.response.InstitutionData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Project cbs-middleware
 * @Author mave on 10/6/21
 */
@Mapper
public interface AboutInstitutionProcMapper {
    InstitutionData getInstitutionData();
    List<BranchData> findBranchList();
}
