package cn.xyf.controller;


import cn.xyf.pojo.Dept;
import cn.xyf.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    private DeptService deptService;
    private EurekaDiscoveryClient discoveryClient;

    @Autowired
    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }

    @Autowired
    public void setDiscoveryClient(EurekaDiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @PostMapping("/dept")
    public int add(Dept dept) {
        return deptService.add(dept);
    }


    @GetMapping("/dept/{pid}")
    public Dept getDept(@PathVariable("pid") int pid) {
        return deptService.queryById(pid);
    }

    @GetMapping("/depts")
    public List<Dept> getAllDept() {
        return deptService.queryAll();
    }

    @GetMapping("/dept/discovery")
    public Object discovery() {
        // 获取微服务列表清单
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println("service="+service
                        +",serviceId="+instance.getServiceId()
                        +",host="+instance.getHost()
                        +",port="+instance.getPort()
                        +",instanceId="+instance.getInstanceId()
                        +",schema="+instance.getScheme()
                        +",metadata="+instance.getMetadata()
                        +",uri="+instance.getUri()
                );
            }
        }
        return discoveryClient;
    }
}


