package com.feidian.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    private Integer goodId;
    private String goodName;
    private Double goodPrice;
    private Integer goodInventory;

}
