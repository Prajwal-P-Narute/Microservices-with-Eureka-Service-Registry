package com.microser.PaymentService.controller;

import java.util.List;

import com.microser.PaymentService.dto.NetBankingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PaymentsController {

    Logger logger = LoggerFactory.getLogger(PaymentsController.class);

    @GetMapping("/options")
    public List<String> getAllPaymentOptionS(){
        logger.info("Request for Payment Options ");

        return List.of("UPI", "Net Banking", "Credit Card", "Debit Card");
    }


    @PostMapping("/netbanking")
    public String netBanking(@RequestBody NetBankingInfo netBankingInfo){
        logger.info("Request for Nat Banking Payment ");

        return "Payment Success.";
    }
    // Credit Card

    //Debit Card

}