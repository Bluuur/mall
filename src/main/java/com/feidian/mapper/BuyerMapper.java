package com.feidian.mapper;

import com.feidian.pojo.Buyer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BuyerMapper {
    int register(Buyer buyer);

    List<Buyer> findAllBuyer();

    Buyer findBuyerById(int id);
}
