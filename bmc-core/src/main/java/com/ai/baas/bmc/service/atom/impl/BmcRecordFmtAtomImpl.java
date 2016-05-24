package com.ai.baas.bmc.service.atom.impl;

import com.ai.baas.bmc.api.businessdatamaintain.params.BusinessDataQueryRequest;
import com.ai.baas.bmc.dao.interfaces.BmcRecordFmtMapper;
import com.ai.baas.bmc.dao.mapper.bo.BmcRecordFmt;
import com.ai.baas.bmc.dao.mapper.bo.BmcRecordFmtCriteria;
import com.ai.baas.bmc.service.atom.interfaces.IBmcRecordFmtAtomSV;
import com.ai.paas.ipaas.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BmcRecordFmtAtomImpl implements IBmcRecordFmtAtomSV {

	@Autowired
	private BmcRecordFmtMapper mapper;
	
    @Override
    public void add(BmcRecordFmt record) {
        if(record != null){
            //1.如果存在，就先删除
            if(!StringUtil.isBlank(record.getTenantId()) && 
                    !StringUtil.isBlank(record.getServiceId()) && !StringUtil.isBlank(record.getSource())){
                BmcRecordFmtCriteria example = new BmcRecordFmtCriteria();
                BmcRecordFmtCriteria.Criteria criteria = example.or();
                criteria.andFormatTypeEqualTo((short) 1)//1：Excel导入的，2：手动添加的。
                .andTenantIdEqualTo(record.getTenantId())
                .andServiceIdEqualTo(record.getServiceId())
                .andSourceEqualTo(record.getSource());
                mapper.deleteByExample(example);
            }
            
            //2.插入数据
            mapper.insertSelective(record);
        }
    }

    @Override
    public List<BmcRecordFmt> query(BusinessDataQueryRequest businessDataQueryRequest) {
        BmcRecordFmtCriteria example = new BmcRecordFmtCriteria();
        BmcRecordFmtCriteria.Criteria criteria = example.or();
        criteria.andTenantIdEqualTo(businessDataQueryRequest.getTenantId());
        criteria.andServiceIdEqualTo(businessDataQueryRequest.getServiceId());
        criteria.andSourceEqualTo(businessDataQueryRequest.getSource());
        return mapper.selectByExample(example);
    }

}
