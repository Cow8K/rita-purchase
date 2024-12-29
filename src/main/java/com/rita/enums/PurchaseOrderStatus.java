package com.rita.enums;

/**
 * Created by LiuSheng at 2024/12/29 21:57
 */


public enum PurchaseOrderStatus implements Enums{

    PAID("已下单", 1),

    STORED("已入口", 2),

    TRIPPING("在途", 3);

    private final String desc;
    private final Integer code;

    PurchaseOrderStatus(String desc, Integer code) {
        this.desc = desc;
        this.code = code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    public PurchaseOrderStatus build(String desc) {
        switch (desc) {
            case "已下单":
                return PurchaseOrderStatus.PAID;
            case "已入口":
                return PurchaseOrderStatus.STORED;
            case "在途":
                return PurchaseOrderStatus.TRIPPING;
            default:
                return null;
        }
    }

    public PurchaseOrderStatus build(Integer code) {
        switch (code) {
            case 1:
                return PurchaseOrderStatus.PAID;
            case 2:
                return PurchaseOrderStatus.STORED;
            case 3:
                return PurchaseOrderStatus.TRIPPING;
            default:
                return null;
        }
    }
}
