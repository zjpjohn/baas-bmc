package com.ai.baas.bmc.service.atom.impl;

import com.ai.baas.bmc.dao.interfaces.RtmSrcRecordMapper;
import com.ai.baas.bmc.dao.mapper.bo.RtmSrcRecord;
import com.ai.baas.bmc.dao.mapper.bo.RtmSrcRecordCriteria;
import com.ai.baas.bmc.service.atom.interfaces.IRtmSrcRecordAtomSV;
import com.ai.opt.sdk.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RtmSrcRecordAtomImpl implements IRtmSrcRecordAtomSV {

    @Autowired
    private RtmSrcRecordMapper srcRecordMapper;

    @Override
    public void addRecord(RtmSrcRecord srcRecord) {

        if(!StringUtil.isBlank(srcRecord.getInfoId())){
            RtmSrcRecordCriteria example = new RtmSrcRecordCriteria();
            RtmSrcRecordCriteria.Criteria criteria = example.createCriteria();
            criteria.andInfoIdEqualTo(srcRecord.getInfoId());
            srcRecordMapper.deleteByExample(example);
        }

        srcRecordMapper.insertSelective(srcRecord);
    }
}
