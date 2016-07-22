package com.ai.opt.baas.bmc.test.api.queryidinfo.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.queryidinfo.params.AcctIdInfo;
import com.ai.baas.bmc.api.queryidinfo.params.BlAcctInfoInfo;
import com.ai.baas.bmc.api.queryidinfo.params.BlCustinfoInfo;
import com.ai.baas.bmc.api.queryidinfo.params.ExtCustIdInfo;
import com.ai.baas.bmc.api.queryidinfo.params.OwnerIDInfo;
import com.ai.baas.bmc.service.atom.interfaces.IQueryIdInfoAtomSV;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class QueryIdInfoTest {
    @Autowired
    private IQueryIdInfoAtomSV iQueryIdInfoAtomSV;
    @Autowired
    private com.ai.baas.bmc.service.business.interfaces.IQueryIdInfoBusiSV IQueryIdInfoBusiSV;

    @Test
    public void queryTest() {
        OwnerIDInfo ownerIDInfo = new OwnerIDInfo();
        ownerIDInfo.setOwnerId("101");
        ownerIDInfo.setTenantId("VIV-BYD");
        List<BlAcctInfoInfo> queryBlAcctInfo = iQueryIdInfoAtomSV.queryBlAcctInfo(ownerIDInfo);
        System.out.println(queryBlAcctInfo);
    }
    @Test
    public void queryTest1() {
        
        ExtCustIdInfo extCustIdInfo=new ExtCustIdInfo();
        extCustIdInfo.setExtCustId("asiainfo");
        extCustIdInfo.setTenantId("VIV-BYD");
        List<BlCustinfoInfo> queryBlCustinfo = iQueryIdInfoAtomSV.queryBlCustinfo(extCustIdInfo);
       System.out.println(queryBlCustinfo);
    }
    @Test
    public void queryTest2() {
        
        AcctIdInfo acctIdInfo=new AcctIdInfo();
        acctIdInfo.setAcctId("10");
        acctIdInfo.setTenantId("GRT1");
        List<BlCustinfoInfo> queryBlCustinfo = IQueryIdInfoBusiSV.queryExtCustIdByAcctId(acctIdInfo);
       System.out.println(queryBlCustinfo);
    }
    @Test
    public void queryTest3() {
        
        ExtCustIdInfo extCustIdInfo=new ExtCustIdInfo();
        extCustIdInfo.setExtCustId("asiainfo1");
        extCustIdInfo.setTenantId("GRT1");
        List<BlAcctInfoInfo> queryAcctIdByExtCustId = IQueryIdInfoBusiSV.queryAcctIdByExtCustId(extCustIdInfo);
       System.out.println(queryAcctIdByExtCustId);
    }

}
