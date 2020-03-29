package com.fire.back.controller.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/wx/pay")
public class WxPayController {

    private Logger logger = LoggerFactory.getLogger(WxPayController.class);

}
