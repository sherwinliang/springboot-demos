package com.sherwin.druid.service;

import com.sherwin.druid.entity.ProductInfoModel;
import com.sherwin.druid.mapper.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/* @description: 产品业务层
 * @author: Sherwin Liang
 * @timestamp: 2022/3/20 10:49
*/
@Service
public class ProductInfoService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    public List<ProductInfoModel> getProducts() {
        List<ProductInfoModel> products = productInfoMapper.getProducts();
        return products;
    }

    public List<Map<String, Object>> getProductsMap() {
        List<Map<String, Object>> products = productInfoMapper.getProductsMap(9);
        return products;
    }
}
