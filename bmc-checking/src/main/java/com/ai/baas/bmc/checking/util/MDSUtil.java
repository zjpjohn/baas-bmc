package com.ai.baas.bmc.checking.util;

import com.ai.paas.ipaas.mds.IMessageSender;
import com.ai.paas.ipaas.mds.MsgSenderFactory;
import com.ai.paas.ipaas.util.StringUtil;

import java.util.Properties;

/**
 * Created by xin on 16-4-1.
 */
public class MDSUtil {

    private static Properties mdsConfig;
    private static String topicId;

    public static void init(Properties config) {
        mdsConfig = new Properties();
        mdsConfig.setProperty("metadata.broker.list", config.getProperty("metadata.broker.list"));
        mdsConfig.setProperty("serializer.class", config.getProperty("serializer.class"));
        mdsConfig.setProperty("key.serializer.class", config.getProperty("key.serializer.class"));
        mdsConfig.setProperty("partitioner.class", config.getProperty("partitioner.class"));
        mdsConfig.setProperty("request.required.acks", config.getProperty("request.required.acks"));
        mdsConfig.setProperty("queue.buffering.max.messages", config.getProperty("queue.buffering.max.messages"));
        mdsConfig.setProperty("producer.type", config.getProperty("producer.type"));
        mdsConfig.setProperty("message.send.max.retries", config.getProperty("message.send.max.retries"));
        mdsConfig.setProperty("compression.codec", config.getProperty("compression.codec"));
        mdsConfig.setProperty("request.timeout.ms", config.getProperty("request.timeout.ms"));
        mdsConfig.setProperty("batch.num.messages", config.getProperty("batch.num.messages"));
        mdsConfig.setProperty("send.buffer.bytes", config.getProperty("send.buffer.bytes"));
        mdsConfig.setProperty("maxProducer", config.getProperty("maxProducer"));

        topicId = config.getProperty("mds.topic");
        if (StringUtil.isBlank(topicId)) {
            throw new RuntimeException("mds.topic cannot be null");
        }
    }

    public static void sendMessage(String message) {
        IMessageSender sender = MsgSenderFactory.getClient(mdsConfig, topicId);
        sender.send(message, message.length());
    }
}
