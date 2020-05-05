package cn.xyf.service.impl;

import cn.xyf.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

@EnableBinding(Source.class)  // 消息推送方
public class MessageProviderImpl implements IMessageProvider {
    private MessageChannel output;

    @Autowired
    public void setOutput(MessageChannel output) {
        this.output = output;
    }

    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("************serial="+serial);
        return serial;
    }
}
