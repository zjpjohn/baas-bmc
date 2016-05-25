package com.ai.opt.baas.failbill;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.failedbillmaintain.interfaces.IFailedBillMaintainSV;
import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBillCriteria;
import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBillPagerResponse;
import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBillParam;
import com.ai.baas.bmc.api.feeReBatch.interfaces.IFeeReBatchSV;
import com.ai.baas.bmc.api.feeReBatch.params.FeeParam;
import com.ai.baas.bmc.api.feeReBatch.params.FeeParamPagerResponse;
import com.ai.baas.bmc.api.feeReBatch.params.FeeReBatchCriteria;
import com.ai.opt.base.vo.BaseResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class FeeTest {
	 @Autowired
	 IFeeReBatchSV feeReBatchSV;
	 
	 @Test
	    public void queryTest2(){
		    FeeReBatchCriteria queryInfo = new FeeReBatchCriteria();
	    	queryInfo.setTenantId("VIV-BYD");
	    	queryInfo.setServiceType("VOICE");
	    	queryInfo.setAccountPeriod("20160523");
//	    	queryInfo.setErrorCode();
	    	FeeParamPagerResponse list = feeReBatchSV.queryFeeReBatch(queryInfo);
	    	System.out.println("标准资费查询出参:"+JSON.toJSONString(list));
	    }
	 
	 
}
