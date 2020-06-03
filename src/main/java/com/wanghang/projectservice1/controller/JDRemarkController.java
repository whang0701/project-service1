package com.wanghang.projectservice1.controller;


import com.wanghang.projectsdk.base.entity.Product;
import com.wanghang.projectsdk.base.entity.Remark;
import com.wanghang.projectsdk.third.controller.IProductController;
import com.wanghang.projectsdk.third.controller.IRemarkController;
import com.wanghang.projectservice1.service.JDProductService;
import com.wanghang.projectservice1.service.JDRemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author wanghang
 * @Date 2020/4/8
 **/
@RestController
@RequestMapping("/jingdong")
public class JDRemarkController implements IRemarkController {
    @Autowired
    private JDRemarkService jdRemarkService;

    @Override
    public List<Remark> getListByProductNoAndSkipAndLimit(String productNo, Integer skip, Integer limit) {
        return jdRemarkService.getListByProductNoAndSkipAndLimit(productNo, skip, limit);
    }

    @Override
    public String doRemark(Remark remark) {
        return jdRemarkService.doRemark(remark);
    }
}
