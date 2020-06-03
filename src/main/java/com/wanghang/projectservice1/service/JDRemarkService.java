package com.wanghang.projectservice1.service;

import com.google.common.collect.Lists;
import com.wanghang.projectsdk.base.entity.Remark;
import com.wanghang.projectsdk.base.enumeration.ProductSourceType;
import com.wanghang.projectsdk.base.enumeration.ProductType;
import com.wanghang.projectsdk.base.enumeration.StateFlagType;
import com.wanghang.projectsdk.third.controller.IRemarkController;
import com.wanghang.projectsdk.third.service.AbstractRemarkService;
import com.wanghang.projectservice1.model.JDProduct;
import com.wanghang.projectservice1.model.JDRemark;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author wanghang
 * 2020/5/26
 **/
@Service
public class JDRemarkService extends AbstractRemarkService<JDRemark> {

    @Override
    protected List<JDRemark> getThirdListByProductNoAndSkipAndLimit(String productNo, Integer skip, Integer limit) {
        // TODO 调京东接口-MongoDB模拟
        List<JDRemark> list = Lists.newArrayList();
        for (int i = 0; i < limit; i++) {
            list.add(mockJDRemark());
        }
        return list;
    }

    @Override
    protected Remark convertThird(JDRemark jdRemark) {
        Remark remark = new Remark();
        remark.setNo(jdRemark.getJd_no());
        remark.setUserNo(jdRemark.getJd_userNo());
        remark.setOrderNo(jdRemark.getJd_orderNo());
        remark.setProductNo(jdRemark.getJd_productNo());
        remark.setProductSource(ProductSourceType.JINGDONG.getKey());
        remark.setProductName(jdRemark.getJd_productName());
        remark.setStar(jdRemark.getJd_star());
        remark.setStateFlag(jdRemark.getJd_stateFlag());
        remark.setContent(jdRemark.getJd_content());
        remark.setCreateTime(jdRemark.getJd_createTime());
        remark.setUpdateTime(jdRemark.getJd_updateTime());

        return remark;
    }

    @Override
    protected JDRemark convertToThird(Remark remark) {
        JDRemark jdRemark = new JDRemark();
        jdRemark.setJd_orderNo(remark.getOrderNo());
        jdRemark.setJd_productName(remark.getProductName());
        jdRemark.setJd_productNo(remark.getProductNo());
        jdRemark.setJd_star(remark.getStar());
        jdRemark.setJd_stateFlag(remark.getStateFlag());
        jdRemark.setJd_updateTime(remark.getUpdateTime());
        jdRemark.setJd_userNo(remark.getUserNo());
        jdRemark.setJd_content(remark.getContent());
        jdRemark.setJd_createTime(remark.getCreateTime());
        return jdRemark;
    }

    @Override
    protected String remarkThird(JDRemark jdRemark) {
        // TODO 调京东接口-MongoDB模拟
        jdRemark.setJd_id(46546846464L);
        jdRemark.setJd_no(UUID.randomUUID().toString());
        jdRemark.setJd_createTime(new Date());
        jdRemark.setJd_updateTime(new Date());
        return jdRemark.getJd_no();
    }

    private JDRemark mockJDRemark() {
        JDRemark jdRemark = new JDRemark();
        jdRemark.setJd_id(545265451654L);
        jdRemark.setJd_no("a6sg4s646g4s6af4a4af");
        jdRemark.setJd_userNo("aljflasjfaf4a6f4f");
        jdRemark.setJd_orderNo("a6s4fda64fas4fsf4af54f");
        jdRemark.setJd_productName("联想(Lenovo)天逸510S 英特尔酷睿i5 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)23英寸");
        jdRemark.setJd_productNo("6a5g5165f5gd5565g4g");
        jdRemark.setJd_star(new BigDecimal("4.5"));
        jdRemark.setJd_content("美帝良心想还是香，就是太笨重了，性能还行吧能用几年");
        jdRemark.setJd_stateFlag(StateFlagType.VALID.getKey());
        jdRemark.setJd_createTime(new Date());
        jdRemark.setJd_updateTime(new Date());

        return jdRemark;
    }
}
