package com.wanghang.projectservice1.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class JDOrder {
    private Long jd_id;

    private String jd_no;

    private String jd_userNo;

    private String jd_productNo;

    private Integer jd_num;

    private BigDecimal jd_totalPrice;

    private Integer jd_status;

    private String jd_receiverName;

    private String jd_receiverPhone;

    private String jd_receiverAddress;

    private String jd_desc;
}