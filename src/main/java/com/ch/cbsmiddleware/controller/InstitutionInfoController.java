package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.response.HttpResponse;
import com.ch.cbsmiddleware.dto.response.ResponseGenerator;
import com.ch.cbsmiddleware.service.InstitutionInfoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@RestController
@RequestMapping("/institution")
@RequiredArgsConstructor
public class InstitutionInfoController extends BaseController {

    private final InstitutionInfoService institutionInfoService;


    @GetMapping("/branch-list")
    public ResponseEntity<?> findBranchList(@NotBlank @RequestParam("cbsClientCode")String cbsClientCode){
        System.out.println(institutionInfoService);
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("retrieve.success","Branch List",
                        institutionInfoService.findBranchList(cbsClientCode))
        );
    }
    @GetMapping("/detail")
    public ResponseEntity<?> getInstitutionData(@NotBlank @RequestParam("cbsClientCode")String cbsClientCode){
        return ResponseEntity.ok(
            responseGenerator.getSuccessResponse("retrieve.success", "Institution",institutionInfoService.getInstitutionData(cbsClientCode))
        );
    }

}
