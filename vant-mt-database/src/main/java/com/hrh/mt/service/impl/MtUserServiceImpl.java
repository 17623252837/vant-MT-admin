package com.hrh.mt.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hrh.mt.mapper.MtUserMapper;
import com.hrh.mt.service.MtUserService;
@Service
public class MtUserServiceImpl implements MtUserService{

    @Resource
    private MtUserMapper mtUserMapper;

}
