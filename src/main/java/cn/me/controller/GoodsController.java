package cn.me.controller;

import cn.me.model.Goods;
import cn.me.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/list.do")
    public ModelAndView list() {
        // 1.查询商品数据
        List<Goods> list = goodsService.findAllGoods();

        // 2.响应商品模型数据
        ModelAndView mv = new ModelAndView();
        mv.addObject("list", list);
        mv.setViewName("goods/list");

        return mv;
    }

    /**
     * 使用简单类型接收请求的参数数据，推荐使用简单类型的包装类型, 比如int使用Integer接受
     * 原因是基础类型不能为null， 如果没有值会报异常。
     * */
    @RequestMapping("/query.do")
    public ModelAndView queryById(String name) {
        // 1.查询商品数据
        List<Goods> list = goodsService.findGoodsByName(name);

        // 2.响应商品模型数据
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", name);
        mv.addObject("list", list);
        mv.setViewName("goods/list");

        return mv;
    }

    /**
     * Model是一个接口，是模型，用于设置响应的模型数据。
     * ModelMap是一个实现类，使用Model和使用ModelMap是一样的。如果使用Model，springmvc会实例化成ModelMap。
     * 使用Model响应模型数据，就可以不使用ModelAndView，视图可以使用字符串String响应。
     */
    @RequestMapping("/edit.do")
    public String edit(Model model, Integer id) {
        // 1.查询商品数据
        Goods goods = goodsService.findGoodsById(id);

        // 2.响应商品模型数据
        model.addAttribute("goods", goods);

        return "goods/edit";
    }

    /**
     * 使用pojo类型来接收请求的多个参数数据
     *
     * 重定向是告知浏览器如何跳转，url需要按照浏览器的方式运行
     * */
    @RequestMapping("/update.do")
    public String update(Integer id, String name, Double price, String detail) {

        // 创建商品对象
        Goods goods = new Goods();
        goods.setId(id);
        goods.setName(name);
        goods.setPrice(price);
        goods.setDetail(detail);

        goodsService.updateGoodsById(goods);

        return "redirect:/goods/list.do";
    }

}
