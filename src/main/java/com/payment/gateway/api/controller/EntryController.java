package com.payment.gateway.api.controller;


import com.payment.gateway.api.Model.PaymentInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntryController {

    @Autowired
    PaymentInfo info;



    @CrossOrigin
    @GetMapping("/status")
    public ResponseEntity<PaymentInfo> getStatus() {
        Logger logger = LoggerFactory.getLogger(EntryController.class);
        ResponseEntity<PaymentInfo> response ;
        try {
            logger.debug("Entered");
            info.setData(Thread.activeCount());
            response =  new ResponseEntity<PaymentInfo>(info, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getLocalizedMessage());
            response =  new ResponseEntity<PaymentInfo>(info, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            logger = null;
        }
        return response;
    }
}
