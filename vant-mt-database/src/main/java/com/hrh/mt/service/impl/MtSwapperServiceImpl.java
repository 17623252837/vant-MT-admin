package com.hrh.mt.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hrh.mt.mapper.MtSwapperMapper;
import com.hrh.mt.service.MtSwapperService;
@Service
public class MtSwapperServiceImpl implements MtSwapperService{

    @Resource
    private MtSwapperMapper mtSwapperMapper;

}
