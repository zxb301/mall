package com.own.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.own.common.utils.PageUtils;
import com.own.mall.coupon.entity.CouponHistoryEntity;

import java.util.Map;

/**
 * 优惠券领取历史记录
 *
 * @author zxb
 * @email 
 * @date 2020-04-10 14:44:29
 */
public interface CouponHistoryService extends IService<CouponHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

