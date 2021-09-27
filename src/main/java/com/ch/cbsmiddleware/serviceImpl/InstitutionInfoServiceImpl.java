package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.dto.response.BranchData;
import com.ch.cbsmiddleware.dto.response.InstitutionData;
import com.ch.cbsmiddleware.service.InstitutionInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Service
public class InstitutionInfoServiceImpl implements InstitutionInfoService {

    @Override
    public List<BranchData> findBranchList(String cbsClientCode) {
        return List.of(
                new BranchData("123", "KTM", "Branch", "", "", "", "", ""),
                new BranchData("345", "LALIT", "Branch", "", "", "", "", ""),
                new BranchData("678", "PKL", "Branch", "", "", "", "", "")
        );
    }

    @Override
    public InstitutionData getInstitutionData(String cbsClientCode) {
        return InstitutionData.builder()
                .cbsClientCode("737")
                .name("Ximek")
                .contactNo("982889829")
                .headOfficeManagerName("Ram Sharma")
                .headOfficeManagerNumber("982899922")
                .address("Kathmandu")
                .email("info@ximek.com")
                .build();
    }
}
