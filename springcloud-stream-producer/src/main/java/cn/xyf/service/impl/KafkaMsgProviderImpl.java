package cn.xyf.service.impl;

import cn.xyf.config.MqMessageChannel;
import cn.xyf.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

@EnableBinding(MqMessageChannel.class)
public class KafkaMsgProviderImpl implements IMessageProvider {
    private MessageChannel msgOutput;

    @Autowired
    @Qualifier(MqMessageChannel.MESSAGE_OUTPUT)
    public void setMsgOutput(MessageChannel msgOutput) {
        this.msgOutput = msgOutput;
    }

    public String send() {
        String serial = UUID.randomUUID().toString();
        msgOutput.send(MessageBuilder.withPayload(serial).build());
        System.out.println("************serial="+serial);
        return serial;
    }
}
