package cn.xyf.contrtoller;

import cn.xyf.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController{
    private IMessageProvider kafkaMsgProviderImpl;

    @Autowired
    public void setKafkaMsgProviderImpl(IMessageProvider kafkaMsgProviderImpl) {
        this.kafkaMsgProviderImpl = kafkaMsgProviderImpl;
    }

    @GetMapping("/kafka")
    public String send() {
        return kafkaMsgProviderImpl.send();
    }
}
