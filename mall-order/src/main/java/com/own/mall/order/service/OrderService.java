package com.own.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.own.common.utils.PageUtils;
import com.own.mall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author zxb
 * @email 
 * @date 2020-04-10 14:53:36
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

