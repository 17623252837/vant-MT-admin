package com.hrh.mt.service;

/**
 * @ProjectName: buy
 * @Package: xiaoyoupai.buy.service
 * @ClassName: RedisService
 * @Author: break
 * @Description: redis
 * @Date: 2019/7/24 0024 下午 20:43
 * @Version: 1.0
 */

public interface RedisService {
    /**
     * @Method put
     * @Author hrh
     * @Version  1.0
     * @Description
     * @Return
     * @Exception
     * @Date 2019/5/12 0012 下午 14:14
     */
    public void put(String key, Object value, long seconds);

    /**
     * @Method get
     * @Author hrh
     * @Version  1.0
     * @Description
    No such property: code for class: Script1
     * @Return
     * @Exception
     * @Date 2019/5/12 0012 下午 14:15
     */
    public Object get(String key);
}
