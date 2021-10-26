package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.FullStatementRequest;
import com.ch.cbsmiddleware.service.FullStatementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
 */
@RestController
@RequestMapping(value = "/full-statement")
@RequiredArgsConstructor
@Api(tags = "Full Statement API")
public class FullStatementController extends BaseController {

    private final FullStatementService fullStatementService;

    @ApiOperation(value = "Lists all transactions of a A/C number")
    @PostMapping(value = "/")
    public ResponseEntity<?> getFullStatement(@Valid @RequestBody FullStatementRequest fullStatementRequest) {
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("retrieve.success","Full Statement", fullStatementService.getFullStatement(fullStatementRequest))
        );
    }
}
