package com.feidian.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer orderId;
    private Integer detailId;
    private Integer buyerId;
    private String buyerName;
    private String buyerAddress;
    private Double goodPrice;
    private Integer goodId;
    private String goodName;
    private Integer goodQuantity;

}
