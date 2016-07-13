package com.ai.baas.bmc.service.business.interfaces;

import java.util.List;

import com.ai.baas.bmc.api.drmanager.parameters.BillQueryInputObject;
import com.ai.baas.bmc.dao.mapper.bo.BmcQueryBill; 
import com.ai.baas.bmc.api.drmanager.parameters.BillQueryOutputObject;

public interface IQueryBillSvc {
    public List<BmcQueryBill> selectBillQuery(BillQueryInputObject billObject);
    
    public Integer getBillCount(BillQueryInputObject billObject);
    
    public BillQueryOutputObject billQueryObj(BillQueryInputObject billQueryInput);
}
