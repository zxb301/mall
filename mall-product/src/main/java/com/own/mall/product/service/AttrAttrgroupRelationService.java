package com.own.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.own.common.utils.PageUtils;
import com.own.mall.product.entity.AttrAttrgroupRelationEntity;

import java.util.Map;

/**
 * 属性&属性分组关联
 *
 * @author zxb
 * @email 
 * @date 2020-04-10 11:45:57
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

