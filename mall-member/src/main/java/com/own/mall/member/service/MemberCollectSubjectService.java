package com.own.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.own.common.utils.PageUtils;
import com.own.mall.member.entity.MemberCollectSubjectEntity;

import java.util.Map;

/**
 * 会员收藏的专题活动
 *
 * @author zxb
 * @email 
 * @date 2020-04-10 14:50:08
 */
public interface MemberCollectSubjectService extends IService<MemberCollectSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

