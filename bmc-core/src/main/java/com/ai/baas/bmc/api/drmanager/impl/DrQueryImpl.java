package com.ai.baas.bmc.api.drmanager.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.filter.ValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.drmanager.interfaces.IDrQuery;
import com.ai.baas.bmc.api.drmanager.parameters.BillQueryInputObject;
import com.ai.baas.bmc.api.drmanager.parameters.BillQueryOutputObject;
import com.ai.baas.bmc.api.drmanager.parameters.DrQueryInputObject;
import com.ai.baas.bmc.api.drmanager.parameters.DrQueryOutputObject;
import com.ai.baas.bmc.api.drmanager.parameters.DrQueryOutputObjectList;
import com.ai.baas.bmc.api.drmanager.parameters.OperatorFlowQueryInputObject;
import com.ai.baas.bmc.api.drmanager.parameters.OperatorFlowQueryOutputObject;
import com.ai.baas.bmc.api.drmanager.parameters.OperatorFlowQueryOutputObjectList;
import com.ai.baas.bmc.api.drmanager.parameters.UseQueryInputObject;
import com.ai.baas.bmc.api.drmanager.parameters.UseQueryOutputObject;
import com.ai.baas.bmc.api.drmanager.parameters.UseQueryOutputObjectList;
import com.ai.baas.bmc.api.drmanager.parameters.UseQueryOutputObjectSubListList;
import com.ai.baas.bmc.api.drmanager.parameters.UseQueryOutputObjectSubListProductList;
import com.ai.baas.bmc.context.Constants;
import com.ai.baas.bmc.dao.mapper.bo.BmcAccuDealer;
import com.ai.baas.bmc.dao.mapper.bo.BmcDrqueryFieldrule;
import com.ai.baas.bmc.dao.mapper.bo.BmcDrqueryRouterule;
import com.ai.baas.bmc.dao.mapper.bo.BmcUseQuery;
import com.ai.baas.bmc.service.atom.interfaces.IBmcDrqueryFieldruleAtomSV;
import com.ai.baas.bmc.service.atom.interfaces.IBmcDrqueryRouteruleAtomSV;
import com.ai.baas.bmc.service.business.interfaces.BmcSv;
import com.ai.baas.bmc.service.business.interfaces.IQueryBillSvc;
import com.ai.baas.bmc.service.business.interfaces.IUseQuantityQuerySvc;
import com.ai.baas.bmc.util.CheckUtil;
import com.ai.baas.bmc.util.MyHbaseUtil;
//import com.ai.opt.baas.failbill.HBaseProxy;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class DrQueryImpl implements IDrQuery {
    private static final Logger log = LogManager.getLogger(DrQueryImpl.class);
    
    //private org.apache.hadoop.hbase.client.Connection conn = HBaseProxy.getConnection();
    
    //add by shihua 2016-04-19 
    @Autowired
    private IBmcDrqueryFieldruleAtomSV bmcDrqueryFieldruleAtomSV;
    
    @Autowired
    private IBmcDrqueryRouteruleAtomSV bmcDrqueryRouteruleAtomSV;
    
 
    //当月使用量server层接口
    @Autowired
    private IUseQuantityQuerySvc aUseQuantityQuery;
    
    //账单查询服务server层接口
    @Autowired
    private IQueryBillSvc aQueryBillSvc;
    
    @Autowired
    private BmcSv bmcSv;
    
    private List<BMC_drQuery_fieldrule> m_mapFields;
    private Map<String, DrQueryInputObject> m_paramsDrQuery;
    
    //add by zhangbin
    private Map<String, OperatorFlowQueryInputObject> m_paramsDrQuery1;
    //end
    private Map<String, String> m_params;
    
    //输入输出的json 根
    private String strInParent;
    private String strOutParent;
   
    
    //查询结果
    private List<DrQueryOutputObject> m_liRecordSet;
 
    //add by zhangbin
    private List<OperatorFlowQueryOutputObject> m_liRecordSet1;
 
    //分页处理
    private int m_nDrQuerypageNum;
    private int m_nDrQuerypagecountNum; 
    
    private List<DrQueryOutputObjectList> m_drAllOutputList;
    
    private static ApplicationContext context;
    @Override
    public String drQuery(String param) throws BusinessException,SystemException
    {
        String strpam = null;
        strInParent = DrQueryInputObject.strInParent;
        strOutParent = DrQueryOutputObject.strOutParent;

        Gson gson=new Gson();
        //log.info("drQuery " + param);
        
        m_params = new HashMap<String, String>();
        m_paramsDrQuery = gson.fromJson(param, new TypeToken<Map<String, DrQueryInputObject>>() {}.getType()); //new HashMap<String, DrQueryField>();
        //log.info("parse parameters " + m_paramsDrQuery.get(strInParent));
        DrQueryInputObject dri = m_paramsDrQuery.get(strInParent);
        m_mapFields = new ArrayList<BMC_drQuery_fieldrule>();
        m_liRecordSet = new ArrayList<DrQueryOutputObject>();
        //1. 获取查询条件
        String str = dri.getTenantId();
        if (str == null)
        {
            log.info("parse parameters error !");
            return null;
        }
        m_params.put("tenantId", dri.getTenantId());
        m_params.put("systemId", dri.getSystemId());
        //m_params.put("msgSeq", dri.getMsgSeq());
        m_params.put("custId", dri.getCustId());
        m_params.put("subsId", dri.getSubsId());
        m_params.put("serviceNum", dri.getServiceNum());
        m_params.put("serviceType", dri.getServiceType());
        m_params.put("pageNum", dri.getPageNum());
        m_params.put("pagecountNum", dri.getPagecountNum());
        m_params.put("beginDate", dri.getBeginDate());
        m_params.put("endDate", dri.getEndDate());

        //2. 获取需要查询的字段配置
        if (m_params.size() == 0)
        {
            log.info("parse parameters error !");
            return null;
        }
        int ires = GetConfigFields();
        if (0 >= ires)
        {
            log.info("GetConfig error is " + ires);
            return null;
        }
        //3. 获取查询数据的具体限制条件 并形成sql条件
        String strQuery=validateParamsAndGetQueryWhereString(m_params, 1);
        if (strQuery == null)
        {
            log.info("validateParamsAndGetQueryWhereString error");
            return null;
        }
        //4. 查询并返回字符串 需要考虑分页问题
        strpam = GetResult(strQuery);
        if (m_liRecordSet.size() <= 0)
        {
            m_liRecordSet.add(new DrQueryOutputObject());
            m_liRecordSet.get(0).setReturnCode("BMC-000001");
        }
        else
            m_liRecordSet.get(0).setReturnCode("BMC-000000");
            
        strpam = gson.toJson(m_liRecordSet);
        
        if (null == strpam)
        {
            strpam = "{\"" + strOutParent + "\":{ \"returnCode\": \"BMC-000001\"} }";
        }
        else
        {
            strpam = strpam.substring(1, strpam.length() - 1);
            strpam = "{\"" + strOutParent + ":" + strpam + "}";
        }
            
        return strpam;
    }

    @Override
    public String billQuery(String param)  throws BusinessException,SystemException{
        // TODO Auto-generated method stub
        String str = "{\"responseMessage\":{ \"returnCode\":\"BMC-000002\",\"tenantId\":\"XXtenantId\",\"systemId\":\"XXsystemId\",\"msgSeq\":\"XXmsgSeq\",\"custId\":\"XXcustId\",\"sublist\":[{\"subsId\":\"XXsubsId\"}\",{\"subsId\":\"XXsubsId1\"}]}}";
        return str;
    }

    @Override
    public String useQuantityQuery(String param) throws BusinessException,SystemException {
        // TODO Auto-generated method stub
        String str = " {\"responseMessage\":{ \"returnCode\":\"BMC-000003\",\"tenantId\":\"XXtenantId\", " +
        "\"systemId\":\"XXsystemId\", \"msgSeq\":\"XXmsgSeq\", \"MonthList\":[ " +
        "{\"beginMonth\":\"XXbeginMonth\", \"custId\":\"XXcustId\", \"sublist\": " +
        "[{\"subsId\":\"XXsubsId1\",\"serviceType\":\"XXserviceType1\"},{\"subsId\":\"XXsubsId2\",\"serviceType\":\"XXserviceType2\"} ]} ]}} ";
        return str;
    }

    @Override
    public String operatorFlowQuery(String param) throws BusinessException,SystemException {
        // TODO Auto-generated method stub
        String str = "{\"responseMessage\":{ \"returnCode\":\"BMC-000004\",\"tenantId\":\"XXtenantId\",\"systemId\":\"XXsystemId\",\"msgSeq\":\"XXmsgSeq\",\"dealerCode\":\"1\",\"amount\":\"222\"}}";
        return str;
    }
    /** 
    * 通过字段获取查询所需的条件字符串
    *    
    * @param params 
    * @param flag  0 表示读取字段信息 不包括具体查询时间和页码
    * @return 
    *        条件字符串
    * @throws Exception 
    */  
    private String validateParamsAndGetQueryWhereString(Map<String, String> params, int flag) throws BusinessException,SystemException
    {
        String tenantId=params.get("tenantId");
        String systemId=params.get("systemId");
        //String msgSeq=params.get("msgSeq");
        String custId=params.get("custId");
        String subsId=params.get("subsId");
        String serviceNum=params.get("serviceNum");
        String serviceType=params.get("serviceType");

        if (null == tenantId || null == systemId || null == custId || null == subsId)
            return null;
        String strRes = " where 1=1 ";
        if (null != tenantId)
            strRes +=" and a.tenantId='" + tenantId + "' ";
        if (null != systemId)
            strRes += " and a.systemId='" + systemId + "' ";
        
        if (serviceType != null)
            strRes = strRes + " and a.serviceType='" + serviceType + "'";
        
        //如果设定分支为0 表示读取字段信息 不包括具体查询时间和页码
        if (flag == 0)
        {
            return strRes;
        }
        
        //下面三个字段是在详单表中才有的 查询字段定义时不做
//        if (null != msgSeq)
//            strRes += " and a.msgSeq='" + msgSeq + "' ";
        if (null != subsId)
            strRes += " and a.subsId='" + subsId + "' ";
        if (null != custId)
            strRes += " and a.custId='" + custId + "'";
        if (serviceNum != null)
            strRes = strRes + " and a.serviceNum='" + serviceNum + "'";
        
        //分页
        String pageNum=params.get("pageNum");
        if (StringUtil.isBlank(pageNum))
        {
            //如果没有输入值设定为1
            m_nDrQuerypageNum = 1;
        }
        else
            m_nDrQuerypageNum = Integer.parseInt(pageNum);
        String pagecountNum=params.get("pagecountNum");
        if (StringUtil.isBlank(pagecountNum))
        {
            //如果没有输入值 设定最大值1000
            m_nDrQuerypagecountNum = 1000;
        }
        else
            m_nDrQuerypagecountNum = Integer.parseInt(pagecountNum);
        //
        String beginDate=params.get("beginDate");
        String endDate=params.get("endDate");
        //表中只有 begintime字段 
        if (beginDate != null)
            strRes = strRes + " and a.beganTime>='" + beginDate + "'";
        if (endDate != null)
            strRes = strRes + " and a.beganTime<='" + endDate + "'";

        return strRes;
    }
    
    /** 
    * 获取需要配置的字段信息
    *    
    * @param  
    * @return 
    *        字段数. 
    */ 
    private int GetConfigFields()
    {
        int icn = 0;
        Connection conn =null;
        Statement statement = null;
        ResultSet rs = null;
        try{
            conn = DriverManager.getConnection(drqurl, drquser, drqpassword);
            statement = conn.createStatement();
            
            String sql="select tenantId, systemId, serviceType, a.Tableid, tablename, field_desc, field_name, field_type, field_length, parent_node, src_content, default_output from "
                    + " BMC_drQuery_routerule a, BMC_drQuery_fieldrule b ";
            
            String strQuery=validateParamsAndGetQueryWhereString(m_params, 0);
            //log.info("获取需要配置的字段信息-GetConfigFields");
            log.debug("获取需要配置的字段信息-GetConfigFields");
           // System.err.println("strQuery:"+strQuery);
            log.debug("strQuery:"+strQuery);
            
            if (strQuery !=null)
            {
                sql = sql + strQuery;
            }
         //   System.err.println("sql:"+sql);
            log.debug("sql:"+sql);
            rs = statement.executeQuery(sql);
            m_mapFields.clear();
            //log.debug("ResultSet"+JSON.toJSONString(rs));
            while (rs.next()) {
                BMC_drQuery_fieldrule obj = new BMC_drQuery_fieldrule();
                String tablename = rs.getString("tablename");
                obj.setTablename(tablename);
                String tableid = rs.getString("tableid");
                obj.setTableid(tableid);
                String field_desc = rs.getString("field_desc");
                obj.setField_desc(field_desc);
                String field_name = rs.getString("field_name");
                obj.setField_name(field_name);
                int field_type = rs.getInt("field_type");
                obj.setField_type(field_type);
                int field_length = rs.getInt("field_length");
                obj.setField_length(field_length);
                String parent_node = rs.getString("parent_node");
                obj.setParent_node(parent_node);
                String src_content = rs.getString("src_content");
                obj.setSrc_content(src_content);
                int default_output = rs.getInt("default_output");
                obj.setDefault_output(default_output);

                m_mapFields.add(obj);
                icn ++;
            }
           log.info("ResultSet"+JSON.toJSONString(m_mapFields));
            log.info("row count is " + icn);
            if (icn == 0)
                return 0;
        }catch(SQLException ex) {
        	log.debug("6666666");
 
            ex.printStackTrace();
            return -1;
        } finally{ 
           	try {
				statement.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        return icn;
    }

    private String GetResult(String sqlWhere)
    {
         try {
            Class.forName(drqdriver);
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }

         //先用group by 做一个分组查询  再查其中每一组的具体值
        try{
            String url = drqZookeeperUrl;
            Connection conn = DriverManager.getConnection(drqurl, drquser, drqpassword);
            Statement statement = conn.createStatement();

            //拼sql字符串
            String strTableName = m_mapFields.get(0).getTablename();
            String sql = "select ";

            int iloop = 0;
            String sqlfields = "";
            for (iloop = 0; iloop < m_params.size(); iloop ++)
            {
                if (m_mapFields.get(iloop).getParent_node().equals("drList"))
                    continue;
                
                if (m_mapFields.get(iloop).getField_name().equals("pageNum"))
                    continue;
                if (m_mapFields.get(iloop).getField_name().equals("pagecountNum"))
                    continue;               
                if (m_mapFields.get(iloop).getField_name().equals("beginDate"))
                    continue;
                if (m_mapFields.get(iloop).getField_name().equals("endDate"))
                    continue;               
                
                if (m_mapFields.get(iloop).getField_type() != 4)
                {
                    if (iloop == m_params.size() - 1)
                        sqlfields = sqlfields + " a." + m_mapFields.get(iloop).getField_name();
                    else
                        sqlfields = sqlfields + " a." + m_mapFields.get(iloop).getField_name() + ",";
                }
            }
            if (sqlfields.length() > 0)
                sqlfields = sqlfields.substring(0,sqlfields.length()-1);
            sql = sql + sqlfields + " from " + strTableName + "a a ";
            if (sqlWhere !=null)
            {
                sql = sql + sqlWhere;
            }
            sql = sql + " group by " + sqlfields;
            log.info("strTableName   :   "+strTableName);
            log.info("GetResult   ：   " + sql);
            //此处最好加返回条数限制
            ResultSet rs = statement.executeQuery(sql);

            try
            {
                Class clazz = Class.forName("com.ai.baas.bmc.api.drmanager.parameters.DrQueryOutputObject");
                m_liRecordSet = populate(rs, clazz);                
                
                //此处查具体的数据集 并作分页处理
                for (iloop = 0; iloop < m_liRecordSet.size(); iloop ++)
                {
                    int irescount = GetObjectFromDataRow(m_liRecordSet.get(iloop), conn, strTableName, sqlWhere);
                    if (irescount == 0)
                        log.info(m_liRecordSet.get(iloop).toString() + " record count==" + irescount);
                    else
                        log.info(" m_liRecordSet record count==" + irescount);
                }

                if (m_liRecordSet.size() == 0)
                {
                    log.info("m_liRecordSet.size ==0");
                    return "0";
                }
                
                //log.info(" m_liRecordSet record count==" + m_liRecordSet.size());
                //for test!!!
                m_liRecordSet.get(0).setReturnCode("BMC-000000");
                m_liRecordSet.get(0).setPageNum(Integer.toString(m_nDrQuerypageNum));
                m_liRecordSet.get(0).setTotalcount(Integer.toString(m_drAllOutputList.size()));
                Gson gson = new Gson();
                String gs = gson.toJson(m_liRecordSet);
                
                //log.info("gson.toJson(m_liRecordSet)" + gs);
                
            }catch (Exception e)
            {
                e.getMessage();
                e.printStackTrace();
                return null;
            }
            
            return Integer.toString(m_liRecordSet.size());
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /** 
        * Convert ResultSet to List, data format for Object 
        *    
        * @param rs 
        * @param clazz 
        * @return 
        *        A list of data object( For the some Class) instance. 
        * @throws Exception 
        */ 
    public static List populate(ResultSet rs, Class clazz) throws Exception
    { 
      //Get the element of resultSet 
        ResultSetMetaData metaData = rs.getMetaData();    
        //Get count 
        int colCount = metaData.getColumnCount();                     
        //Container 
        List ret = new ArrayList();             
        
        //Get Object attributes 
        java.lang.reflect.Field[] fields = clazz.getDeclaredFields();        
        //Construct it 
        while(rs.next()){ 

            Object newInstance = clazz.newInstance();     
            for(int i=1;i<=colCount;i++){     
                try{ 
                    Object value = rs.getObject(i); 
                    for(int j=0;j<fields.length;j++){ 
                        java.lang.reflect.Field f = fields[j];
                        String cn = metaData.getColumnLabel(i);
                        String fn = f.getName();
                        if(f.getName().equalsIgnoreCase(metaData.getColumnLabel(i).replaceAll("_",""))){ 
                            try
                            {
                                org.apache.commons.beanutils.BeanUtils.copyProperty(newInstance,f.getName(),value);
                            }catch (Exception ex)
                            {
                                log.error(f.getName());
                            }
                        } 
                    } 
                }catch (Exception e) { 
                    // TODO: handle exception 
                } 
            } 
            //Fill into 
            ret.add(newInstance); 
        } 
        //Back 
        return ret; 
    }
      
    /** 
    * GetObjectFromDataRow 从数据集中获取对象 此处考虑分页
    *    
    * @param rsbmc 
    * @param clazz 
    * @return 
    *        A list of data object( For the some Class) instance. 
    * @throws Exception 
    */ 
    private int GetObjectFromDataRow(DrQueryOutputObject rsbmc, Connection conn, String strTableName, String sqlWhere)
    {
        try
        {
            Statement statement = conn.createStatement();
            
            String sql = "Select ";
            
            String sqlfields = "";
            int iloop = 0;
            for (iloop = 0; iloop < m_mapFields.size(); iloop ++)
            {
                String strfieldname = m_mapFields.get(iloop).getField_name();
                if (m_mapFields.get(iloop).getParent_node().equals("drList") == false)
                    continue;
                
                if (m_mapFields.get(iloop).getField_name().equals("pageNum"))
                    continue;
                if (m_mapFields.get(iloop).getField_name().equals("pagecountNum"))
                    continue;               
                if (m_mapFields.get(iloop).getField_name().equals("beginDate"))
                    continue;
                if (m_mapFields.get(iloop).getField_name().equals("endDate"))
                    continue;               
                
                if (m_mapFields.get(iloop).getField_type() != 4)
                {
                    if (iloop == m_mapFields.size() - 1)
                        sqlfields = sqlfields + m_mapFields.get(iloop).getSrc_content();
                    else
                        sqlfields = sqlfields + m_mapFields.get(iloop).getSrc_content() + ",";
                }
            }
            if (sqlfields.length() > 0)
                sqlfields = sqlfields.substring(0,sqlfields.length()-1);
            sql = sql + sqlfields + " from " + strTableName + "a a, code_area_code b ";
            if (sqlWhere !=null)
            {
                sql = sql + sqlWhere + " and a.visitArea=b.province_code ";
            }
            else
            	sql = sql + " where a.visitArea=b.province_code ";
            sql = sql + " Order by serviceNum asc, serviceType asc, productId asc, roamType asc, beganTime asc";
            
            
            ResultSet rs = statement.executeQuery(sql);
            try
            {
                Class clazz = Class.forName("com.ai.baas.bmc.api.drmanager.parameters.DrQueryOutputObjectList");
                //全部数据集
                m_drAllOutputList = populate(rs, clazz);
                //log.info("m_drAllOutputList:" + m_drAllOutputList);
                //给分页的部分
                int nMinRecordNum = (m_nDrQuerypageNum - 1) * m_nDrQuerypagecountNum;
                int nMaxRecordNum = m_nDrQuerypageNum * m_nDrQuerypagecountNum;
                
                List<DrQueryOutputObjectList> drList = new ArrayList<DrQueryOutputObjectList>();
                for (iloop = nMinRecordNum; iloop < nMaxRecordNum; iloop++)
                {
                    if (m_drAllOutputList.size() > iloop)
                    {
                        DrQueryOutputObjectList dr = m_drAllOutputList.get(iloop);
                        drList.add(dr);
                    }
                    else
                        break;
                }
                rsbmc.setDrList(drList);
            }catch (Exception e)
            {
                e.getMessage();
                e.printStackTrace();
                conn.close();
                return -1;
            }
            conn.close();           
        }catch(SQLException ex) {
            ex.printStackTrace();
        }

        return 0;
    }
    //一行数据返回一个json串
    private String GetJsonStringFromDataRow(ResultSet rs)
    {
        String strRes = "";
        int iloop = 0;
        for (iloop = 0; iloop < m_mapFields.size(); iloop ++)
        {
            String strKey = "";
            String strValue = "";
            try
            {
                strKey = m_mapFields.get(iloop).getField_name();
                //mapOfColValues.put(md.getColumnName(i), rs.getObject(i));
                if (strKey.toUpperCase().equals("BEGINDATE") == true || strKey.toUpperCase().equals("BEGINDATE") == true)
                {
                    continue;
                }
                
                switch (m_mapFields.get(iloop).getField_type())
                {
                    case 0:
                    {
                        //int 
                        strValue = Integer.toString(rs.getInt(strKey));
                        strRes = strRes + strKey + ":" + strValue;
                        break;
                    }
                    case 1:
                    {
                        //NUM  
                        strValue = String.valueOf(rs.getString(strKey));
                        strRes = strRes + strKey + ":" + strValue;
                        break;                  
                    }
                    case 2:
                    {
                        //STR  
                        strValue = rs.getString(strKey);
                        strRes = strRes + strKey + ":" + strValue;
                        break;                  
                    }
                    case 3:
                    {
                        //DATE 
                        strValue = rs.getString(strKey);
                        strRes = strRes + strKey + ":" + strValue;
                        break;                          
                    }
                    case 4:
                    {
                        //LIST
                        //特别注意!!!
                        strRes = strRes + strKey + ":" + "\"\"";
                        break;
                    }
                    default:
                    {
                        strValue = String.valueOf(rs.getString(strKey));
                        strRes = strRes + strKey + ":" + strValue;
                        break;                  
                    }
                }
            }catch (SQLException ex) {
                ex.printStackTrace();
                
                strRes = strRes + strKey + ": \"\"";
            }
        }

        return strRes;
    }

    private void setFilters(DrQueryInputObject queryBean,Scan scan){
		FilterList filterList = new FilterList();
//		if(!StringUtil.isBlank(queryBean.getTenantId())){
//			filterList.addFilter(new RowFilter(CompareFilter.CompareOp.EQUAL,new SubstringComparator(queryBean.getTenantId())));
//		}
		if(!StringUtil.isBlank(queryBean.getCustId())){
			filterList.addFilter(new RowFilter(CompareFilter.CompareOp.EQUAL,new SubstringComparator(queryBean.getCustId())));
			log.debug("过滤条件+CustId{}={}",queryBean.getCustId(),JSONObject.fromObject(filterList).toString());
		}
		if(!StringUtil.isBlank(queryBean.getSubsId())){
			filterList.addFilter(new RowFilter(CompareFilter.CompareOp.EQUAL,new SubstringComparator(queryBean.getSubsId())));
			log.debug("过滤条件+SubsId{}={}",queryBean.getSubsId(),JSONObject.fromObject(filterList).toString());
		}
		if(!StringUtil.isBlank(queryBean.getServiceType())){
			filterList.addFilter(new RowFilter(CompareFilter.CompareOp.EQUAL,new SubstringComparator(queryBean.getServiceType())));
			log.debug("过滤条件+ServiceType{}={}",queryBean.getServiceType(),JSONObject.fromObject(filterList).toString());
		}
		if(!StringUtil.isBlank(queryBean.getServiceNum())){
			filterList.addFilter(new RowFilter(CompareFilter.CompareOp.EQUAL,new SubstringComparator(queryBean.getServiceNum())));
			log.debug("过滤条件+ServiceNum{}={}",queryBean.getServiceNum(),JSONObject.fromObject(filterList).toString());
		}
		if(!StringUtil.isBlank(queryBean.getBeginDate())){
			log.debug("区间范围BeginDate【{}】",queryBean.getBeginDate().trim());
			filterList.addFilter(new SingleColumnValueFilter(Bytes.toBytes(Constants.DR_QUERY_FAIMLY),
		              Bytes.toBytes("start_time"),
		              CompareFilter.CompareOp.GREATER_OR_EQUAL,new BinaryComparator(Bytes.toBytes(queryBean.getBeginDate().trim()))));
			log.debug("过滤条件+BeginDate{}={}",queryBean.getBeginDate(),JSONObject.fromObject(filterList).toString());
		}
		if(!StringUtil.isBlank(queryBean.getEndDate())){
			log.debug("区间范围endDate【{}】",queryBean.getEndDate().trim());
			filterList.addFilter(new SingleColumnValueFilter(Bytes.toBytes(Constants.DR_QUERY_FAIMLY),
		              Bytes.toBytes("start_time"),
		              CompareFilter.CompareOp.LESS_OR_EQUAL,new BinaryComparator(Bytes.toBytes(queryBean.getEndDate().trim()))));
			log.debug("过滤条件+EndDate{}={}",queryBean.getEndDate(),JSONObject.fromObject(filterList).toString());
		}
		if(!StringUtil.isBlank(queryBean.getApnCode())){
			
			if("APN1".equals(queryBean.getApnCode())||"APN2".equals(queryBean.getApnCode())){
				//filterList.addFilter(new RowFilter(CompareFilter.CompareOp.EQUAL,new SubstringComparator(queryBean.getApnCode())));	
				filterList.addFilter(new SingleColumnValueFilter( Bytes.toBytes(Constants.DR_QUERY_FAIMLY), Bytes.toBytes("apn_code"),CompareFilter.CompareOp.EQUAL, new SubstringComparator(queryBean.getApnCode())));	
				log.debug("过滤条件+apnCode{}={}",queryBean.getApnCode(),JSONObject.fromObject(filterList).toString());
			}
			
		}
		scan.setFilter(filterList);
		log.debug("过滤条件为{}",JSONObject.fromObject(filterList).toString());
	}
    
    private void setViewColumn(List<BmcDrqueryFieldrule> columns,Scan scan){
		for(BmcDrqueryFieldrule column:columns){
			if (column!=null) {
				log.debug("查询列信息为+【detail_bill:{}】",column.getFieldName().toLowerCase());
				scan.addColumn(Bytes.toBytes(Constants.DR_QUERY_FAIMLY), Bytes.toBytes(column.getFieldName().toLowerCase()));
			}
		}
	}
    
    /** 获取值
     * 
     */
    private String getCellValue(Result r, String name,String cellName) {
        return Bytes.toString(r.getValue(Bytes.toBytes(name), Bytes.toBytes(cellName)));
    }
    
    private void setQueryResult(ResultScanner scanner,List<BmcDrqueryFieldrule> columns,DrQueryOutputObject drres,DrQueryInputObject drObject){
		List<DrQueryOutputObjectList> drList = new ArrayList<DrQueryOutputObjectList>();
		int size = 0;
		BeanUtils.copyVO(drres, drObject);
		int pageStart = 0;
		int pageEnd = 0;
		log.debug("查询返回对象为【{}】",JSONObject.fromObject(scanner).toString());
		if (!StringUtil.isBlank(drObject.getPagecountNum())&&!StringUtil.isBlank(drObject.getPageNum())) {
			pageEnd = Integer.parseInt(drObject.getPageNum()) * Integer.parseInt(drObject.getPagecountNum());
			pageStart = pageEnd-Integer.parseInt(drObject.getPagecountNum())+1;
		}
		for (Result res : scanner) {
			size++;
			log.debug("查询回来数据第【{}】条,信息为{}",size,res.getFamilyMap(Bytes.toBytes(Constants.DR_QUERY_FAIMLY)).toString());
			if (pageStart>0&&pageEnd>0&&size<pageStart&&size>pageEnd) {
				continue;//不在分页范围内
			}
			DrQueryOutputObjectList object = new DrQueryOutputObjectList();
			object.setProductId(getCellValue(res,Constants.DR_QUERY_FAIMLY, "product_id"));
			object.setRoamType(getCellValue(res,Constants.DR_QUERY_FAIMLY, "roam_type"));
			object.setLongType(getCellValue(res,Constants.DR_QUERY_FAIMLY, "long_type"));
			object.setFee(getCellValue(res,Constants.DR_QUERY_FAIMLY, "fee"));
			object.setVisitArea(getCellValue(res,Constants.DR_QUERY_FAIMLY, "visit_area"));
			object.setUpStream(getCellValue(res,Constants.DR_QUERY_FAIMLY, "gprs_up"));
			object.setDownStream(getCellValue(res,Constants.DR_QUERY_FAIMLY, "gprs_down"));
			object.setBeganTime(getCellValue(res,Constants.DR_QUERY_FAIMLY, "start_time"));
			object.setDuration(getCellValue(res,Constants.DR_QUERY_FAIMLY, "duration"));
			object.setApnCode(getCellValue(res,Constants.DR_QUERY_FAIMLY,"apn_code"));
			drres.setServiceNum(getCellValue(res,Constants.DR_QUERY_FAIMLY, "service_num"));
			log.debug("查询结果拼接："+JSONObject.fromObject(object).toString());
			drList.add(object);
		}
		drres.setTotalcount(size+"");
		drres.setDrList(drList);
	}
    
    @Override
    public DrQueryOutputObject drQueryObj(DrQueryInputObject drObject)  throws BusinessException,SystemException{
        //入参检查
        CheckUtil.checkNull(drObject.getTenantId(), "tenantId", "BMC-000001");
        CheckUtil.checkNull(drObject.getSystemId(), "systemId", "BMC-000001");
        CheckUtil.checkNull(drObject.getMsgSeq(), "msgSeq", "BMC-000001");
        CheckUtil.checkNull(drObject.getCustId(), "custId", "BMC-000001");
        CheckUtil.checkNull(drObject.getSubsId(), "subsId", "BMC-000001");
        CheckUtil.checkNull(drObject.getServiceType(), "serviceType", "BMC-000001");
        CheckUtil.checkLenth(drObject.getTenantId(), "tenantId", 32, "BMC-000001");
        CheckUtil.checkLenth(drObject.getSystemId(), "systemId", 32, "BMC-000001");
        CheckUtil.checkLenth(drObject.getMsgSeq(), "msgSeq", 32, "BMC-000001");
        CheckUtil.checkLenth(drObject.getCustId(), "custId", 32, "BMC-000001");
        CheckUtil.checkLenth(drObject.getSubsId(), "subsId", 32, "BMC-000001");
        CheckUtil.checkLenth(drObject.getServiceNum(), "serviceNum", 32, "BMC-000001");
        CheckUtil.checkLenth(drObject.getServiceType(), "serviceType", 32, "BMC-000001");
        CheckUtil.checkLenth(drObject.getPageNum(), "pageNum", 32, "BMC-000001");
        CheckUtil.checkLenth(drObject.getPagecountNum(), "pagecountNum", 32, "BMC-000001");
        if(!StringUtil.isBlank(drObject.getApnCode())){
        	 if (!"APN1".equals(drObject.getApnCode())&&!"APN2".equals(drObject.getApnCode())&&!"ALL".equals(drObject.getApnCode())) {
             	throw new BusinessException("BMC-000001",  "apnCode不合法");
             }
        }
       
        DrQueryOutputObject drres = new DrQueryOutputObject();
        //1.查询mysql获取对应的表名
        BmcDrqueryRouterule routeRuleReq = new BmcDrqueryRouterule();
        routeRuleReq.setTenantid(drObject.getTenantId());
//        routeRuleReq.setSystemid(drObject.getSystemId());//TODO  是否需要根据系统Id作为条件查询
        routeRuleReq.setServicetype(drObject.getServiceType());
        log.debug("查询表名入参信息为:"+JSONObject.fromObject(routeRuleReq).toString());
        List<BmcDrqueryRouterule> bmcDrqueryRouterules = bmcDrqueryRouteruleAtomSV.queryBmcDrqueryRouterules(routeRuleReq);
        log.debug("查询表名返回信息为:"+JSONArray.fromObject(bmcDrqueryRouterules).toString());
        if (CollectionUtil.isEmpty(bmcDrqueryRouterules)) {
        	log.error("未维护详单查询路由配置信息表数据,具体信息如下"+JSONObject.fromObject(routeRuleReq));
        	drres.setReturnCode("BMC-000003" + "详单查询路由相关信息未配置，请检查参数信息！" );
            return drres;
//        	throw new BusinessException("BMC-000003", "详单查询路由相关信息未配置，请联系相关管理员维护！");
		}
        BmcDrqueryRouterule routerule = bmcDrqueryRouterules.get(0);
        if (routerule==null) {
        	log.error("未维护详单查询路由配置信息表数据,具体信息如下"+JSONObject.fromObject(routeRuleReq));
        	drres.setReturnCode("BMC-000003" + "详单查询路由相关信息未配置，请检查参数信息！" );
            return drres;
		}
        //2.根据tableid去查询需要返回哪些列  列簇固定为detail_bill
        BmcDrqueryFieldrule fieldruleReq  = new BmcDrqueryFieldrule();
        fieldruleReq.setTableid(routerule.getTableid());
        List<BmcDrqueryFieldrule> fieldrules = bmcDrqueryFieldruleAtomSV.queryBmcDrqueryFieldrules(fieldruleReq);
        if (CollectionUtil.isEmpty(fieldrules)) {
        	log.error("未维护详单查询字段输出配置信息表数据,具体信息如下"+JSONObject.fromObject(fieldruleReq));
        	drres.setReturnCode("BMC-000004" + "详单查询字段输出配置信息未配置，请检查参数信息！" );
            return drres;
		}
        log.info("查询列信息为"+JSONArray.fromObject(fieldrules).toString());
        String nowString ="";
//        List<String> yearMonths = new ArrayList<String>();
//        if (!StringUtil.isBlank(drObject.getBeginDate())&&!StringUtil.isBlank(drObject.getEndDate())) {
//        	Long yearMonth = null;
//			try {
//				yearMonth = Long.parseLong((drObject.getBeginDate().trim()).substring(0, 4));
//				if (yearMonth>nowLong) {
//					throw new BusinessException,SystemException("BMC-000001",   "传入的开始时间不能超过当前时间，请检查");
//				}
//			} catch (Exception e) {
//				throw new BusinessException,SystemException("BMC-000001","传入的开始时间不符规范，请检查",e);
//			}
//		}
        if (!StringUtil.isBlank(drObject.getBeginDate())) {
        	nowString = (drObject.getBeginDate().trim()).substring(0, 6);
        }else if (StringUtil.isBlank(drObject.getBeginDate())&&!StringUtil.isBlank(drObject.getEndDate())) {
        	nowString = (drObject.getEndDate().trim()).substring(0, 6);
		}else {
			 nowString =DateUtil.getDateString(DateUtil.getSysDate(), DateUtil.YYYYMM);
		}
		Table table = null;
		try {
			table = MyHbaseUtil.getTable(routerule.getTablename()+nowString);//conn.getTable(TableName.valueOf(routerule.getTablename()+nowString));
		} catch (Exception e) {
			log.error("获取hbase表对象失败，请检查配置！",e);
        	drres.setReturnCode("BMC-000004" + "表信息配置错误，请检查配置！" );
            return drres;
		}
		//3.查询hbase
		Scan scan = new Scan();
		setFilters(drObject,scan);
		setViewColumn(fieldrules,scan);
		ResultScanner scanner = null;
		try {
			scanner = table.getScanner(scan);
		} catch (IOException e) {
			log.error("查询hbase异常:",e);
			drres.setReturnCode("BMC-000004" + "查询出错！" );
            return drres;

		}
		//4.将hbase中的数据转换返回
		if (scanner!=null) {
			setQueryResult(scanner,fieldrules,drres,drObject);
			scanner.close();
		}
		drres.setReturnCode("BMC-000000");
		log.debug("详单查询信息为【{}】",JSONObject.fromObject(drres).toString());
        return drres;
        
        
//        String strpam = null;
//        
//        strInParent = DrQueryInputObject.strInParent;
//        strOutParent = DrQueryOutputObject.strOutParent;
//
//        m_params = new HashMap<String, String>();
//
//        m_paramsDrQuery = new HashMap<String, DrQueryInputObject>();
//        m_paramsDrQuery.put("DrQuery", drObject);
//        
//        m_mapFields = new ArrayList<BMC_drQuery_fieldrule>(); //BMC_drQuery_fieldrule
//        m_liRecordSet = new ArrayList<DrQueryOutputObject>();
//        //1. 获取查询条件
//        m_params.put("tenantId", drObject.getTenantId());
//        m_params.put("systemId", drObject.getSystemId());
//        m_params.put("custId", drObject.getCustId());
//        m_params.put("subsId", drObject.getSubsId());
//        m_params.put("serviceNum", drObject.getServiceNum());
//        m_params.put("serviceType", drObject.getServiceType());
//        m_params.put("pageNum", drObject.getPageNum());
//        m_params.put("pagecountNum", drObject.getPagecountNum());
//        m_params.put("beginDate", drObject.getBeginDate());
//        m_params.put("endDate", drObject.getEndDate());
//
//        int ires = GetConfigFields();
//        log.debug("ires : "+ires);
//        if (0 >= ires) {
//            log.info("GetConfigFields error is " + ires);
//            drres.setReturnCode("BMC-000003" + " not found Config parameters error is " + ires);
//            drres.setTenantId(drObject.getTenantId());
//            drres.setSystemId(drObject.getSystemId());
//            drres.setCustId(drObject.getCustId());
//            drres.setSubsId(drObject.getSubsId());
//        	drres.setMsgSeq(drObject.getMsgSeq());
//        	drres.setServiceType(drObject.getServiceType());            
//            return drres;
//        }
//        //3. 获取查询数据的具体限制条件 并形成sql条件
//        log.debug("AAAA");
//        String strQuery=validateParamsAndGetQueryWhereString(m_params, 1);
//        log.debug("BBBB");
//        if (strQuery == null)
//        {
//            log.info("validateParamsAndGetQueryWhereString error");
//            drres.setReturnCode("BMC-000004 validate Params and get query where string error");
//            drres.setTenantId(drObject.getTenantId());
//            drres.setSystemId(drObject.getSystemId());
//            drres.setCustId(drObject.getCustId());
//            drres.setSubsId(drObject.getSubsId());
//        	drres.setMsgSeq(drObject.getMsgSeq());
//        	drres.setServiceType(drObject.getServiceType());       
//        	return drres;            
//        }
//        //4. 查询并返回字符串 需要考虑分页问题
//        strpam = GetResult(strQuery);
//        if (m_liRecordSet.size() <= 0)
//        {
//            m_liRecordSet.add(new DrQueryOutputObject());
//            m_liRecordSet.get(0).setReturnCode("BMC-000001 not found data");
//        	m_liRecordSet.get(0).setTenantId(drObject.getTenantId());
//        	m_liRecordSet.get(0).setSystemId(drObject.getSystemId());
//        	m_liRecordSet.get(0).setCustId(drObject.getCustId());
//        	m_liRecordSet.get(0).setSubsId(drObject.getSubsId());
//        	m_liRecordSet.get(0).setMsgSeq(drObject.getMsgSeq());
//        	m_liRecordSet.get(0).setServiceType(drObject.getServiceType());
//        }
//        else
//        {
//        	m_liRecordSet.get(0).setReturnCode("BMC-000000");
//        	m_liRecordSet.get(0).setTenantId(drObject.getTenantId());
//        	m_liRecordSet.get(0).setSystemId(drObject.getSystemId());
//        	m_liRecordSet.get(0).setCustId(drObject.getCustId());
//        	m_liRecordSet.get(0).setSubsId(drObject.getSubsId());
//        	m_liRecordSet.get(0).setMsgSeq(drObject.getMsgSeq());
//        	m_liRecordSet.get(0).setServiceType(drObject.getServiceType());
//        }
//    
//        log.info("return DrQueryOutputObject");
//        return (DrQueryOutputObject)m_liRecordSet.get(0);
    }

    /**BMC-0004
     * 
     */
    @Override
    public BillQueryOutputObject billQueryObj(BillQueryInputObject billObject)  throws BusinessException,SystemException{ 

        //输入null 返回错误码"BMC-000001"
        if(billObject == null){
            throw new BusinessException("BMC-000001", "输入参数不能为空");
        }else{
            log.debug("billObject = [" + billObject.toString() + "]");
        }
        
        //入参检查
        CheckUtil.checkNull(billObject.getTenantId(), "tenantId", "BMC-000001");
        CheckUtil.checkNull(billObject.getSystemId(), "systemId", "BMC-000001");
        CheckUtil.checkNull(billObject.getMsgSeq(), "msgSeq", "BMC-000001");
        CheckUtil.checkNull(billObject.getCustId(), "custId", "BMC-000001");
        CheckUtil.checkNull(billObject.getFlag()+"", "flag", "BMC-000001");
        
        CheckUtil.checkLenth(billObject.getTenantId(), "tenantId", 32, "BMC-000001");
        CheckUtil.checkLenth(billObject.getSystemId(), "systemId", 32, "BMC-000001");
        CheckUtil.checkLenth(billObject.getMsgSeq(), "msgSeq", 32, "BMC-000001");
        CheckUtil.checkLenth(billObject.getCustId(), "custId", 32, "BMC-000001");
        CheckUtil.checkLenth(billObject.getSubsId(), "subsId", 32, "BMC-000001");
        CheckUtil.checkLenth(billObject.getServiceNum(), "serviceNum", 32, "BMC-000001");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowTime = sdf.format(new Date());
        if(StringUtil.isBlank(billObject.getQueryStartTime()) ){
            billObject.setQueryStartTime(nowTime);
        }
        
        if( StringUtil.isBlank(billObject.getQueryEndTime())){
            billObject.setQueryEndTime(nowTime);
        }
        
        if(billObject.getPageNum() == null){
            billObject.setPageNum(1) ;
        }
        
        if(billObject.getPageCountNum() == null){
            billObject.setPagecountNum(30) ;
        }

//        
//        //设置responseMessage节点的非List属性
//        output.setTenantId(billList.get(0).getTenantId());
//        output.setSystemId(billList.get(0).getSystemId().toString());
//        output.setMsgSeq(billObject.getMsgSeq());
//        output.setCustId(billList.get(0).getCustId().toString());
////        output.setTotalcount(aQueryBillSvc.getBillCount(billObject).toString());
////        if(!StringUtil.isBlank(billObject.getQueryMon())){
////            output.setQueryMon(billObject.getQueryMon());
////        }
////        output.setSublist(new ArrayList<BillQueryOutputObjectList>());
////        
////        //遍历查询结果,整合成一个对象
////        for(BmcQueryBill b : billList){
////            
////            BillQueryOutputObjectList subs = null;
////            //遍历sublist节点，如果该记录已存在就获得该记录，不存在就创建并添加到sublist中去
////            boolean bool = true;
////            for(BillQueryOutputObjectList s : output.getSublist()){
////                if(b.getSubsId().toString().equals(s.getSubsId())){
////                    subs = s;
////                    //log.info(111);
////                    bool = false;
////                    break;
////                }
////            }
////            if(bool){
////                subs = new BillQueryOutputObjectList();
////                subs.setSubsId(b.getSubsId().toString());
////                subs.setDisFee(Integer.parseInt(b.getDisFee().toString()));
////                subs.setAdjustFee(Integer.parseInt(b.getAdjustFee().toString()));
////                subs.setTotalfee(Integer.parseInt(b.getTotalFee().toString()));
////                subs.setSubjcetDetails(new ArrayList<BillQueryOutputObjectListsubjcetDetail>());
////                output.getSublist().add(subs);
////            }
////            
////            //创建subjcetDetails节点
////            BillQueryOutputObjectListsubjcetDetail subject = new BillQueryOutputObjectListsubjcetDetail();
////            subject.setSubjectId(Integer.parseInt(b.getSubjectId().toString()));
////            subject.setSubjectAisFee(Integer.parseInt(b.getSubjectAisFee().toString()));
////            subject.setSubjcetAdjustFee(Integer.parseInt(b.getSubjectAdjustFee().toString()));
////            subject.setSubjectfee(Integer.parseInt(b.getSubjectFee().toString()));
////            subject.setPageNum(billObject.getPageNum());
////            
////            subs.getSubjcetDetails().add(subject);  
////        }
//        output.setReturnCode("BMC-000000");
//        return output;

        BillQueryOutputObject bqo = aQueryBillSvc.billQueryObj(billObject);
        
        bqo.setCustId(billObject.getCustId());
        bqo.setMsgSeq(billObject.getMsgSeq());
        bqo.setPageNum(billObject.getPageNum() + "");
        
        bqo.setQueryEndTime(billObject.getQueryEndTime());
        bqo.setQueryStartTime(billObject.getQueryStartTime());
        bqo.setSystemId(billObject.getSystemId());
        bqo.setTenantId(billObject.getTenantId());

        bqo.setReturnCode("BMC-000000");

        return bqo;
    }

    /**
     * 用户使用量查询
     */
    @Override
    public UseQueryOutputObject useQuantityQueryObj(UseQueryInputObject useObject)  throws BusinessException,SystemException{
//        logger.info("DrQueryImpl.useQuantityQueryObj() CustId = [" + useObject.getCustId() + "] MsgSeq = [" + useObject.getMsgSeq() + "] BeginMonth = ["+ useObject.getBeginMonth() + "]");
        List<BmcUseQuery> useQueryList = null;
        UseQueryOutputObject output = new UseQueryOutputObject();           
        
        //输入null 返回错误码"BMC-000001"
        if(useObject == null){
            output.setReturnCode("BMC-000001");
            return output;
        }
        
        //入参检查
        CheckUtil.checkNull(useObject.getTenantId(), "tenantId", "BMC-000001");
        CheckUtil.checkNull(useObject.getSystemId(), "systemId", "BMC-000001");
        CheckUtil.checkNull(useObject.getMsgSeq(), "msgSeq", "BMC-000001");
        CheckUtil.checkNull(useObject.getCustId(), "custId", "BMC-000001");
        CheckUtil.checkNull(useObject.getSubsId(), "subsId", "BMC-000001");
        
        CheckUtil.checkLenth(useObject.getTenantId(), "tenantId", 32, "BMC-000001");
        CheckUtil.checkLenth(useObject.getSystemId(), "systemId", 32, "BMC-000001");
        CheckUtil.checkLenth(useObject.getMsgSeq(), "msgSeq", 32, "BMC-000001");
        CheckUtil.checkLenth(useObject.getCustId(), "custId", 32, "BMC-000001");
        CheckUtil.checkLenth(useObject.getSubsId(), "subsId", 32, "BMC-000001");
        CheckUtil.checkLenth(useObject.getServiceNum(), "serviceNum", 32, "BMC-000001");
        CheckUtil.checkLenth(useObject.getBeginMonth(), "beginMonth", 32, "BMC-000001");
        
        useQueryList = aUseQuantityQuery.selectUseQuery(useObject);

        if(CollectionUtil.isEmpty(useQueryList)){
            output.setReturnCode("未查到");
            return output;
        }
        
        
        log.debug("FOUND ONE ...");
        try {
            //设置responseMessage节点的非list的属性
            output.setTenantId(useQueryList.get(0).getTenantId().toString());
            output.setSystemId(useQueryList.get(0).getSystemId().toString());
            output.setMsgSeq(useObject.getMsgSeq());
            output.setMonthList(new ArrayList<UseQueryOutputObjectList>());
            int num = DateUtil.getTimeDifference(useObject.getBeginMonth(), DateUtil.getDateString(DateUtil.YYYYMM));
            String beginMonth = useObject.getBeginMonth();
            for(int i = 0;i < num + 1;i ++){
                UseQueryOutputObjectList init = new UseQueryOutputObjectList();
                init.setBeginMonth(beginMonth);
//                beginMonth = DateUtil.getDateString(
//                        DateUtil.getTimeNextMonthFirstSec(
//                                DateUtil.getTimestamp(beginMonth,DateUtil.YYYYMM)),
//                        DateUtil.YYYYMM);
                init.setCustId(useObject.getCustId());
                init.setSubsId(new ArrayList<UseQueryOutputObjectSubListList>());
                output.getMonthList().add(init);
                System.err.println(beginMonth);
                beginMonth = DateUtil.getOffsetMonth(beginMonth,1);
            }
            
            //遍历查询结果
            for(BmcUseQuery b : useQueryList){
                //遍历已存在的monthlist节点，如果有则获得该节点对象，没有则创建该节点并加入monthlist节点
                UseQueryOutputObjectList month = null;
                boolean bool = true;
                for(UseQueryOutputObjectList m : output.getMonthList()){
                    if(b.getBeginMonth().equals(m.getBeginMonth())){
                        month = m;
                        bool = false;
                        break;
                    }
                }
                if(bool){
                    month = new UseQueryOutputObjectList();
                    month.setCustId(b.getCustId().toString());
                    month.setBeginMonth(b.getBeginMonth());
                    month.setSubsId(new ArrayList<UseQueryOutputObjectSubListList>());
                    output.getMonthList().add(month);
                }
                
                //遍历sublist节点，如果存在获得该节点，如果不存在则创建该节点，并加入sublist节点
                UseQueryOutputObjectSubListList sub = null;
                bool = true;
                for(UseQueryOutputObjectSubListList s : month.getSubList()){
                    if(b.getSubsId().toString().equals(s.getSubsId())){
                        sub = s;
                        bool = false;
                        break;
                    }
                }
                if(bool){
                    sub = new UseQueryOutputObjectSubListList();
                    sub.setSubsId(b.getSubsId().toString());
                    sub.setServiceType(b.getServiceType());
                    sub.setServiceNum(b.getServiceNum());
                    sub.setProductList(new ArrayList<UseQueryOutputObjectSubListProductList>());
                    month.getSubList().add(sub);
                }
                
                //创建productlist节点对象，并加入productlist节点
                UseQueryOutputObjectSubListProductList product = new UseQueryOutputObjectSubListProductList();
                product.setProductId(b.getProductId().toString());
                product.setVisitArea(b.getVisitArea());
                product.setResType(b.getResType());
                product.setAmount(b.getAmount().toString());
                product.setProductAmount(b.getProductAmount().toString());
                
                sub.getProductList().add(product);
               
            }
            output.setReturnCode("BMC-000000");
            
            return output;
            
        } catch (Exception e) {
            log.error("异常：" + e.getMessage());
            output.setReturnCode("401");
            return output;
        }
    }

    
    @Override
    public OperatorFlowQueryOutputObject operatorFlowQueryObj(OperatorFlowQueryInputObject operatorFlowObject)  throws BusinessException,SystemException{        
        //入参检查
        CheckUtil.checkNull(operatorFlowObject.getTenantId(), "tenantId", "BMC-000001");
        CheckUtil.checkNull(operatorFlowObject.getSystemId(), "systemId", "BMC-000001");
        CheckUtil.checkNull(operatorFlowObject.getMsgSeq(), "msgSeq", "BMC-000001");
        
        CheckUtil.checkLenth(operatorFlowObject.getTenantId(), "tenantId", 32, "BMC-000001");
        CheckUtil.checkLenth(operatorFlowObject.getSystemId(), "systemId", 32, "BMC-000001");
        CheckUtil.checkLenth(operatorFlowObject.getMsgSeq(), "msgSeq", 32, "BMC-000001");
        CheckUtil.checkLenth(operatorFlowObject.getDealerCode(), "dealerCode", 1, "BMC-000001");
        CheckUtil.checkLenth(operatorFlowObject.getDealerAreaCode(), "dealerAreaCode", 32, "BMC-000001");
        CheckUtil.checkLenth(operatorFlowObject.getPageNum(), "pageNum", 32, "BMC-000001");
        CheckUtil.checkLenth(operatorFlowObject.getPagecountNum(), "pagecountNum", 32, "BMC-000001");
        
        //查询总条数
         int Count;
         String totalcount;      
         Count = bmcSv.operatorAccuQueryCount(operatorFlowObject);
         log.info("----------- record count==" + Count);
         totalcount = Integer.toString(Count);
         
         //查询记录
         List<BmcAccuDealer> aList = bmcSv.operatorAccuQuery(operatorFlowObject);
         OperatorFlowQueryOutputObject aOperatorFlowQueryOutputObject = new OperatorFlowQueryOutputObject();
         aOperatorFlowQueryOutputObject.setTenantId(operatorFlowObject.getTenantId());
         aOperatorFlowQueryOutputObject.setSystemId(operatorFlowObject.getSystemId());
         aOperatorFlowQueryOutputObject.setMsgSeq(operatorFlowObject.getMsgSeq());
         aOperatorFlowQueryOutputObject.setPageNum(operatorFlowObject.getPageNum());
         aOperatorFlowQueryOutputObject.setTotalcount(totalcount);
         
         List<OperatorFlowQueryOutputObjectList> aOperatorFlowQueryOutputObjectList = new ArrayList<OperatorFlowQueryOutputObjectList>();
         
         for(int i = 0; i < aList.size(); i++){
             BmcAccuDealer aBmcAccuDealer = null;
             OperatorFlowQueryOutputObjectList aOperatorFlowOutputObject = new OperatorFlowQueryOutputObjectList();      
             aBmcAccuDealer = aList.get(i);
             aOperatorFlowOutputObject.setDealerCode(aBmcAccuDealer.getDealercode());
             aOperatorFlowOutputObject.setDealerAreaCode(aBmcAccuDealer.getDealerareacode());
             aOperatorFlowOutputObject.setAmount(aBmcAccuDealer.getAmount());
             aOperatorFlowOutputObject.setChannel(aBmcAccuDealer.getChannel());      
             aOperatorFlowQueryOutputObjectList.add(aOperatorFlowOutputObject);      
         }       
         aOperatorFlowQueryOutputObject.setTenantIdlist(aOperatorFlowQueryOutputObjectList);
         
         if (aList.size() <= 0)
        {
            aOperatorFlowQueryOutputObject.setReturnCode("BMC-000001");
        }
        else
            aOperatorFlowQueryOutputObject.setReturnCode("BMC-000000");
         
        return aOperatorFlowQueryOutputObject;
    }


    //定义JDBC需要的参数
    private static String drqdriver = null;
    private static String drqurl = null;
    private static String drquser = null;
    private static String drqpassword = null;
    
    private static String drqHBasedriver = null;
    private static String drqZookeeperUrl = null;

    static {
        //可以保证只加载一次，而且调用的时候肯定已经加载完成
    	//context =new ClassPathXmlApplicationContext("./context/core-context.xml");
		//可以保证只加载一次，而且调用的时候肯定已经加载完成
		try {
			//获取数据库配置信息
			Properties properties = new Properties();
			//加载配置文件
			properties.load(DrQueryImpl.class.getClassLoader().getResourceAsStream("./context/jdbc.properties"));
			//获取配置文件里的配置信息
			drqdriver = properties.getProperty("jdbc.driverClassName");
			drqurl = properties.getProperty("jdbc.url");
			drquser = properties.getProperty("jdbc.username");
			drqpassword = properties.getProperty("jdbc.password");
			
			drqZookeeperUrl = properties.getProperty("jdbc.drqZookeeperUrl");
			
			//加载驱动
			Class.forName(drqdriver);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("context", e);
			//e.printStackTrace();
		} catch (IOException e) {
		    throw new RuntimeException("context", e);
        }
    }   
}
