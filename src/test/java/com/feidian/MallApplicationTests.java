package com.feidian;

import com.feidian.mapper.GoodsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MallApplicationTests {

    @Autowired
    GoodsMapper goodsMapper;

    @Test
    void contextLoads() {
        System.out.println(goodsMapper.findGoodById(1));

    }

}
