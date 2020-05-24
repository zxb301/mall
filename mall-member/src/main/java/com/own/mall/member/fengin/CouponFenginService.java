package com.own.mall.member.fengin;

import com.own.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("mall-coupon")
public interface CouponFenginService {
    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons() ;
}
