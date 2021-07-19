package com.feidian.mapper;

import com.feidian.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface GoodsMapper {

    int setInventory(Goods goods);

    List<Goods> findAllGoods();

    Goods findGoodById(int id);
}
