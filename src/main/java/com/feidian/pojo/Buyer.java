package com.feidian.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buyer {

    private Integer buyerId;
    private String buyerName;
    private String buyerAddress;
}
