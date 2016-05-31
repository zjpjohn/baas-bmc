package com.ai.baas.bmc.api.businessdatamaintain.impl;

import com.ai.baas.bmc.api.businessdatamaintain.interfaces.IBillingBusinessDataMaintainSV;
import com.ai.baas.bmc.api.businessdatamaintain.params.BmcRecord;
import com.ai.baas.bmc.api.businessdatamaintain.params.BusinessDataImportRequest;
import com.ai.baas.bmc.api.businessdatamaintain.params.BusinessDataQueryRequest;
import com.ai.baas.bmc.api.businessdatamaintain.params.BusinessDataQueryResponse;
import com.ai.baas.bmc.dao.mapper.bo.BmcRecordFmt;
import com.ai.baas.bmc.service.atom.interfaces.IBmcRecordFmtAtomSV;
import com.ai.baas.bmc.service.atom.interfaces.IRtmSrcInfoAtomSV;
import com.ai.baas.bmc.service.atom.interfaces.IRtmSrcRecordAtomSV;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public BaseResponse businessDataImport(BusinessDataImportRequest importRequest) throws BusinessException, SystemException {

        BaseResponse response;
        try {
            if(importRequest!=null&&!CollectionUtil.isEmpty(importRequest.getImportData())){
                Map<String,List<BmcRecord>> dataMap = new HashMap<>();
                for (BmcRecord record:importRequest.getImportData()) {
                    if(StringUtil.isBlank(record.getTenantId())){
                        throw new BusinessException("000001","tenantId不能为空");
                    }
                    if(StringUtil.isBlank(record.getServiceType())){
                        throw new BusinessException("000002","serviceType不能为空");
                    }
                    if(StringUtil.isBlank(record.getSource())){
                        throw new BusinessException("000003","source不能为空");
                    }
                    StringBuilder builder = new StringBuilder();
                    builder.append(record.getTenantId()).append(record.getServiceType()).append(record.getSource());
                    String key = builder.toString();
                    if(dataMap.containsKey(key)){
                        List<BmcRecord> records = dataMap.get(key);
                        records.add(record);
                    }else{
                        List<BmcRecord> bmcRecords = new ArrayList<>();
                        bmcRecords.add(record);
                        dataMap.put(key,bmcRecords);
                    }
                }
                for(List<BmcRecord> bmcRecordList:dataMap.values()){
                    iBmcRecordFmtAtom.addRecordList(bmcRecordList);
                    iRtmSrcInfoAtom.addRecordList(bmcRecordList);
                    iRtmSrcRecordAtom.addRecordList(bmcRecordList);
                }
            }
            response = new BaseResponse();
            ResponseHeader header = new ResponseHeader();
            header.setIsSuccess(true);
            header.setResultCode("000000");
            header.setResultMessage("计费数据格式导入成功");
            response.setResponseHeader(header);
        } catch (BusinessException e) {
            LOG.error("计费数据格式导入失败",e);
            throw e;
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
        if(StringUtil.isBlank(businessDataQueryRequest.getServiceType())){
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
