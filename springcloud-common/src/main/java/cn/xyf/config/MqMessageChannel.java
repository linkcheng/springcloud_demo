package cn.xyf.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MqMessageChannel {
    // 队列生产者
    String MESSAGE_OUTPUT = "msg_output";
    // 队列消费者
    String MESSAGE_INPUT = "msg_input";

    @Output(MESSAGE_OUTPUT)
    MessageChannel msgOutput();

    @Input(MESSAGE_INPUT)
    MessageChannel msgInput();
}
