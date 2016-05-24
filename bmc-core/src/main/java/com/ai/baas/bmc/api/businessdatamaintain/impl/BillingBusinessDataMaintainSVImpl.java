package com.ai.baas.bmc.api.businessdatamaintain.impl;

import com.ai.baas.bmc.api.businessdatamaintain.interfaces.IBillingBusinessDataMaintainSV;
import com.ai.baas.bmc.api.businessdatamaintain.params.BmcRecord;
import com.ai.baas.bmc.api.businessdatamaintain.params.BusinessDataQueryRequest;
import com.ai.baas.bmc.api.businessdatamaintain.params.BusinessDataQueryResponse;
import com.ai.baas.bmc.dao.mapper.bo.BmcRecordFmt;
import com.ai.baas.bmc.dao.mapper.bo.RtmSrcInfo;
import com.ai.baas.bmc.dao.mapper.bo.RtmSrcRecord;
import com.ai.baas.bmc.service.atom.interfaces.IBmcRecordFmtAtomSV;
import com.ai.baas.bmc.service.atom.interfaces.IRtmSrcInfoAtomSV;
import com.ai.baas.bmc.service.atom.interfaces.IRtmSrcRecordAtomSV;
import com.ai.baas.bmc.util.BmcSeqUtil;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Service(validation="true")
@Component
public class BillingBusinessDataMaintainSVImpl implements IBillingBusinessDataMaintainSV{

    private static final Logger LOG = LogManager.getLogger(IBillingBusinessDataMaintainSV.class);

    @Autowired
    private IBmcRecordFmtAtomSV iBmcRecordFmtAtom;

    @Autowired
    private IRtmSrcInfoAtomSV iRtmSrcInfoAtom;

    @Autowired
    private IRtmSrcRecordAtomSV iRtmSrcRecordAtom;

    @Override
    public BaseResponse businessDataImport(List<BmcRecord> importData) throws BusinessException, SystemException {

        BaseResponse response;
        try {
            if(!CollectionUtil.isEmpty(importData)){
                for (BmcRecord record:importData) {
                    BmcRecordFmt recordFmt = new BmcRecordFmt();
                    BeanUtils.copyProperties(recordFmt,record);
                    recordFmt.setId(Integer.parseInt(BmcSeqUtil.getRecordId()));
                    iBmcRecordFmtAtom.add(recordFmt);

                    RtmSrcInfo srcInfo = new RtmSrcInfo();
                    srcInfo.setTenantId(record.getTenantId());
                    srcInfo.setInfoType(record.getServiceId());
                    iRtmSrcInfoAtom.addRecord(srcInfo);

                    RtmSrcRecord srcRecord = new RtmSrcRecord();
                    srcRecord.setInfoId(record.getSource());
                    srcRecord.setFieldId(String.valueOf(record.getFieldSerial()));
                    srcRecord.setFieldName(record.getFieldCode());
                    srcRecord.setFieldLength("1");
                    srcRecord.setStartLocal("0");
                    srcRecord.setIsSn(record.getIsSn());
                    srcRecord.setFieldType("String");
                    iRtmSrcRecordAtom.addRecord(srcRecord);
                }
            }
            response = new BaseResponse();
            ResponseHeader header = new ResponseHeader();
            header.setIsSuccess(true);
            header.setResultCode("000000");
            header.setResultMessage("计费数据格式导入成功");
            response.setResponseHeader(header);
        } catch (Exception e) {
            LOG.error("计费数据格式导入失败",e);
            throw new SystemException("计费数据格式导入失败",e);
        }
        return response;
    }

    @Override
    public BusinessDataQueryResponse getDataFormatList(BusinessDataQueryRequest businessDataQueryRequest) throws BusinessException, SystemException {
        BusinessDataQueryResponse queryResponse;

        if(StringUtil.isBlank(businessDataQueryRequest.getTenantId())){
            throw new BusinessException("empty", "tenantId不能为空");
        }
        if(StringUtil.isBlank(businessDataQueryRequest.getServiceId())){
            throw new BusinessException("empty", "serviceId不能为空");
        }
        if(StringUtil.isBlank(businessDataQueryRequest.getSource())){
            throw new BusinessException("empty", "source不能为空");
        }

        try {
            List<BmcRecordFmt> recordList = iBmcRecordFmtAtom.query(businessDataQueryRequest);
            List<BmcRecord> records = new ArrayList<>();
            if(!CollectionUtil.isEmpty(recordList)){
                for (BmcRecordFmt bmcRecordFmt:recordList) {
                    BmcRecord record = new BmcRecord();
                    BeanUtils.copyProperties(record,bmcRecordFmt);
                    records.add(record);
                }
            }
            queryResponse = new BusinessDataQueryResponse();
            queryResponse.setRecordList(records);
            ResponseHeader header = new ResponseHeader();
            header.setIsSuccess(true);
            header.setResultCode("000000");
            header.setResultMessage("查询计费数据成功");
            queryResponse.setResponseHeader(header);
        } catch (Exception e) {
            LOG.error("查询计费数据格式失败",e);
            throw new SystemException("查询计费数据格式失败",e);
        }
        return queryResponse;
    }
}
