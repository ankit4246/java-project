package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.MiniStatementRequest;
import com.ch.cbsmiddleware.dto.response.ResponseGenerator;
import com.ch.cbsmiddleware.service.MiniStatementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
 */
@RestController
@RequestMapping(value = "/mini-statement")
@RequiredArgsConstructor
@Api(tags = "Mini Statement API")
public class MiniStatementController extends BaseController {

    private final MiniStatementService miniStatementService;

    @ApiOperation(value = "Get N numbers of transactions associated to an A/C number")
    @GetMapping(value = "/")
    public ResponseEntity<?> getMiniStatement(@Valid @RequestBody MiniStatementRequest miniStatementRequest) {
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("retrieve.success","Mini Statement", miniStatementService.getMiniStatement(miniStatementRequest))
        );
    }
}
