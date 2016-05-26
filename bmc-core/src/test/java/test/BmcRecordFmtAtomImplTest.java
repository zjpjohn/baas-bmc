package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.dao.mapper.bo.BmcRecordFmt;
import com.ai.baas.bmc.service.atom.interfaces.IBmcRecordFmtAtomSV;

import net.sf.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class BmcRecordFmtAtomImplTest {
    
    @Autowired
    IBmcRecordFmtAtomSV iBmcRecordFmtAtom;
    
    @Test
    public void test(){
        
        BmcRecordFmt record = new BmcRecordFmt();
        record.setTenantId("TEST");
        record.setSource("TEST");
        record.setServiceType("TEST");
        System.out.println("入参:"+ JSONObject.fromObject(record));
        //iBmcRecordFmtAtom.add(record);
    }
}
