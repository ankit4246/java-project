package com.ch.cbsmiddleware.mybatistest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bimal on 10/5/21
 * @project cbs-middleware
 */
@RestController
@RequiredArgsConstructor
public class MyBatisTestController {

    private final MyBatisTestService myBatisTestService;

    @GetMapping("/accounts")
    public ResponseEntity<?> getAccounts(@RequestParam("cbsClientCode") String cbsClientCode){
        return ResponseEntity.ok(myBatisTestService.getAccounts(cbsClientCode));
    }

    @GetMapping("/accountsxml")
    public ResponseEntity<?> getAccountsXml(@RequestParam("cbsClientCode") String cbsClientCode){
        return ResponseEntity.ok(myBatisTestService.getAccountsXml(cbsClientCode));
    }

}
