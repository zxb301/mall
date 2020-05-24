package com.own.mall.coupon;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.own.mall.coupon.component.redissonLock.RedisLockUtil;

import com.own.mall.coupon.entity.CouponEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MallCouponApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 锁测试共享变量
     */
    private Integer lockCount = 10;

    /**
     * 无锁测试共享变量
     */
    private Integer count = 10;

    /**
     * 模拟线程数
     */
    private static int threadNum = 10;

    /**
     * 模拟并发测试加锁和不加锁
     * @return
     */
    @Test
    public void lock(){
        // 计数器
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < threadNum; i ++) {
            MyRunnable myRunnable = new MyRunnable(countDownLatch);
            Thread myThread = new Thread(myRunnable);
            myThread.start();
        }
        // 释放所有线程
        countDownLatch.countDown();
    }

    /**
     * 加锁测试
     */
    private void testLockCount() {
        String lockKey = "lock-test";
        try {
            // 加锁，设置超时时间2s
            RedisLockUtil.lock(lockKey,2, TimeUnit.SECONDS);
            lockCount--;
            log.info("lockCount值："+lockCount);
            System.out.println("lockCount值："+lockCount);
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }finally {
            // 释放锁
            RedisLockUtil.unlock(lockKey);
        }
    }
    public class MyRunnable implements Runnable {
        /**
         * 计数器
         */
        final CountDownLatch countDownLatch;

        public MyRunnable(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                // 阻塞当前线程，直到计时器的值为0
                countDownLatch.await();
            } catch (InterruptedException e) {
                log.error(e.getMessage(),e);
            }

            // 加锁操作
            testLockCount();
        }

    }

    @Test
    public void redis(){
    /*    List list = new ArrayList(2);

        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCode("1");
        CouponEntity couponEntity1 = new CouponEntity();
        couponEntity1.setCode("2");
        list.add(couponEntity);
        list.add(couponEntity1);
        redisTemplate.opsForList().leftPushAll("list",list);
        redisTemplate.opsForValue().set("test",couponEntity);
        CouponEntity test = (CouponEntity)redisTemplate.opsForValue().get("test");
        System.out.println(test);
        Map map = new HashMap();
        map.put("name",couponEntity);
        map.put("name1",couponEntity1);
        redisTemplate.opsForHash().putAll("k1",map);
        CouponEntity o = (CouponEntity)redisTemplate.opsForHash().get("k1", "name");

        Map k1 = redisTemplate.opsForHash().entries("k1");
        System.out.println(k1);
        System.out.println(o.toString());

        List<CouponEntity> list2 = redisTemplate.opsForList().range("list",0,-1);
        for (CouponEntity entity : list2) {
            System.out.println(entity.getCode());
        }*/

        //redisTemplate.opsForSet().add("k2", list);
      /*  Set<CouponEntity> members = redisTemplate.opsForSet().members("k2");
        for (CouponEntity member : members) {
            System.out.println(member.toString());
        }*/
        String[] strs= new String[]{"str1","str2"};
        redisTemplate.opsForSet().add("games", "鬼泣", "古墓丽影", "仙剑奇侠传", "LOL", "DOTA自走棋" );
        redisTemplate.opsForSet().add("games",strs );
        System.out.println(redisTemplate.opsForSet().members("games"));

    }
}
