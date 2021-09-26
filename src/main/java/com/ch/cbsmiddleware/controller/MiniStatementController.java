package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.MiniStatementRequest;
import com.ch.cbsmiddleware.dto.response.MiniStatementResponse;
import com.ch.cbsmiddleware.service.MiniStatementService;
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
@RequestMapping(value = "/mini-statement")
@RequiredArgsConstructor
public class MiniStatementController {

    private final MiniStatementService miniStatementService;

    @GetMapping(value = "/")
    public List<MiniStatementResponse> getMiniStatement(@RequestBody MiniStatementRequest miniStatementRequest){
        return miniStatementService.getMiniStatement(miniStatementRequest);
    }
}
