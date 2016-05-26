package com.ai.baas.bmc.service.atom.impl;

import com.ai.baas.bmc.api.businessdatamaintain.params.BmcRecord;
import com.ai.baas.bmc.api.businessdatamaintain.params.BusinessDataQueryRequest;
import com.ai.baas.bmc.dao.interfaces.BmcRecordFmtMapper;
import com.ai.baas.bmc.dao.mapper.bo.BmcRecordFmt;
import com.ai.baas.bmc.dao.mapper.bo.BmcRecordFmtCriteria;
import com.ai.baas.bmc.service.atom.interfaces.IBmcRecordFmtAtomSV;
import com.ai.baas.bmc.util.BmcSeqUtil;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.paas.ipaas.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BmcRecordFmtAtomImpl implements IBmcRecordFmtAtomSV {

	@Autowired
	private BmcRecordFmtMapper mapper;
	
    @Override
    public void addRecordList(List<BmcRecord> records) {
        if(!CollectionUtil.isEmpty(records)){
            if (!StringUtil.isBlank(records.get(0).getTenantId()) &&
                    !StringUtil.isBlank(records.get(0).getServiceType()) && !StringUtil.isBlank(records.get(0).getSource())) {
                BmcRecordFmtCriteria example = new BmcRecordFmtCriteria();
                BmcRecordFmtCriteria.Criteria criteria = example.or();
                criteria.andFormatTypeEqualTo((short) 1)//1：Excel导入的，2：手动添加的。
                        .andTenantIdEqualTo(records.get(0).getTenantId())
                        .andServiceTypeEqualTo(records.get(0).getServiceType())
                        .andSourceEqualTo(records.get(0).getSource());
                mapper.deleteByExample(example);
            }
            for (BmcRecord record:records){
                BmcRecordFmt recordFmt = new BmcRecordFmt();
                BeanUtils.copyProperties(recordFmt,record);
                recordFmt.setId(Integer.parseInt(BmcSeqUtil.getRecordId()));
                mapper.insertSelective(recordFmt);
            }
        }
    }

    @Override
    public List<BmcRecordFmt> query(BusinessDataQueryRequest businessDataQueryRequest) {
        BmcRecordFmtCriteria example = new BmcRecordFmtCriteria();
        BmcRecordFmtCriteria.Criteria criteria = example.or();
        criteria.andTenantIdEqualTo(businessDataQueryRequest.getTenantId());
        criteria.andServiceTypeEqualTo(businessDataQueryRequest.getServiceType());
        criteria.andSourceEqualTo(businessDataQueryRequest.getSource());
        return mapper.selectByExample(example);
    }

}
