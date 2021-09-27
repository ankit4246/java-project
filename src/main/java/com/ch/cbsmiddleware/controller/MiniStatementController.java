package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.MiniStatementRequest;
import com.ch.cbsmiddleware.dto.response.HttpResponse;
import com.ch.cbsmiddleware.dto.response.ResponseGenerator;
import com.ch.cbsmiddleware.service.MiniStatementService;
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
@RequestMapping(value = "/mini-statement")
public class MiniStatementController extends BaseController {

    private final MiniStatementService miniStatementService;

    public MiniStatementController(ResponseGenerator responseGenerator, MiniStatementService miniStatementService) {
        super(responseGenerator);
        this.miniStatementService = miniStatementService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> getMiniStatement(@RequestBody MiniStatementRequest miniStatementRequest) {
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("mini-statement.retrieve.success", miniStatementService.getMiniStatement(miniStatementRequest))
        );
    }
}
