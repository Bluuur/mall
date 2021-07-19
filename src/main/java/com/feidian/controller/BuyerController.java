package com.feidian.controller;

import com.feidian.mapper.BuyerMapper;
import com.feidian.pojo.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("buyer")
public class BuyerController {

    @Autowired
    BuyerMapper buyerMapper;

    @PostMapping("/register")
    public int regester(@RequestBody Buyer buyer) {
        return buyerMapper.register(buyer);
    }

}