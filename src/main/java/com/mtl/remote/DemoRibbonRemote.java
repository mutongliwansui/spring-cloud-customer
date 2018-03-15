package com.mtl.remote;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class DemoRibbonRemote {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "demo1Deal" )
    public Map demo1(String param1, String param2){
        ResponseEntity<Map> entity = restTemplate.getForEntity("http://spring-cloud-producer/demo1?param1={1}&param2={2}",
                Map.class,param1,param2);
        return entity.getBody();
    }

    @HystrixCommand(fallbackMethod = "demo2Deal" )
    public Map demo2(String param1, String param2,String accesstoken){
        Map map = new HashMap();
        map.put("param1",param1);
        map.put("param2",param2);
        map.put("accesstoken",accesstoken);
        //1.调用getForEntity
//        ResponseEntity<Map> entity = restTemplate.getForEntity("http://spring-cloud-zuul/mycall/demo1?param1={param1}&param2={param2}&accesstoken={accesstoken}",
//                Map.class,map);
//        return entity.getBody();
        //2.调用getForObject
        return restTemplate.getForObject("http://spring-cloud-zuul/mycall/demo1?param1={param1}&param2={param2}&accesstoken={accesstoken}",
                Map.class,map);
    }

    public Map demo1Deal(String param1, String param2) {
        Map map = new HashMap();
        map.put("result","DemoRibbonRemote,the server is not valid now!1");
        return map;
    }

    public Map demo2Deal(String param1, String param2,String accesstoken) {
        Map map = new HashMap();
        map.put("result","DemoRibbonRemote,the server is not valid now!2");
        return map;
    }
}
