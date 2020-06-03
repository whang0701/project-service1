package com.wanghang.projectservice1.model;



import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class JDRemark {
    private Long jd_id;

    private String jd_no;

    private String jd_userNo;

    private String jd_orderNo;

    private String jd_productNo;

    private String jd_productName;

    private BigDecimal jd_star;

    private Integer jd_stateFlag;

    private Date jd_createTime;

    private Date jd_updateTime;

    private String jd_content;



}