package com.ai.baas.bmc.service.atom.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.currmonthusgquery.parameters.CurrMonthUsgQueryReq;
import com.ai.baas.bmc.api.currmonthusgquery.parameters.CurrMonthUsgQueryResp;
import com.ai.baas.bmc.api.currmonthusgquery.parameters.MonthVO;
import com.ai.baas.bmc.api.currmonthusgquery.parameters.ProductVO;
import com.ai.baas.bmc.api.currmonthusgquery.parameters.SubsInfoVO;
import com.ai.baas.bmc.dao.interfaces.StatYyyymmMapper;
import com.ai.baas.bmc.dao.mapper.bo.BlSubsComm;
import com.ai.baas.bmc.dao.mapper.bo.StatYyyymm;
import com.ai.baas.bmc.dao.mapper.bo.StatYyyymmCriteria;
import com.ai.baas.bmc.dao.mapper.bo.StatYyyymmCriteria.Criteria;
import com.ai.baas.bmc.service.atom.interfaces.IBlSubsCommQuery;
import com.ai.baas.bmc.service.atom.interfaces.ICurrMonthUsgQueryAtom;
import com.ai.paas.ipaas.util.StringUtil;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;

/**
 * Date: 2016年4月28日 <br>
 * @author zhoushanbin
 * Copyright (c) 2016 asiainfo.com <br>
 */
@Component
public class CurrMonthUsgQueryAtomImpl implements ICurrMonthUsgQueryAtom {
	
	private static final Logger LOG = LoggerFactory.getLogger(CurrMonthUsgQueryAtomImpl.class);
	@Autowired
	private StatYyyymmMapper statYyyymmMapper;
	
	@Autowired
	private IBlSubsCommQuery blSubsCommQueryAtom;
	
	@Override
	public CurrMonthUsgQueryResp currMonthUsgQuery(CurrMonthUsgQueryReq req) {
		CurrMonthUsgQueryResp resp = new CurrMonthUsgQueryResp();
		//租户ID
		resp.setTenantId(req.getTenantId());
		//消息流水
		resp.setMsgSeq(req.getMsgSeq());
		//resp.setSystemId(req.getSystemId());

		String tenantId = req.getTenantId();
		//String systemId = req.getSystemId();
		//客户ID
		String custId = req.getCustId();
		//用户订购标识
		String subsId = req.getSubsId();
		//服务号码
		String serviceNum = req.getServiceNum();
		//通道类型
		String apnCode = req.getApnCode();
		Map<String,List<StatYyyymm>> statMap = new HashMap<String,List<StatYyyymm>>();
		List<String> tbSufixs = getTbSufixs(req.getBeginMonth(),req.getEndMonth());
		LOG.info(("query month:"+JSON.toJSONString(tbSufixs)));
		List<MonthVO> monthList = new ArrayList<MonthVO>();
		resp.setMonthList(monthList);
		String tbPre = tenantId.toLowerCase().replace("-", "_");//(systemId.toLowerCase() + "_"+tenantId.toLowerCase()).replace("-", "_");
		for(String tbSufix:tbSufixs){
			StatYyyymmCriteria example = new StatYyyymmCriteria();
			Criteria criteria = example.createCriteria();
			if(!StringUtil.isBlank(custId)){
				criteria.andCustIdEqualTo(custId);
			}
			if(!StringUtil.isBlank(subsId)){
				criteria.andSubsIdEqualTo(subsId);
			}
			if(!StringUtil.isBlank(serviceNum)){
				criteria.andServiceNumEqualTo(serviceNum);
			}
			if(!StringUtil.isBlank(apnCode)&&apnCode!="ALL"){
				criteria.andSourceEqualTo(apnCode);
			}
			
			List<StatYyyymm> list = statYyyymmMapper.selectByExample(tbPre, tbSufix, example);
			statMap.put(tbSufix, list);
			
		}
		
		for(Entry<String, List<StatYyyymm>> entry:statMap.entrySet()){
			String month = entry.getKey();
			List<StatYyyymm> list = entry.getValue();
			MonthVO monthVO = new MonthVO();
			monthList.add(monthVO);
			monthVO.setBeginMonth(month);
			if(!list.isEmpty()){
				//客户一样，所以取第一条即可
				monthVO.setCustId(list.get(0).getCustId());
			}
			List<SubsInfoVO> subList = new ArrayList<SubsInfoVO>();
			monthVO.setSubList(subList);
			for(StatYyyymm stat:list){
				SubsInfoVO subsInfoVO = new SubsInfoVO();
				List<ProductVO> productList = new ArrayList<ProductVO>();
				subList.add(subsInfoVO);
				subsInfoVO.setProductList(productList);
				//根据stat获取信息 使用总量为：上行流量+下行流量
				Double amount = stat.getGprsUp() + stat.getGprsDown();
				subsInfoVO.setAmount(String.valueOf(amount));
				subsInfoVO.setServiceNum(stat.getServiceNum());
				subsInfoVO.setSubsId(stat.getSubsId());
				//根据用户获取对应的商品
				List<BlSubsComm> blSubsComms = blSubsCommQueryAtom.query(tenantId, stat.getSubsId());
				for(BlSubsComm blSubsComm:blSubsComms){
					ProductVO productVO = new ProductVO();
					productList.add(productVO);
					productVO.setProductId(blSubsComm.getProductId());
				}
				
			}
		}

		return resp;
	}

