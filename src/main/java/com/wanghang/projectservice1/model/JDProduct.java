package com.wanghang.projectservice1.model;



import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class JDProduct {
    private Long jd_id;

    private String jd_no;

    private String jd_name;

    private Integer jd_type;

    private String jd_brand;

    private BigDecimal jd_price;

    private String jd_img0;

    private String jd_img1;

    private String jd_img2;

    private BigDecimal jd_star;

    private String jd_store;

    private String jd_address;

    private String jd_tags;

    private Date jd_birth;

    private Date jd_createTime;

    private Date jd_updateTime;

    private String jd_desc;


}