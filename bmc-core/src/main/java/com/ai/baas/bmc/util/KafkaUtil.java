package com.ai.baas.bmc.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class KafkaUtil {
    private static final Logger LOG = LogManager.getLogger(KafkaUtil.class);

    // kafka配置信息路径
    private static final String PATH = "context/kafka.properties";

    // 默认配置信息
    private static final Properties propModel;

    // 实际配置信息
    private Properties prop;

    // 话题名称
    private final String topic;

    // 线程数量，与kafka分区数量相同
    private final int threadNum;

    private int key = 0;

    // 加载静态配置信息
    static {
        propModel = new Properties();
        try {
            propModel.load(KafkaUtil.class.getClassLoader().getResourceAsStream(PATH));
        } catch (IOException e) {
            LOG.error("加载失败", e);
        }
    }

    /**
     * 默认kafka配置
     */
    public KafkaUtil() {
        prop = (Properties) propModel.clone();
        topic = prop.getProperty("kafka.topic");
        threadNum = Integer.parseInt(prop.getProperty("thread.count"));
    }

    public KafkaUtil(String topic){
        prop = (Properties) propModel.clone();
        prop.setProperty("kafka.topic", topic);
        this.topic = topic;
        threadNum = Integer.parseInt(prop.getProperty("thread.count"));
    }
    /**
     * 指定话题与线程数量的kafka配置
     */
    public KafkaUtil(String topic, int threadNum) {
        prop = (Properties) propModel.clone();
        prop.setProperty("kafka.topic", topic);
        prop.setProperty("thread.count", threadNum + "");
        this.topic = topic;
        this.threadNum = threadNum;
    }

    /**
     * 完全自定义kafka配置,必须有kafka.topic和thread.count
     */
    public KafkaUtil(Properties prop) {
        this.prop = prop;
        topic = prop.getProperty("kafka.topic");
        threadNum = Integer.parseInt(prop.getProperty("thread.count"));
    }

    /**
     * 发送信息到kafka(key为null)
     */
    public void simpleAddQueue(String... msgs) {
        Producer<String, String> producer = new Producer<String, String>(new ProducerConfig(prop));
        List<KeyedMessage<String, String>> data = new ArrayList<KeyedMessage<String, String>>();
        for (String msg : msgs) {
            data.add(new KeyedMessage<String, String>(topic, msg));
            LOG.debug("加入kafka队列:主题[" + topic + "];消息[" + msg + "]");
        }
        if (!data.isEmpty()) {
            producer.send(data);
            LOG.debug("发送kafka成功！");
        }
        // 关闭producer
        producer.close();
    }

    /**
     * 键值对形式发送消息到kafka
     */
    public void addQueue(Map<String, List<String>> msgs) {
        Producer<String, String> producer = new Producer<String, String>(new ProducerConfig(prop));
        List<KeyedMessage<String, String>> data = new ArrayList<KeyedMessage<String, String>>();
        for (Entry<String, List<String>> entry : msgs.entrySet()) {
            for (String msg : entry.getValue()) {
                data.add(new KeyedMessage<String, String>(topic, entry.getKey(), msg));
                LOG.debug(
                        "加入kafka队列:主题[" + topic + "];key[" + entry.getKey() + "];消息[" + msg + "]");
            }
        }
        if (!data.isEmpty()) {
            producer.send(data);
            LOG.debug("发送kafka成功！");
        }
        producer.close();
    }

    /**
     * 根据threadNum平均发给每一个kafka分区
     */
    public void addQueue(String... msgs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        // int size = msgs.length % threadNum == 0 ? msgs.length / threadNum
        // : msgs.length / threadNum + 1;
        // for (int i = 0, start = 0; i < threadNum; i++) {
        // int end = (start + size) > msgs.length ? msgs.length : (start + size);
        // String[] value = Arrays.copyOfRange(msgs, start, end);
        // map.put(i + "", value);
        // start = end;
        // if (start >= msgs.length) {
        // break;
        // }
        // }
        for (String msg : msgs) {
            key = key >= threadNum ? 0 : key;
            if (!map.containsKey(key + "")) {
                map.put(key + "", new ArrayList<String>());
            }
            map.get(key + "").add(msg);
            key++;
        }
        addQueue(map);
    }

    /**
     * 获得默认的kafka消费流列表
     */
    public List<KafkaStream<byte[], byte[]>> getStream() {
        ConsumerConnector consumerConnector = Consumer
                .createJavaConsumerConnector(new ConsumerConfig(prop));

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(topic, threadNum);
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumerConnector
                .createMessageStreams(map);
        return consumerMap.get(topic);
    }

    /**
     * 根据groupId获得kafka消费流列表
     */
    public List<KafkaStream<byte[], byte[]>> getStream(String groupId) {
        prop.setProperty("group.id", groupId);
        return getStream();
    }

    /**
     * 获得话题
     */
    public String getTopic() {
        return topic;
    }

    /**
     * 获得进程数，与kafka分区patition数相同
     */
    public int getThreadNum() {
        return threadNum;
    }
}
