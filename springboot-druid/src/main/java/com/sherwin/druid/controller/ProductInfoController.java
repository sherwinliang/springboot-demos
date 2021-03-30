package com.sherwin.druid.controller;

import com.sherwin.druid.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Haoxy on 2019-06-25.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
@Controller
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    @RequestMapping("/")
    public ModelAndView lists() {
        return new ModelAndView("/list","products", productInfoService.getProducts());
    }
}
