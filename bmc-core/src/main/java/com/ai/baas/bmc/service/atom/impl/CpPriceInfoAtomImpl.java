package com.ai.baas.bmc.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.baas.bmc.api.marktableproduct.params.ProductQueryByIdListVO;
import com.ai.baas.bmc.api.priceinfo.params.QueryInfoParams;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProductQueryParam;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProductQueryVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.RelatedVO;
import com.ai.baas.bmc.dao.interfaces.CpPriceInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfoCriteria;
import com.ai.baas.bmc.service.atom.interfaces.ICpPriceInfoAtom;
import com.ai.baas.bmc.util.DshmUtil;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.alibaba.fastjson.JSON;

@Service
public class CpPriceInfoAtomImpl implements ICpPriceInfoAtom {
	@Autowired
	private CpPriceInfoMapper cpPriceInfoMapper;

	@Override
	public Long addCpPriceInfo(CpPriceInfo info) {
		//1 是添加，0是删除
	
		int cpPriceInfoId=cpPriceInfoMapper.insert(info);
		if(cpPriceInfoId>0){ //刷新缓存
			DshmUtil.getIdshmSV().initLoader("cp_price_info",JSON.toJSONString(info),1);	
		}
		return info.getPriceInfoId();
	}
	
	

	@Override
	public int delCpRpriceInfo(CpPriceInfo info) {
		//TODO 还需要在缓存中进行更新
		CpPriceInfoCriteria example=new CpPriceInfoCriteria();
		CpPriceInfoCriteria.Criteria criteria = example.or();
		criteria.andTenantIdEqualTo(info.getTenantId()).andPriceInfoIdEqualTo(info.getPriceInfoId());
		
		int count=cpPriceInfoMapper.updateByExampleSelective(info, example);
		/*if(count>0){
			DshmUtil.getIdshmSV().initLoader("cp_price_info",JSON.toJSONString(info),0);	
		}*/
		return count;
	}


	/**
	 * 获取资费信息表
	 */
	@Override
	public List<CpPriceInfo> getCpPriceInfo(ProductQueryVO vo) {
		
		CpPriceInfoCriteria example=new CpPriceInfoCriteria();
		CpPriceInfoCriteria.Criteria criteria = example.or();
		criteria.andTenantIdEqualTo(vo.getTenantId());
		criteria.andActiveStatusNotEqualTo("DEL");
		if(vo.getActiveDate()!=null){
			criteria.andActiveTimeEqualTo(vo.getActiveDate());
		}
		if(vo.getInvalidDate()!=null){
			criteria.andInactiveTimeEqualTo(vo.getInvalidDate());
		}
		if(vo.getProductName()!=null){
			criteria.andPriceNameEqualTo(vo.getProductName());
		}
		if(vo.getProferType()!=null){
			criteria.andProductTypeEqualTo(vo.getProferType());
		}
		if(vo.getPageNo()!=null&&vo.getPageSize()!=null){
			example.setLimitStart((vo.getPageNo()-1)*vo.getPageSize());
			example.setLimitEnd(vo.getPageSize());
		}
		
		return cpPriceInfoMapper.selectByExample(example);
	}



	@Override
	public CpPriceInfo getCpPriceInfo(ProductQueryParam param) {
		CpPriceInfoCriteria sql=new CpPriceInfoCriteria();
		CpPriceInfoCriteria.Criteria criteria=sql.createCriteria();
		criteria.andTenantIdEqualTo(param.getTenantId());
		criteria.andPriceInfoIdEqualTo(param.getProductId());
		return cpPriceInfoMapper.selectByExample(sql).get(0);
	}



