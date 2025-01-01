package com.rita.bean;

import lombok.Data;

/**
 * Created by LiuSheng at 2024/12/30 22:47
 */

@Data
public class PurchaseOrderItem {

    /**
     * 采购明细标识
     */
    private int item_id;

    /**
     * 采购编号
     */
    private int order_number;

    /**
     * 产品SKU
     */
    private int sku;

    /**
     * 价格
     */
    private int price;

    /**
     * 采购数量
     */
    private int quantity;
}
