package com.mlaz.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author quanhoang
 * Main Controller for MLAZ API
 */
@RestController
public class MainController {

    @RequestMapping(value = "/")
    public String index() {
        return "Hello World";
    }
}
