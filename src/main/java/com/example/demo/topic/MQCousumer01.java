package com.example.demo.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.example.demo.Constants;


/**
 * <p>
 * MQCousumer01 订阅-发布模式 订阅者01
 * <p>
 */
public class MQCousumer01 {

    public static void main(String[] args) {
        // 连接工厂
        ConnectionFactory factory;
        // 连接实例
        Connection connection = null;
        // 收发的线程实例
        Session session;
        // 消息发送目标地址
        Topic topic;
        try {
            // 实例化连接工厂
            factory = new ActiveMQConnectionFactory(Constants.MQ_NAME, Constants.MQ_PASSWORD, Constants.MQ_BROKETURL);
            // 获取连接实例
            connection = factory.createConnection();
            // 启动连接
            connection.start();
            // 创建接收或发送的线程实例
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            // 创建队列（返回一个消息目的地）
            topic = session.createTopic("myTopic");
            // 创建消息订阅者
            MessageConsumer consumer = session.createConsumer(topic);
            // 消息发布者添加监听器
//            consumer.setMessageListener(new Listerner01());
            consumer.setMessageListener(new MessageListener() {
				
				@Override
				public void onMessage(Message message) {
					System.out.println("myTopic");
				}
			});
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}