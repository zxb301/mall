package com.own.mall.coupon.config;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Value("${spring.redis.host}")
    private String address;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.port}")
    private String port;

    @Bean
    public Redisson redissonSingle(){
        Config config = new Config();
        //支持Single单机，Master/Slave 主从，Sentinel哨兵，Cluster集群等模式
        //此为单机模式
        config.useSingleServer()
                //地址须使用“redis://”前缀，否则将会报错。
                .setAddress("redis://"+address+":"+port)
               // .setPassword("123456")
                .setTimeout(3000);

        return (Redisson) Redisson.create(config);
        //集群模式,集群节点的地址须使用“redis://”前缀，否则将会报错。
        //此例集群为3节点，各节点1主1从
//        config.useClusterServers().addNodeAddress("redis://192.168.37.134:7001","redis://192.168.37.134:7002",
//                "redis://192.168.37.134:7003","redis://192.168.37.134:7004","redis://192.168.37.134:7005","redis://192.168.37.134:7006");
//        return (Redisson) Redisson.create(config);
    }

}
