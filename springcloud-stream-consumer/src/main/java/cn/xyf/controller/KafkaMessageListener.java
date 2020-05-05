package cn.xyf.controller;

import cn.xyf.config.MqMessageChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(MqMessageChannel.class)
public class KafkaMessageListener {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(MqMessageChannel.MESSAGE_INPUT)
    public void rcv(String msg) {
        System.out.println("server.port="+serverPort+"，from kafka 收到消息="+msg);
    }
}
