package com.ai.opt.baas.bmc.test.api.businessdatamaintain.impl;

import com.ai.baas.bmc.api.businessdatamaintain.interfaces.IBillingBusinessDataMaintainSV;
import com.ai.baas.bmc.api.businessdatamaintain.params.BmcRecord;
import com.ai.baas.bmc.api.businessdatamaintain.params.BusinessDataImportRequest;
import com.ai.baas.bmc.dao.interfaces.RtmSrcInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.RtmSrcInfo;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class IBillingBusinessDataMaintainSVTest {

    @Autowired
    private IBillingBusinessDataMaintainSV iBillingBusinessDataMaintainSV;

    @Autowired
    private RtmSrcInfoMapper srcInfoMapper;

    @Test
    public void businessDataImportTest(){
        List<BmcRecord> recordList = new ArrayList<>();
        for (int i=0;i<5;i++){
            BmcRecord record = new BmcRecord();
            //record.setTenantId("Test-import");
            record.setTenantId("Test-1");
            record.setDataType("String");
            record.setFieldCode("name"+i);
            record.setFieldName("test"+i);
            record.setFieldSerial(i+1);
            record.setFormatType((short)1);
            record.setIsSn("0");
            record.setNullable("1");
            record.setServiceType("voice-test");
            record.setSource("mvne");

            recordList.add(record);
        }
        BusinessDataImportRequest importRequest = new BusinessDataImportRequest();
        importRequest.setImportData(recordList);
        importRequest.setTenantId("Test-1");
        String str = JSON.toJSONString(importRequest);
        System.out.println(str);
        //BaseResponse response = iBillingBusinessDataMaintainSV.businessDataImport(importRequest);
        //System.out.println(JSON.toJSONString(response));
    }

    @Test
    public void testQuery(){
        System.out.println("=============================");
        /*BusinessDataQueryRequest req = new BusinessDataQueryRequest();
        req.setTenantId("Test-1");
        req.setServiceType("voice-test");
        req.setSource("mvne");
        JSON.toJSONString(req);
        BusinessDataQueryResponse dataFormatList = iBillingBusinessDataMaintainSV.getDataFormatList(req);
        JSON.toJSONString(dataFormatList);
        List<BmcRecord> recordList = dataFormatList.getRecordList();*/
        RtmSrcInfo record = new RtmSrcInfo();
        record.setTenantId("test112");
        record.setInfoType("test112");
        srcInfoMapper.insertSpec(record);
    }
}
