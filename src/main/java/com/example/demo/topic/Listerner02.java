package com.example.demo.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**
 * <p>
 * Listerner01 订阅者01的监听器
 * <p>
 */
public class Listerner02 implements MessageListener{

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("订阅者02接收到消息：" + ((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}