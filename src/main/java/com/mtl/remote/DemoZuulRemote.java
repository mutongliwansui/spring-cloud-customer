package com.mtl.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@FeignClient(value = "spring-cloud-zuul",fallback = DemoZuulRemote.HystrixCalculatorService.class) //经过网关，由网关再去调用服务提供方
public interface DemoZuulRemote {

    @RequestMapping(value = "/cal/demo1",method = RequestMethod.GET) //更改为调用网关的地址
    Map demo1(@RequestParam("param1") String param1, @RequestParam("param2") String param2,@RequestParam("accesstoken") String accesstoken);

    @RequestMapping(value = "/caladd/demo1",method = RequestMethod.GET) //更改为调用网关的地址
    Map demo2(@RequestParam("param1") String param1, @RequestParam("param2") String param2,@RequestParam("accesstoken") String accesstoken);

    @RequestMapping(value = "/mycall/demo1",method = RequestMethod.GET) //更改为调用网关的地址
    Map demo3(@RequestParam("param1") String param1, @RequestParam("param2") String param2,@RequestParam("accesstoken") String accesstoken);

    @RequestMapping(value = "/zuul/demo1",method = RequestMethod.GET) //更改为调用网关的地址
    Map demo4(@RequestParam("param1") String param1, @RequestParam("param2") String param2,@RequestParam("accesstoken") String accesstoken);

    @Component
    class HystrixCalculatorService implements DemoZuulRemote {

        @Override
        public Map demo1(String param1, String param2,String accesstoken) {
            Map map = new HashMap();
            map.put("result","DemoZuulRemote,the server is not valid now!1");
            return map;
        }

        @Override
        public Map demo2(String param1, String param2,String accesstoken) {
            Map map = new HashMap();
            map.put("result","DemoZuulRemote,the server is not valid now!2");
            return map;
        }

        @Override
        public Map demo3(String param1, String param2,String accesstoken) {
            Map map = new HashMap();
            map.put("result","DemoZuulRemote,the server is not valid now!3");
            return map;
        }

        @Override
        public Map demo4(String param1, String param2,String accesstoken) {
            Map map = new HashMap();
            map.put("result","DemoZuulRemote,the server is not valid now!4");
            return map;
        }
    }
}
