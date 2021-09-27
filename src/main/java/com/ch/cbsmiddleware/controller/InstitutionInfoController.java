package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.response.HttpResponse;
import com.ch.cbsmiddleware.dto.response.ResponseGenerator;
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
public class InstitutionInfoController extends BaseController {

    private final InstitutionInfoService institutionInfoService;

    public InstitutionInfoController(ResponseGenerator responseGenerator, InstitutionInfoService institutionInfoService) {
        super(responseGenerator);
        this.institutionInfoService = institutionInfoService;
    }

    @GetMapping("/branch-list")
    public ResponseEntity<?> findBranchList(@RequestParam("cbsClientCode")String cbsClientCode){
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("branch.list.retrieve.success",
                        institutionInfoService.findBranchList(cbsClientCode))
        );
    }
    @GetMapping("/detail")
    public ResponseEntity<?> getInstitutionData(@RequestParam("cbsClientCode")String cbsClientCode){
        return ResponseEntity.ok(
            responseGenerator.getSuccessResponse("institution.retrieve.success", institutionInfoService.getInstitutionData(cbsClientCode))
        );
    }

}
