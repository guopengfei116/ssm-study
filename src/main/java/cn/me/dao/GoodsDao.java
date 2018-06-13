package cn.me.dao;

import cn.me.model.Goods;

import java.util.List;

public interface GoodsDao {
    /**
     * 获取商品列表
     * */
    List<Goods> findAllGoods();

    /**
     * 获取指定商品
     * */
    Goods findGoodsById(int id);

    /**
     * 模糊搜索商品
     * */
    List<Goods> findGoodsByName(String name);

    /**
     * 修改商品数据，保存数据库
     */
    void updateGoodsById(Goods goods);
}
