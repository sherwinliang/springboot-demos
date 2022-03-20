package com.sherwin.druid.mapper;

import com.sherwin.druid.entity.ProductInfoModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/* @description: mybatis的mapper层
 * @author: Sherwin Liang
 * @timestamp: 2022/3/20 10:49
*/
public interface ProductInfoMapper {
    /* @description: 正常查询全量列表
     * @author: Sherwin Liang
     * @timestamp: 2022/3/20 13:38
    */
    List<ProductInfoModel> getProducts();
    /* @description: 关联查询并返回java map
     * @author: Sherwin Liang
     * @timestamp: 2022/3/20 13:38
     * @param: mapFlag 标志描述
     * @return: List<Map<String, Object>>
    */
    List<Map<String, Object>> getProductsMap(@Param("mapFlag") Integer mapFlag);
}
