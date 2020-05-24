package com.own.mall.product.dao;

import com.own.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author zxb
 * @email 
 * @date 2020-04-10 11:45:57
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
