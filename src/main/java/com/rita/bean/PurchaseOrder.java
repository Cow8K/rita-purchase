package com.rita.bean;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by LiuSheng at 2024/12/30 22:46
 */

@Data
public class PurchaseOrder {

    /**
     * 采购标识
     */
    private Integer id;

    /**
     * 采购编号
     */
    private String orderNumber;

    /**
     * 实际支付
     */
    private Double realPaid;

    /**
     * 供应商
     */
    private String supplier;

    /**
     * 采购地址
     */
    private String address;

    /**
     * 采购备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 采购账号
     */
    private String account;

    /**
     * 采购明细
     */
    private PurchaseOrderItem purchaseOrderItem;
}
