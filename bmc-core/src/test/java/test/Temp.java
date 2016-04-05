package test;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.ai.baas.bmc.util.DshmUtil;

public class Temp {
    public static void main(String[] args) {
        Map<String,String> params = new TreeMap<String,String>();
        params.put("price_code", "999"); 
        params.put("tenant_id", "VIV-BYD");
        List<Map<String, String>> results=DshmUtil.getClient().list("cp_price_info")
             .where(params)
             .executeQuery(DshmUtil.getCacheClient());
        for (Map<String, String> map : results){
          for(Entry<String, String> result:map.entrySet()){
             System.out.println("the key is "+result.getKey()+"="+result.getValue());
          }
        }
    }
}
