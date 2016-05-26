package com.ai.opt.baas.bmc.test.api.businessdatamaintain.impl;

import com.ai.baas.bmc.api.businessdatamaintain.interfaces.IBillingBusinessDataMaintainSV;
import com.ai.baas.bmc.api.businessdatamaintain.params.BmcRecord;
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
        iBillingBusinessDataMaintainSV.businessDataImport(recordList);
    }

    @Test
    public void testASCII(){
        System.out.println("=============================");
        System.out.println(String.valueOf((char)1));
        System.out.println(String.valueOf((char)2));
        System.out.println(String.valueOf((char)3));
    }
}
