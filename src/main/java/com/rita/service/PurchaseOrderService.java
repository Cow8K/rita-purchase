package com.rita.service;

import com.rita.bean.PurchaseOrder;
import com.rita.model.PCAList;
import com.rita.model.Students;
import com.rita.query.PurchaseOrderQuery;

import java.util.List;
import java.util.Map;

public interface PurchaseOrderService {
	List<PurchaseOrder> queryPurchaseOrders(PurchaseOrderQuery purchaseOrderQuery);
}