	/**
	 * 获取开始日期到结束日期的表后缀
	 * @param bgTime
	 *            yyyymm
	 * @param endTime
	 *            yyyymm
	 * @return
	 */
	private List<String> getTbSufixs(String bgTime, String endTime) {
		List<String> tbSufixs = new ArrayList<String>();
		Locale locale = new Locale("zh_CN");
		Calendar now = Calendar.getInstance(locale);
		int curYear = now.get(Calendar.YEAR);
		int curMonth = now.get(Calendar.MONTH) + 1;

		if (StringUtils.isBlank(bgTime)) {

			return getTbSufixs2(curYear, curMonth, curMonth);

		}

		int bgYear = Integer.parseInt(bgTime.substring(0, 4));
		int bgMonth = Integer.parseInt(bgTime.substring(4, bgTime.length()));

		if (!StringUtils.isBlank(endTime)) {
			int endYear = Integer.parseInt(endTime.substring(0, 4));
			int endMonth = Integer.parseInt(endTime.substring(4,
					endTime.length()));
			curYear = endYear;
			curMonth = endMonth;
		}

		if (curYear < bgYear) {
			tbSufixs.clear();
			return tbSufixs;
		}
		if (curYear == bgYear) {
			return getTbSufixs2(curYear, bgMonth, curMonth);
		} else {
			tbSufixs.addAll(getTbSufixs3(bgYear, curYear));
			tbSufixs.addAll(getTbSufixs2(bgYear, bgMonth, 12));
			tbSufixs.addAll(getTbSufixs2(curYear, 1, curMonth));
			return tbSufixs;
		}

	}

	private List<String> getTbSufixs2(int year, int bgMonth, int endMonth) {

		List<String> tbSufixs = new ArrayList<String>();
		if (endMonth < bgMonth) {
			return tbSufixs;
		}
		int range = endMonth - bgMonth;
		for (int i = 0; i <= range; i++) {

			String monthStr = "";

			if ((bgMonth + i) < 10) {
				monthStr = "0" + String.valueOf((bgMonth + i));
			} else {
				monthStr = String.valueOf((bgMonth + i));
			}

			tbSufixs.add(String.valueOf(year) + monthStr);
		}

		return tbSufixs;
	}

	/**
	 * 获取开始年份到结束年分（不包括开始和结束年份）的后缀
	 * 
	 * @param bgYear
	 * @param endYear
	 * @return
	 */
	private List<String> getTbSufixs3(int bgYear, int endYear) {
		List<String> tbSufixs = new ArrayList<String>();
		if (bgYear >= endYear) {
			return tbSufixs;
		}
		int range = endYear - bgYear;
		for (int i = 1; i < range; i++) {
			tbSufixs.addAll(getTbSufixs2(bgYear + i, 1, 12));
		}
		return tbSufixs;
	}
	
	
}
