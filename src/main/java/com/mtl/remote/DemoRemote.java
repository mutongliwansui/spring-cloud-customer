package com.mtl.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
@FeignClient(value = "spring-cloud-producer",fallback = DemoRemote.HystrixCalculatorService.class) //直接调用服务提供方
public interface DemoRemote {

    @RequestMapping(value = "/demo1",method = RequestMethod.GET)
    Map demo1(@RequestParam("param1") String param1, @RequestParam("param2") String param2);

    @Component
    class HystrixCalculatorService implements DemoRemote{
        @Override
        public Map demo1(String param1, String param2) {
            Map map = new HashMap();
            map.put("result","DemoRemote,the server is not valid now!1");
            return map;
        }
    }
}
