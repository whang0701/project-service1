package com.wanghang.projectservice1.service;

import com.wanghang.projectsdk.base.entity.Order;
import com.wanghang.projectsdk.base.enumeration.OrderStatusType;
import com.wanghang.projectsdk.third.service.AbstractOrderService;
import com.wanghang.projectservice1.model.JDOrder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author wanghang
 * 2020/5/26
 **/
@Service
public class JDOrderService extends AbstractOrderService<JDOrder> {

    @Override
    protected JDOrder convertToThird(Order order) {
        JDOrder jdOrder = new JDOrder();
        jdOrder.setJd_num(order.getNum());
        jdOrder.setJd_productNo(order.getProductNo());
        jdOrder.setJd_desc(order.getDesc());
        jdOrder.setJd_receiverAddress(order.getReceiverAddress());
        jdOrder.setJd_receiverName(order.getReceiverName());
        jdOrder.setJd_receiverPhone(order.getReceiverPhone());
        jdOrder.setJd_status(order.getStatus());
        jdOrder.setJd_totalPrice(order.getTotalPrice());
        jdOrder.setJd_userNo(order.getUserNo());
        jdOrder.setJd_no(order.getNo());

        return jdOrder;
    }

    @Override
    protected String placeThirdOrder(JDOrder jdOrder) {
        // TODO 调京东接口-MongoDB模拟
        return mockDoPlace(jdOrder).getJd_no();
    }

    private JDOrder mockDoPlace(JDOrder jdOrder) {
        jdOrder.setJd_id(132L);
        jdOrder.setJd_no(UUID.randomUUID().toString());
        jdOrder.setJd_status(OrderStatusType.BEFORE_DELIVERY.getKey());

        return jdOrder;
    }

    @Override
    public Integer doReceive(String no) {
        // TODO 调京东接口-MongoDB模拟
        JDOrder jdOrder = new JDOrder();
        jdOrder.setJd_no(no);
        jdOrder.setJd_status(OrderStatusType.RCEIVED.getKey());
        return jdOrder.getJd_status();
    }

    @Override
    public Integer doRemark(String no) {
        // TODO 调京东接口-MongoDB模拟
        JDOrder jdOrder = new JDOrder();
        jdOrder.setJd_no(no);
        jdOrder.setJd_status(OrderStatusType.REMARKED.getKey());
        return jdOrder.getJd_status();
    }

    @Override
    public Integer doRefund(String no, String desc) {
        // TODO 调京东接口-MongoDB模拟
        JDOrder jdOrder = new JDOrder();
        jdOrder.setJd_no(no);
        jdOrder.setJd_desc(desc);
        jdOrder.setJd_status(OrderStatusType.REFUNDIND.getKey());
        return jdOrder.getJd_status();
    }
}