	@Override
	public CpPriceInfo getCpPriceInfo(RelatedVO vo) {
		CpPriceInfoCriteria sql=new CpPriceInfoCriteria();
		CpPriceInfoCriteria.Criteria criteria=sql.createCriteria();
		criteria.andTenantIdEqualTo(vo.getTenantId());
		criteria.andPriceInfoIdEqualTo(vo.getProductId());
		List<CpPriceInfo> list=cpPriceInfoMapper.selectByExample(sql);
		if(!CollectionUtil.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}



	@Override
	public void updatePriceInfo(CpPriceInfo info) {
		CpPriceInfoCriteria sql=new CpPriceInfoCriteria();
		CpPriceInfoCriteria.Criteria criteria=sql.createCriteria();
		criteria.andTenantIdEqualTo(info.getTenantId());
		criteria.andPriceInfoIdEqualTo(info.getPriceInfoId());
	
		cpPriceInfoMapper.updateByExampleSelective(info,sql);
		
		//TODO 需要维护一个缓存
	}
	
	/**
	 * 通过priceCode修改信息
	 * @param info
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	@Override
	public void updatePriceInfoByPriceCode(CpPriceInfo info) {
		//
		CpPriceInfoCriteria sql=new CpPriceInfoCriteria();
		CpPriceInfoCriteria.Criteria criteria=sql.createCriteria();
		criteria.andPriceCodeEqualTo(info.getPriceCode());
		//
		this.cpPriceInfoMapper.updateByExampleSelective(info, sql);
	}


	/**
	 * 通过priceCode删除信息
	 * @param info
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	@Override
	public void deletePriceInfoByPriceCode(CpPriceInfo info) {
		CpPriceInfoCriteria sql=new CpPriceInfoCriteria();
		CpPriceInfoCriteria.Criteria criteria=sql.createCriteria();
		criteria.andPriceCodeEqualTo(info.getPriceCode());
		//
		this.cpPriceInfoMapper.deleteByExample(sql);
	}


	/**
	 * 根据priceCode查询信息
	 * @param info
	 * @return
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	@Override
	public CpPriceInfo getCpPriceInfoByPriceCode(CpPriceInfo info) {
		CpPriceInfoCriteria sql=new CpPriceInfoCriteria();
		CpPriceInfoCriteria.Criteria criteria=sql.createCriteria();
		criteria.andPriceCodeEqualTo(info.getPriceCode());
		
		List<CpPriceInfo> cpPriceInfoList = this.cpPriceInfoMapper.selectByExample(sql);
		CpPriceInfo cpPriceInfo = new CpPriceInfo();
		if(null != cpPriceInfoList){
			cpPriceInfo = cpPriceInfoList.get(0);
		}
		return cpPriceInfo;
	}



	@Override
	public void updateProductStatus(CpPriceInfo info) {
		CpPriceInfo infoNew = new CpPriceInfo();
		infoNew.setActiveStatus(info.getActiveStatus());
		//
		CpPriceInfoCriteria sql=new CpPriceInfoCriteria();
		CpPriceInfoCriteria.Criteria criteria=sql.createCriteria();
		criteria.andPriceCodeEqualTo(info.getPriceCode());
		criteria.andTenantIdEqualTo(info.getTenantId());
		
		this.cpPriceInfoMapper.updateByExampleSelective(infoNew, sql);
		
	}



    @Override
    public List<CpPriceInfo> getCpPriceInfoByPriceCodeLike(QueryInfoParams record) {
        
        CpPriceInfoCriteria cpPriceInfoCriteria=new CpPriceInfoCriteria();
        
        String code = record.getStandardId();
        String name = record.getPriceName();
        CpPriceInfoCriteria.Criteria criteria=cpPriceInfoCriteria.or();
        if(!StringUtil.isBlank(code)){
            criteria.andPriceCodeLike("%"+code+"%");
        }
        if(!StringUtil.isBlank(name)){
            criteria.andPriceNameLike("%"+name+"%");         
        }
        criteria.andTenantIdEqualTo(record.getTenantId());
        cpPriceInfoCriteria.setOrderByClause("CREATE_TIME desc");
        List<CpPriceInfo>  cpPriceInfoList=cpPriceInfoMapper.selectByExample(cpPriceInfoCriteria);
        return cpPriceInfoList;
    }



	@Override
	public List<CpPriceInfo> getActiveProduct(ProductQueryByIdListVO vo) {
		CpPriceInfoCriteria cpPriceInfoCriteria = new CpPriceInfoCriteria();
		CpPriceInfoCriteria.Criteria criteriaCpPriceInfo= cpPriceInfoCriteria.createCriteria();
		criteriaCpPriceInfo.andTenantIdEqualTo(vo.getTenantId());
		criteriaCpPriceInfo.andPriceCodeIn(vo.getProductIdList());
		return cpPriceInfoMapper.selectByExample(cpPriceInfoCriteria);
	}
}

