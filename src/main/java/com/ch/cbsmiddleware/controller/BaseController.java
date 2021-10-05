package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.response.ResponseGenerator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Controller
@NoArgsConstructor
public class BaseController {

    @Autowired
    protected ResponseGenerator responseGenerator;

}
