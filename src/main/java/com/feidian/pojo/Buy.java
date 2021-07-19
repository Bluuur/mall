package com.feidian.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buy {

    private Integer buyerId;
    private String buyerAddress;
    private List<Order> order;
}
