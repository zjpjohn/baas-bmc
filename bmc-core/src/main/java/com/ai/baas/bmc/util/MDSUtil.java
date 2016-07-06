package com.ai.baas.bmc.util;

import com.ai.opt.base.exception.SystemException;
import com.ai.paas.ipaas.mds.IMessageSender;
import com.ai.paas.ipaas.mds.MsgSenderFactory;
import com.ai.paas.ipaas.util.StringUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by xin on 16-4-12.
 */
public class MDSUtil {

    private static String topicId;

    private static Properties mdsConfig;

    public static void sendMessage(String message) throws IOException {
        if (mdsConfig == null) {
            mdsConfig = new Properties();
            InputStream inputStream = MDSUtil.class.getResourceAsStream("/mds.properties");
            if (inputStream == null) {
                throw new SystemException("mds.properties Cannot be find");
            }
            mdsConfig.load(inputStream);
            topicId = mdsConfig.getProperty("mds.topic");
            if (StringUtil.isBlank(topicId)) {
                throw new RuntimeException("mds.topic cannot be null");
            }
        }
        //opt-sdk升级到2.0后，此处报错，敬请研究下sdk里相关api 
//        IMessageSender sender = MsgSenderFactory.getClient(mdsConfig, topicId);
//        sender.send(message, message.length());
    }

}
