package com.feidian.mapper;

import com.feidian.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    int addOrderDetail(Order order);

    int addOrderMster(Order order);
}
