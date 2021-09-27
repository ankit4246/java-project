package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.response.ResponseGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Controller
@RequiredArgsConstructor
public class BaseController {

    protected final ResponseGenerator responseGenerator;

}
