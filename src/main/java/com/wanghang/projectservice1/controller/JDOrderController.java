package com.wanghang.projectservice1.controller;


import com.wanghang.projectsdk.base.entity.Order;
import com.wanghang.projectsdk.base.entity.Product;
import com.wanghang.projectsdk.third.controller.IOrderController;
import com.wanghang.projectsdk.third.controller.IProductController;
import com.wanghang.projectservice1.model.JDOrder;
import com.wanghang.projectservice1.service.JDOrderService;
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
public class JDOrderController implements IOrderController {
    @Autowired
    private JDOrderService jdOrderService;


    @Override
    public String doPlace(Order order) {
        return jdOrderService.doPlace(order);
    }

    @Override
    public Integer doReceive(String no) {
        return jdOrderService.doReceive(no);
    }

    @Override
    public Integer doRemark(String no) {
        return jdOrderService.doRemark(no);
    }

    @Override
    public Integer doRefund(String no, String desc) {
        return jdOrderService.doRefund(no, desc);
    }
}
