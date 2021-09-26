package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.dto.response.BranchData;
import com.ch.cbsmiddleware.dto.response.InstitutionData;

import java.util.List;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
public interface InstitutionInfoService {

    List<BranchData> findBranchList(String cbsClientCode);

    InstitutionData getInstitutionData(String cbsClientCode);

}
