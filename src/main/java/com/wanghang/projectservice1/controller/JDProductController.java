package com.wanghang.projectservice1.controller;


import com.wanghang.projectsdk.base.entity.Product;
import com.wanghang.projectsdk.third.controller.IProductController;
import com.wanghang.projectservice1.service.JDProductService;
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
public class JDProductController implements IProductController {
    @Autowired
    private JDProductService jdProductService;

    @Override
    public List<Product> getListByRandom(Integer num) {
        return jdProductService.getListByRandom(num);
    }

    @Override
    public Product getOneByNo(String no) {
        return jdProductService.getOneByNo(no);
    }
}
