package com.ai.baas.bmc.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.context.ErrorCode;
import com.ai.baas.bmc.dao.interfaces.SysSequenceSrcMapper;
import com.ai.baas.bmc.dao.mapper.bo.SysSequenceSrc;
import com.ai.baas.bmc.dao.mapper.bo.SysSequenceSrcCriteria;
import com.ai.baas.bmc.service.business.interfaces.ISysSequenceSvc;
import com.ai.baas.bmc.util.LoggerUtil;
import com.ai.opt.base.exception.BusinessException;

@Service
@Transactional
public class SysSequenceSvcImpl implements ISysSequenceSvc {
    private static final Logger LOGGER=LogManager.getLogger(SysSequenceSvcImpl.class);
    @Autowired
    private SysSequenceSrcMapper aSysSequenceSrcMapper;

    @Override
    public List<String> terrigerSysSequence(String sequenceName, int record) {
        List<String> strArray = new ArrayList<String>();
        SysSequenceSrcCriteria sysSequenceSrcCriteria = new SysSequenceSrcCriteria();
        sysSequenceSrcCriteria.createCriteria().andSequenceNameEqualTo(sequenceName);
        List<SysSequenceSrc> iSysSequenceSrc = aSysSequenceSrcMapper
                .selectByExample(sysSequenceSrcCriteria);
        if ((iSysSequenceSrc == null) || (iSysSequenceSrc.isEmpty())) {
            LoggerUtil.log.info("不存在" + sequenceName + "的信息");
            SysSequenceSrc sysSequenceSrc = new SysSequenceSrc();
            sysSequenceSrc.setSequenceName(sequenceName);
            sysSequenceSrc.setCurrentValue(0L);
            sysSequenceSrc.setMaxValue(999999999L);
            sysSequenceSrc.setMinValue(0L);
            sysSequenceSrc.setComments("自动生成");
            sysSequenceSrc.setCyclable("NO");
            aSysSequenceSrcMapper.insert(sysSequenceSrc);

            for (int i = 0; i < record; i++) {
                String seq = getSysSequence(sequenceName);
                strArray.add(seq);
            }
        } else {
            for (int i = 0; i < record; i++) {
                String seq = getSysSequence(sequenceName);
                // LOGGER.info("&&&&&&&&&&&&&&seq:"+seq);
                strArray.add(seq);
            }
        }

        return strArray;
    }

    // 获得序列名字
    private String getSysSequence(String sequenceName) {
        try {
            SysSequenceSrcCriteria sysSequenceSrcCriteria = new SysSequenceSrcCriteria();
            sysSequenceSrcCriteria.createCriteria().andSequenceNameEqualTo(sequenceName);
            List<SysSequenceSrc> iSysSequenceSrc = aSysSequenceSrcMapper
                    .selectByExample(sysSequenceSrcCriteria);
            int n = 0;

            SysSequenceSrc sysSequenceSrc_ = iSysSequenceSrc.get(n);
            SysSequenceSrc sysSequenceSrc = new SysSequenceSrc();
            sysSequenceSrc.setSequenceName(sequenceName);
            sysSequenceSrc.setId(sysSequenceSrc_.getId());
            sysSequenceSrc.setMaxValue(sysSequenceSrc_.getMaxValue());
            sysSequenceSrc.setMinValue(sysSequenceSrc_.getMinValue());
            sysSequenceSrc.setComments(sysSequenceSrc_.getComments());
            sysSequenceSrc.setCyclable(sysSequenceSrc_.getCyclable());

            if ((sysSequenceSrc_.getCurrentValue()) + 1 < (sysSequenceSrc_.getMaxValue())) {
                LoggerUtil.log.info("存在" + sequenceName + "的信息,当前值未超过最大值");
                long current = sysSequenceSrc_.getCurrentValue() + 1;
//                LOGGER.info(current);
                sysSequenceSrc.setCurrentValue(current);
                aSysSequenceSrcMapper.updateByExample(sysSequenceSrc, sysSequenceSrcCriteria);
                return String.valueOf(current);
            } else {
                if (sysSequenceSrc_.getCyclable().equals("NO")) {
                    throw new BusinessException(ErrorCode.OVER_LENTH, "达到最大值");
                } else {
                    sysSequenceSrc.setCurrentValue(1L);
                    aSysSequenceSrcMapper.updateByExample(sysSequenceSrc, sysSequenceSrcCriteria);
                    return String.valueOf(1L);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
