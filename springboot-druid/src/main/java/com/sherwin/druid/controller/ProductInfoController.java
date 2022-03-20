package com.sherwin.druid.controller;

import com.sherwin.druid.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/* @description: 获取产品列表
 * @author: Sherwin Liang
 * @timestamp: 2022/3/20 10:48
*/
@Controller
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    @RequestMapping("/")
    public ModelAndView lists() {
        return new ModelAndView("/list","products", productInfoService.getProducts());
    }

    @RequestMapping("/map")
    public ModelAndView toMap() {
        return new ModelAndView("/list2","products", productInfoService.getProductsMap());
    }
}
