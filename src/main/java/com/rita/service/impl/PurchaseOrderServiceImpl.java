package com.rita.service.impl;

import com.rita.bean.PurchaseOrder;
import com.rita.mapper.PurchaseOrderMapper;
import com.rita.query.PurchaseOrderQuery;
import com.rita.service.PurchaseOrderService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * Created by LiuSheng at 2024/12/30 23:37
 */

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Resource
    private PurchaseOrderMapper purchaseOrderMapper;

    @Override
    public List<PurchaseOrder> queryPurchaseOrders(PurchaseOrderQuery purchaseOrderQuery) {
        List<PurchaseOrder> purchaseOrderList = purchaseOrderMapper.queryPurchaseOrders(purchaseOrderQuery);
        return CollectionUtils.isEmpty(purchaseOrderList) ? Collections.emptyList() : purchaseOrderList;
    }
}
