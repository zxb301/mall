package com.own.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.own.common.utils.PageUtils;
import com.own.mall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author zxb
 * @email 
 * @date 2020-04-10 11:45:57
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

