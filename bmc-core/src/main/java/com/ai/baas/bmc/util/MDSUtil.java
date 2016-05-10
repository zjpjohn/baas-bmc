package com.ai.baas.bmc.util;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.components.mds.MDSClientFactory;
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

    public static void sendMessage(String mdsns ,String message) throws IOException {
        IMessageSender sender = MDSClientFactory.getSenderClient(mdsns);
        sender.send(message, 0);
    }

}
