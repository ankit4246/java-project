package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.FullStatementRequest;
import com.ch.cbsmiddleware.dto.response.FullStatementResponse;
import com.ch.cbsmiddleware.service.FullStatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Project cbs-middleware
 * @Author mave on 9/26/21
 */
@RestController
@RequestMapping(value = "/full-statement")
@RequiredArgsConstructor
public class FullStatementController {

    private final FullStatementService fullStatementService;

    @GetMapping(value = "/")
    public List<FullStatementResponse> getFullStatement(@RequestBody FullStatementRequest fullStatementRequest){
        return fullStatementService.getFullStatement(fullStatementRequest);
    }
}
