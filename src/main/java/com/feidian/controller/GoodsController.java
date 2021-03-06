package com.feidian.controller;

import com.feidian.mapper.BuyerMapper;
import com.feidian.mapper.GoodsMapper;
import com.feidian.mapper.OrderMapper;
import com.feidian.pojo.Buy;
import com.feidian.pojo.Buyer;
import com.feidian.pojo.Goods;
import com.feidian.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    BuyerMapper buyerMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    OrderMapper orderMapper;

    @GetMapping("findAllGoods")
    public List<Goods> findAllGoods(){
        return goodsMapper.findAllGoods();
    }


    @PostMapping("/setInventory")
    public int setInventory(@RequestBody Goods goods){
        goodsMapper.setInventory(goods);

        //检查是否修改成功
        Goods good = goodsMapper.findGoodById(goods.getGoodId());
        if(good.getGoodInventory() == goods.getGoodInventory()){
            return 1;
        }else {
            return 0;
        }
    }

    @PostMapping("/buy")
    public int buy(@RequestBody Buy buy){
        List<Order> order = buy.getOrder();
        for (Order order1 : order) {
            System.out.println(order1);
        }
        Buyer buyer = buyerMapper.findBuyerById(buy.getBuyerId());

        for (Order order1 : order) {

            Goods goods = goodsMapper.findGoodById(order1.getGoodId());
            int inventory = goods.getGoodInventory();
            int quantity = order1.getGoodQuantity();
            if (inventory < quantity) {//判断库存
                return 0;
            }

            //商品数量减少
            goods.setGoodInventory(inventory - quantity);
            goodsMapper.setInventory(goods);

            //创建订单
            order1.setOrderId(0);
            order1.setDetailId(0);

            order1.setBuyerId(buyer.getBuyerId());
            order1.setBuyerAddress(buy.getBuyerAddress());
            order1.setBuyerName(buyer.getBuyerName());
            order1.setGoodPrice(goods.getGoodPrice());
            order1.setGoodId(goods.getGoodId());
            order1.setGoodName(goods.getGoodName());
            order1.setGoodQuantity(order1.getGoodQuantity());

            orderMapper.addOrderDetail(order1);
            orderMapper.addOrderMaster(order1);
        }
        return 1;
    }
}
