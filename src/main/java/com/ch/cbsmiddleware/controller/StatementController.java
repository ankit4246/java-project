package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.FullStatementRequest;
import com.ch.cbsmiddleware.dto.request.MiniStatementRequest;
import com.ch.cbsmiddleware.service.StatementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
 */
@RestController
@RequestMapping(value = "/statement")
@RequiredArgsConstructor
@Api(tags = "Mini Statement API")
public class StatementController extends BaseController {

    private final StatementService statementService;

    @ApiOperation(value = "Lists all transactions of a A/C number")
    @PostMapping(value = "/full")
    public ResponseEntity<?> getFullStatement(@Valid @RequestBody FullStatementRequest fullStatementRequest) {
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("retrieve.success","Full Statement", statementService.getFullStatement(fullStatementRequest))
        );
    }

    @ApiOperation(value = "Get N numbers of transactions associated to an A/C number")
    @PostMapping(value = "/mini")
    public ResponseEntity<?> getMiniStatement(@Valid @RequestBody MiniStatementRequest miniStatementRequest) {
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("retrieve.success","Mini Statement", statementService.getMiniStatement(miniStatementRequest))
        );
    }
}
