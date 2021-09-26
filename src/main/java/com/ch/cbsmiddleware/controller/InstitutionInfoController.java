package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.response.HttpResponse;
import com.ch.cbsmiddleware.service.InstitutionInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@RestController
@RequestMapping("/institution")
@RequiredArgsConstructor
public class InstitutionInfoController {

    private final InstitutionInfoService institutionInfoService;

    @GetMapping("/branch-list")
    public ResponseEntity<?> findBranchList(@RequestParam("cbsClientCode")String cbsClientCode){
        return ResponseEntity.ok(
                HttpResponse.getSuccessResponse("Branch List",
                        institutionInfoService.findBranchList(cbsClientCode))
        );
    }
    @GetMapping("/detail")
    public ResponseEntity<?> getInstitutionData(@RequestParam("cbsClientCode")String cbsClientCode){
        return ResponseEntity.ok(
            HttpResponse.getSuccessResponse("Institution Detail", institutionInfoService.getInstitutionData(cbsClientCode))
        );
    }

}
