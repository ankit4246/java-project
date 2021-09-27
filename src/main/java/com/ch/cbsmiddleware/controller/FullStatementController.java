package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.FullStatementRequest;
import com.ch.cbsmiddleware.dto.response.FullStatementResponse;
import com.ch.cbsmiddleware.dto.response.HttpResponse;
import com.ch.cbsmiddleware.dto.response.ResponseGenerator;
import com.ch.cbsmiddleware.service.FullStatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
 */
@RestController
@RequestMapping(value = "/full-statement")
public class FullStatementController extends BaseController {

    private final FullStatementService fullStatementService;

    public FullStatementController(ResponseGenerator responseGenerator, FullStatementService fullStatementService) {
        super(responseGenerator);
        this.fullStatementService = fullStatementService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> getFullStatement(@RequestBody FullStatementRequest fullStatementRequest) {
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("full-statement.retrieve.success", fullStatementService.getFullStatement(fullStatementRequest))
        );
    }
}
