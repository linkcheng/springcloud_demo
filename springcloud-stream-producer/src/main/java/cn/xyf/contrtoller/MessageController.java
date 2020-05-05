package cn.xyf.contrtoller;

import cn.xyf.service.IMessageProvider;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MessageController {
    private IMessageProvider provider;

    @Autowired
    public void setProvider(IMessageProvider messageProviderImpl) {
        this.provider = messageProviderImpl;
    }

    @GetMapping("/rabbitmq")
    public String send() {
        return provider.send();
    }
}
