package com.payment.gateway.api.controller;


import com.payment.gateway.api.Model.PaymentInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class EntryController {

    @Autowired
    PaymentInfo info;

    private static final Logger logger = LogManager.getLogger(EntryController.class);

    @CrossOrigin
    @GetMapping("/status")
    public ResponseEntity<PaymentInfo> getStatus() {

        ResponseEntity<PaymentInfo> response ;
        try {
            logger.info("Entered");
            info.setData(Thread.activeCount());
            response =  new ResponseEntity<PaymentInfo>(info, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getLocalizedMessage());
            response =  new ResponseEntity<PaymentInfo>(info, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally
        {

        }
        return response;
    }

    @GetMapping("/uuid")
    public ResponseEntity<String> getUUID()
    {
        try
        {
            logger.info("Entered");
        }
        finally
        {

        }

        return new ResponseEntity<String>(UUID.randomUUID().toString(), HttpStatus.OK);
    }
}
