package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.service.InstitutionInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "Institution APIs")
public class InstitutionInfoController extends BaseController {

    private final InstitutionInfoService institutionInfoService;

    @ApiOperation(value = "Lists branches of a Client")
    @GetMapping("/branch-list")
    public ResponseEntity<?> findBranchList(@NotBlank @RequestParam("cbsClientCode")String cbsClientCode){
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("retrieve.success","Branch List",
                        institutionInfoService.findBranchList(cbsClientCode))
        );
    }

    @ApiOperation(value = "Get the Head office details of a Client")
    @GetMapping("/detail")
    public ResponseEntity<?> getInstitutionData(@NotBlank @RequestParam("cbsClientCode")String cbsClientCode){
        return ResponseEntity.ok(
            responseGenerator.getSuccessResponse("retrieve.success", "Institution",institutionInfoService.getInstitutionData(cbsClientCode))
        );
    }

}
