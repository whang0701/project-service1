package com.wanghang.projectservice1.service;

import com.google.common.collect.Lists;
import com.wanghang.projectsdk.base.entity.Product;
import com.wanghang.projectsdk.base.enumeration.ProductSourceType;
import com.wanghang.projectsdk.base.enumeration.ProductType;
import com.wanghang.projectsdk.third.controller.IProductController;
import com.wanghang.projectsdk.third.service.AbstractProductService;
import com.wanghang.projectservice1.model.JDProduct;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * @author wanghang
 * 2020/5/26
 **/
@Service
public class JDProductService extends AbstractProductService<JDProduct> {

    @Override
    protected List<JDProduct> getThirdListByRandom(Integer num) {
        // TODO 调京东接口-MongoDB模拟
        List<JDProduct> list = Lists.newArrayList();
        for (int i = 0; i < num; i++) {
            list.add(mockJDProduct());
        }
        return list;
    }

    @Override
    protected JDProduct getThirdOneByNo(String no) {
        // TODO 调京东接口-MongoDB模拟
        JDProduct jdProduct = mockJDProduct();
        jdProduct.setJd_no(no);
        return jdProduct;
    }

    @Override
    protected Product convertThird(JDProduct jdProduct) {
        Product product = new Product();
        product.setNo(jdProduct.getJd_no());
        product.setSource(ProductSourceType.JINGDONG.getKey());
        product.setSourceName(ProductSourceType.JINGDONG.getValue());
        product.setName(jdProduct.getJd_name());
        product.setType(jdProduct.getJd_type());
        ProductType type = ProductType.getType(jdProduct.getJd_type());
        product.setTypeName(Objects.nonNull(type)? type.getValue() : "其它");
        product.setBrand(jdProduct.getJd_brand());
        product.setPrice(jdProduct.getJd_price());
        product.setImg0(jdProduct.getJd_img0());
        product.setImg1(jdProduct.getJd_img1());
        product.setImg2(jdProduct.getJd_img2());
        product.setStar(jdProduct.getJd_star());
        product.setStore(jdProduct.getJd_store());
        product.setAddress(jdProduct.getJd_address());
        product.setTags(Lists.newArrayList(jdProduct.getJd_tags().split("，")));
        product.setDesc(jdProduct.getJd_desc());
        product.setBirth(jdProduct.getJd_birth());

        return product;
    }

    private JDProduct mockJDProduct() {
        JDProduct jdProduct = new JDProduct();
        jdProduct.setJd_id(545265451654L);
        jdProduct.setJd_no("a6sg4s646g4s6af4a4af");
        jdProduct.setJd_name("联想(Lenovo)天逸510S 英特尔酷睿i5 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)23英寸");
        jdProduct.setJd_address("中国大陆");
        jdProduct.setJd_brand("联想（Lenovo）");
        try {
            jdProduct.setJd_birth(DateUtils.parseDate("2019-07-01", Locale.CHINA, "yyyy-MM-dd"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jdProduct.setJd_createTime(new Date());
        jdProduct.setJd_desc("搭载第九代酷睿处理器，更多线程让多任务处理更轻松。16GB大容量内存，大幅度提升效率。小体积机箱搭载无线网卡，小空间轻松安放。" +
                "高速双硬盘，随享高速读写与海量存储。接口丰富。80万小时稳定测试。搭配显示器，整机更更省心。三年上门保修服务。");
        jdProduct.setJd_img0("gateway/upload/img/product/4f65as4fsa4f6sa4f65f4676a5s4fs.png");
        jdProduct.setJd_img1("gateway/upload/img/product/20200527004233.png");
        jdProduct.setJd_img2("gateway/upload/img/product/20200527004407.png");
        jdProduct.setJd_price(new BigDecimal("4499.00"));
        jdProduct.setJd_star(new BigDecimal("3.7"));
        jdProduct.setJd_store("联想京东自营旗舰店");
        jdProduct.setJd_tags("九代酷睿，京东秒杀，现货");
        jdProduct.setJd_type(ProductType.PC.getKey());
        jdProduct.setJd_updateTime(new Date());

        return jdProduct;
    }
}
