package com.own.mall.order.dao;

import com.own.mall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author zxb
 * @email 
 * @date 2020-04-10 14:53:36
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
