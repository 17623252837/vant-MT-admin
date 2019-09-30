package com.hrh.mt.api;

import com.hrh.mt.common.utils.BaseResult;
import com.hrh.mt.service.MtSwapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwapperController {
    @Autowired
    private MtSwapperService mtSwapperService;

    @GetMapping("/v1/swapper/all")
    BaseResult getSwapperS(){
        return mtSwapperService.getSwappers();
    }
}
