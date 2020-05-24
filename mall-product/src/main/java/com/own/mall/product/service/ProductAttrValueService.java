package com.own.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.own.common.utils.PageUtils;
import com.own.mall.product.entity.ProductAttrValueEntity;

import java.util.Map;

/**
 * spu属性值
 *
 * @author zxb
 * @email 
 * @date 2020-04-10 11:45:57
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

