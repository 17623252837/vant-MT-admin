package com.hrh.mt.service.impl;

import com.hrh.mt.mapper.MtUserMapper;
import com.hrh.mt.service.MtUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MtUserServiceImpl implements MtUserService{

    @Resource
    private MtUserMapper mtUserMapper;

}
