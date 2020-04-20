package cn.xyf.controller;

import cn.xyf.sidecar.api.SidecarClient;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class BookApiController {
    @Autowired
    SidecarClient client;

    @GetMapping("/index")
    public String index() {
        return client.index();
    }

    @GetMapping("/health")
    public String health() {
        return client.health();
    }

    @GetMapping("/book/{pk}")
    public String getBook(@PathVariable("pk") int pk) {
        return client.getBook(pk);
    }

//    @PostMapping(value = "/book", headers = {"Content-Type=application/json"})
//    public String addBook(JSONObject data) {
//        return client.addBook(data);
//    }
}

