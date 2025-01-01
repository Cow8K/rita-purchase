package com.rita.mapper;

import com.rita.bean.PurchaseOrder;
import com.rita.query.PurchaseOrderQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by LiuSheng at 2024/12/30 23:36
 */


public interface PurchaseOrderMapper {
    List<PurchaseOrder> queryPurchaseOrders(@Param("query") PurchaseOrderQuery purchaseOrderQuery);
}
