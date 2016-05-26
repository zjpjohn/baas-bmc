package com.ai.baas.bmc.service.atom.impl;

import com.ai.baas.bmc.api.businessdatamaintain.params.BmcRecord;
import com.ai.baas.bmc.dao.interfaces.RtmSrcRecordMapper;
import com.ai.baas.bmc.dao.mapper.bo.RtmSrcRecord;
import com.ai.baas.bmc.dao.mapper.bo.RtmSrcRecordCriteria;
import com.ai.baas.bmc.service.atom.interfaces.IRtmSrcRecordAtomSV;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RtmSrcRecordAtomImpl implements IRtmSrcRecordAtomSV {

    @Autowired
    private RtmSrcRecordMapper srcRecordMapper;

    @Override
    public void addRecordList(List<BmcRecord> srcRecords) {
        if(!CollectionUtil.isEmpty(srcRecords)){
            String infoId = srcRecords.get(0).getServiceType();
            if(!StringUtil.isBlank(infoId)){
                RtmSrcRecordCriteria example = new RtmSrcRecordCriteria();
                RtmSrcRecordCriteria.Criteria criteria = example.createCriteria();
                criteria.andInfoIdEqualTo(infoId);
                srcRecordMapper.deleteByExample(example);
            }
            for (BmcRecord record:srcRecords){
                RtmSrcRecord srcRecord = new RtmSrcRecord();
                srcRecord.setInfoId(record.getServiceType());
                srcRecord.setFieldId(String.valueOf(record.getFieldSerial()));
                srcRecord.setFieldName(record.getFieldCode());
                srcRecord.setFieldLength("1");
                srcRecord.setStartLocal("0");
                srcRecord.setIsSn(record.getIsSn());
                srcRecord.setFieldType("String");
                srcRecordMapper.insertSelective(srcRecord);
            }
        }
    }
}
