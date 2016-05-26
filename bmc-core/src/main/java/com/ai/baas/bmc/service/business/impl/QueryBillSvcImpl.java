package com.ai.baas.bmc.service.business.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.drmanager.parameters.BillQueryInputObject;
import com.ai.baas.bmc.api.drmanager.parameters.BillQueryOutputObject;
import com.ai.baas.bmc.api.drmanager.parameters.Bills;
import com.ai.baas.bmc.api.drmanager.parameters.SubjectDetail;
import com.ai.baas.bmc.api.drmanager.parameters.Subs;
import com.ai.baas.bmc.dao.interfaces.AccChargeYYYYMMMapper;
import com.ai.baas.bmc.dao.interfaces.AccInvoiceYYYYMMMapper;
import com.ai.baas.bmc.dao.interfaces.BmcQueryBillMapper;
import com.ai.baas.bmc.dao.mapper.bo.AccChargeYYYYMM;
import com.ai.baas.bmc.dao.mapper.bo.AccChargeYYYYMMCriteria;
import com.ai.baas.bmc.dao.mapper.bo.AccInvoiceYYYYMM;
import com.ai.baas.bmc.dao.mapper.bo.AccInvoiceYYYYMMCriteria;
import com.ai.baas.bmc.dao.mapper.bo.BmcQueryBill;
import com.ai.baas.bmc.dao.mapper.bo.BmcQueryBillCriteria;
import com.ai.baas.bmc.service.business.interfaces.IQueryBillSvc;
import com.ai.paas.ipaas.util.StringUtil;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.container.page.Page;
import com.esotericsoftware.minlog.Log;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

@Service
@Transactional
public class QueryBillSvcImpl implements IQueryBillSvc {

	private Logger logger = Logger.getLogger(QueryBillSvcImpl.class);

	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Autowired
	private BmcQueryBillMapper bmcQueryBillMapper;
	@Override
	public List<BmcQueryBill> selectBillQuery(BillQueryInputObject billObject) {
		int pageNum = 1;
		int pagecountNum = 10;

		BmcQueryBillCriteria aBmcQueryBillCriteria = new BmcQueryBillCriteria();
		com.ai.baas.bmc.dao.mapper.bo.BmcQueryBillCriteria.Criteria aCriteria = aBmcQueryBillCriteria
				.createCriteria().andTenantIdEqualTo(billObject.getTenantId())
				// .andSystemIdEqualTo(billObject.getSystemId())
				.andCustIdEqualTo(Integer.parseInt(billObject.getCustId()))
				.andSubsIdEqualTo(Integer.parseInt(billObject.getSubsId()));
		// if(!StringUtil.isBlank(billObject.getPageNum())){
		// pageNum = Integer.parseInt(billObject.getPageNum());
		// }
		// if(!StringUtil.isBlank(billObject.getPagecountNum())){
		// pagecountNum = Integer.parseInt(billObject.getPagecountNum());
		// }
		// if(!StringUtil.isBlank(billObject.getQueryMon())){
		// aCriteria.andQueryMonEqualTo(billObject.getQueryMon());
		// }
		int start = (pageNum - 1) * pagecountNum;
		aBmcQueryBillCriteria.setLimitStart(start);
		aBmcQueryBillCriteria.setLimitEnd(pagecountNum);
		List<BmcQueryBill> billList = bmcQueryBillMapper
				.selectByExample(aBmcQueryBillCriteria);
		return billList;
	}

	@Override
	public Integer getBillCount(BillQueryInputObject billObject) {
		BmcQueryBillCriteria aBmcQueryBillCriteria = new BmcQueryBillCriteria();
		com.ai.baas.bmc.dao.mapper.bo.BmcQueryBillCriteria.Criteria aCriteria = aBmcQueryBillCriteria
				.createCriteria().andTenantIdEqualTo(billObject.getTenantId())
				// .andSystemIdEqualTo(billObject.getSystemId())
				.andCustIdEqualTo(Integer.parseInt(billObject.getCustId()))
				.andSubsIdEqualTo(Integer.parseInt(billObject.getSubsId()));
		if (!StringUtil.isBlank(billObject.getQueryStartTime())) {
			aCriteria.andQueryMonEqualTo(billObject.getQueryStartTime()
					.substring(0, 6));
		}
		return bmcQueryBillMapper.countByExample(
				aBmcQueryBillCriteria);
	}

