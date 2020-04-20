package cn.xyf.sidecar.api;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("${request.sidecar-server}")
public interface SidecarClient {
    @GetMapping("/index")
    String index();

    @GetMapping("/health/")
    String health();

    @GetMapping("/api/book/{pk}")
    String getBook(@PathVariable("pk") int pk);

//    @PostMapping(value = "/book", headers = {"Content-Type=application/json"})
//    String addBook(JSONObject data);
}
