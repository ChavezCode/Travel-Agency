package com.example.demo.controllers;

import com.example.demo.services.CheckOutService;
import com.example.demo.services.Purchase;
import com.example.demo.services.PurchaseResponse;
import org.springframework.web.bind.annotation.*;

@CrossOrigin

@RestController
@RequestMapping("/api/checkout")
public class CheckOutController {


    private CheckOutService checkOutService;

    public CheckOutController(CheckOutService checkOutService) {
        this.checkOutService = checkOutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        PurchaseResponse purchaseResponse = checkOutService.placeOrder(purchase);

        return purchaseResponse;
    }
}