	/**
	 * 获取账单信息
	 * 
	 */
	@Override
	public BillQueryOutputObject billQueryObj(	BillQueryInputObject billQueryInput){
		BillQueryOutputObject bqo = new BillQueryOutputObject();

		try {
			String subsId = billQueryInput.getSubsId();
			String serviceNum = billQueryInput.getServiceNum();
			Integer pageNum = billQueryInput.getPageNum();
			Integer pagecountNum = billQueryInput.getPageCountNum();

			String startTime = billQueryInput.getQueryStartTime().substring(0,
					6);// YYYYMM
			String endTime = billQueryInput.getQueryEndTime().substring(0, 6);// YYYYMM
			 int startIndex =0;
			 int endIndex=0;
			 if(billQueryInput.getFlag()==0){ //0表示支持分页查询
			 startIndex = (pageNum - 1) * pagecountNum;
			 endIndex = (pageNum - 1) * pagecountNum + pagecountNum;
			 }

			AccInvoiceYYYYMMMapper accInvoiceYYYYMMMapper = sqlSessionTemplate
					.getMapper(AccInvoiceYYYYMMMapper.class);
			AccInvoiceYYYYMMCriteria accInvoiceYYYYMMCriteria = new AccInvoiceYYYYMMCriteria();
			AccInvoiceYYYYMMCriteria.Criteria criteria = accInvoiceYYYYMMCriteria
					.createCriteria()
					.andTenantIdEqualTo(billQueryInput.getTenantId())
					// .andSystemIdEqualTo(systemId)
					.andCustIdEqualTo(billQueryInput.getCustId());

			if (!StringUtil.isBlank(subsId)) {
				criteria.andSubsIdEqualTo(subsId);
			}

			if (!StringUtil.isBlank(serviceNum)) {
				criteria.andServiceNumEqualTo(serviceNum);
			}

			int totalCount = 0;

			List<Subs> subsList = new ArrayList<Subs>();
			bqo.setSubList(subsList);// 先置一个空列表
			bqo.setTotalCount(totalCount + "");

			List<String> YYYYMMList = this.getYYYYMMList(startTime, endTime);
			if (CollectionUtils.isEmpty(YYYYMMList)) {
				// 没有合法的月份列表，返回空
				return bqo;
			}

			
			//totalCount 该用户这几个月份的账单 总共找到的条数
			for (int i = 0; i < YYYYMMList.size(); i++) {
				String currentMonth = YYYYMMList.get(i);// YYYYMM
				try {
					totalCount += accInvoiceYYYYMMMapper.countByExample(
							currentMonth, accInvoiceYYYYMMCriteria);
				} catch (Exception e) {
					logger.error("accInvoiceYYYYMMMapper.countByExample Exception "
							+ e);
				}
			}
			bqo.setTotalCount(totalCount + "");
			//例如点击第二页或第三页，没有账单数据了，就是空的
			if(startIndex > (totalCount)){
				//输出页超出总条数
				return bqo;
			}else{
			// 保存billList的偏移量
			int offsetBL = 0;
            int end_flag=0;
			for (int i = 0; i < YYYYMMList.size(); i++) {
				String currentMonth = YYYYMMList.get(i);// YYYYMM
				List<AccInvoiceYYYYMM> accInvoiceYYYYMMList = null;
				try {
					accInvoiceYYYYMMList = accInvoiceYYYYMMMapper
							.selectByExample(currentMonth,
									accInvoiceYYYYMMCriteria);
				} catch (Exception e) {
					logger.error(
							"accInvoiceYYYYMMMapper.selectByExample Exception []",
							e);
				}
				System.out.println("accInvoiceYYYYMMList size:"+accInvoiceYYYYMMList.size()+"   "+accInvoiceYYYYMMList.toString());
				if (CollectionUtils.isEmpty(accInvoiceYYYYMMList)) {
					// 如果当前月份的账单汇总信息没有，则继续获取下个月份的
					continue;
				}

				// 对每条总表记录逐条处理
				for (AccInvoiceYYYYMM aInvoice : accInvoiceYYYYMMList) {
				if (billQueryInput.getFlag() == 0) {
						if (offsetBL < startIndex) {
							// 循环直到,到当前页的第一条记录
							offsetBL++;
							continue;
						}
				}
					// 构建一个用户的当前月份的billl，含账单明细
					Bills aBill = createBill(aInvoice, currentMonth);

					boolean subsExist = false;
					// 找到该用户是否已经有了账单列表对象，如果已经有了，则加入当前账单，否则，新建一个账单列表对象
					for (int k = 0; k < bqo.getSubList().size(); k++) {
						Subs aSubs = bqo.getSubList().get(k);
						if (aSubs.getSubsId().compareTo(aInvoice.getSubsId()) == 0) {
							// 找到了当前用户的信息， 获取其账单列表对象
							List<Bills> aBillList = aSubs.getBillList();
							if (CollectionUtils.isEmpty(aBillList)) {
								// 没有列表对象，则创建一个
								aBillList = new ArrayList<Bills>();
								aBillList.add(aBill);
							} else {
								// 有列表对象，则直接加入
								aBillList.add(aBill);
							}

							subsExist = true;
						}

					}

					if (!subsExist) {
						// 没有找到当前用户信息,则新增一个用户
						Subs s = new Subs();
						s.setSubsId(aInvoice.getSubsId());

						List<Bills> aBillList = new ArrayList<Bills>();
						aBillList.add(aBill);
						s.setBillList(aBillList);

						bqo.getSubList().add(s);
					}
					if (billQueryInput.getFlag() == 0) {
						offsetBL++;
						if (offsetBL == endIndex) {
							// 到达当前页的最后一条，退出循环
							end_flag=1;
							break;
						}
					}
				}
				//已经取到最后一条
				if(billQueryInput.getFlag() == 0 &&end_flag==1){
					break;
				}
			}
			}
		} catch (Exception e) {
			logger.error("Exception = outside", e);
		}

		return bqo;
	}

