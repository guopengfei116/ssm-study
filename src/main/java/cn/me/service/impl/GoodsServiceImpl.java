package cn.me.service.impl;

import cn.me.dao.GoodsDao;
import cn.me.model.Goods;
import cn.me.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    /**
     * 获取商品列表
     */
    @Override
    public List<Goods> findAllGoods() {
        return goodsDao.findAllGoods();
    }

    /**
     * 获取指定商品
     *
     * @param id
     */
    @Override
    public Goods findGoodsById(int id) {
        return goodsDao.findGoodsById(id);
    }

    /**
     * 模糊搜索商品
     *
     * @param name
     */
    @Override
    public List<Goods> findGoodsByName(String name) {
        return goodsDao.findGoodsByName(name);
    }

    /**
     * 修改商品数据，保存数据库
     *
     * @param goods
     */
    @Override
    public void updateGoodsById(Goods goods) {
        goodsDao.updateGoodsById(goods);
    }
}
