package com.sherwin.druid.service;

import com.sherwin.druid.entity.ProductInfoModel;
import com.sherwin.druid.mapper.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Haoxy on 2019-06-25.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
@Service
public class ProductInfoService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    public List<ProductInfoModel> getProducts() {
        return productInfoMapper.getProducts();
    }
}