	/**
	 * 构建一个用户的一个月的billl，包含账单明细 根据一条账单总表记录来创建
	 */
	private Bills createBill(AccInvoiceYYYYMM aInvoice, String acctMonth) {
		Bills aBill = new Bills();
		List<SubjectDetail> subjectDetailList = new ArrayList<SubjectDetail>();

		// 设置该用户当前月份的账单汇总信息
		aBill.setBillMonth(acctMonth);

		BigDecimal precision = new BigDecimal(1000);

		// 从千分之一厘转换成厘
		Double totalD = aInvoice.getTotal()
				.divide(precision, 0, RoundingMode.HALF_UP).doubleValue();
		aBill.setTotalFee(totalD.longValue());

		// 从千分之一厘转换成厘
		Double adjustD = aInvoice.getAdjust()
				.divide(precision, 0, RoundingMode.HALF_UP).doubleValue();
		aBill.setAdjustFee(adjustD.longValue());

		// 从千分之一厘转换成厘
		Double discD = aInvoice.getDisc()
				.divide(precision, 0, RoundingMode.HALF_UP).doubleValue();
		aBill.setDisFee(discD.longValue());

		// 获取该用户当前月份的明细信息
		AccChargeYYYYMMCriteria accChargeYYYYMMCriteria = new AccChargeYYYYMMCriteria();
		AccChargeYYYYMMMapper accChargeYYYYMMMapper = sqlSessionTemplate
				.getMapper(AccChargeYYYYMMMapper.class);

		accChargeYYYYMMCriteria.createCriteria()
				.andAcctIdEqualTo(aInvoice.getAcctId())
				.andSubsIdEqualTo(aInvoice.getSubsId());

		List<AccChargeYYYYMM> accChargeYYYYMMList = null;
		try {
			accChargeYYYYMMList = accChargeYYYYMMMapper.selectByExample(
					acctMonth, accChargeYYYYMMCriteria);
		} catch (Exception e) {
			logger.error("accChargeYYYYMMMapper.selectByExample Exception " + e);
		}

		if (CollectionUtils.isEmpty(accChargeYYYYMMList)) {
			// 如果明细信息列表为空，则返回空列表
			return aBill;
		}

		// 对每一条账单明细，构建返回包中的科目费用列表
		for (AccChargeYYYYMM aCharge : accChargeYYYYMMList) {
			// AccChargeYYYYMM acYYYYMM = accChargeYYYYMMList.get(m);
			SubjectDetail sd = new SubjectDetail();

			sd.setSubjectId(aCharge.getSubjectId());

			// 从千分之一厘转换成厘
			Double totalChargeD = aCharge.getTotal()
					.divide(precision, 0, RoundingMode.HALF_UP).doubleValue();
			sd.setSubjectFee(totalChargeD.longValue());

			// 从千分之一厘转换成厘
			Double adjustChargeD = aCharge.getAdjust()
					.divide(precision, 0, RoundingMode.HALF_UP).doubleValue();
			sd.setSubjcetAdjustFee(adjustChargeD.longValue());

			// 从千分之一厘转换成厘
			Double disChargeD = aCharge.getDisc()
					.divide(precision, 0, RoundingMode.HALF_UP).doubleValue();
			sd.setSubjectDisFee(disChargeD.longValue());

			subjectDetailList.add(sd);
		}

		aBill.setSubjectDetailList(subjectDetailList);

		return aBill;
	}

	/**
	 * getYYYYMMList()
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 * @author ygz
	 * @ApiDocMethod
	 */
	public List<String> getYYYYMMList(String startTime, String endTime) {
		List<String> YYYYMMList = new ArrayList<String>();

		String startYear = startTime.substring(0, 4);
		String endYear = endTime.substring(0, 4);
		String startMonth = startTime.substring(4, 6);
		String endMonth = endTime.substring(4, 6);

		if (startYear.equalsIgnoreCase(endYear)) {
			// 同一年内的比较
			int startTimeI = Integer.parseInt(startMonth);
			int endTimeI = Integer.parseInt(endMonth);
			for (int i = startTimeI; i <= endTimeI; i++) {
				YYYYMMList.add(startYear + String.format("%02d", i));
			}
		} else {
			// 跨年的
			int startYearI = Integer.parseInt(startYear);
			int endYearI = Integer.parseInt(endYear);
			int startMonthI = Integer.parseInt(startMonth);
			int endMonthI = Integer.parseInt(endMonth);

			// 第一年
			for (int m = startMonthI; m <= 12; m++) {
				YYYYMMList.add(startYear + String.format("%02d", m));
			}

			// 第二年到倒数第二年
			startYearI++;
			for (int y = startYearI; y <= endYearI - 1; y++) {
				for (int m = 1; m <= 12; m++) {
					YYYYMMList.add(y + String.format("%02d", m));
				}
			}

			// 最后一年
			for (int m = 1; m <= endMonthI; m++) {
				YYYYMMList.add(endYear + String.format("%02d", m));
			}
		}

		return YYYYMMList;
	}

}
