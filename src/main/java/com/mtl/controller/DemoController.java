package com.mtl.controller;

import com.mtl.remote.DemoRibbonRemote;
import com.mtl.remote.DemoZuulRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mtl.remote.DemoRemote;

import java.util.Map;

@RestController
public class DemoController {
    @Autowired
    private DemoRemote demoRemote;

    @Autowired
    private DemoZuulRemote demoZuulRemote;

    @Autowired
    private DemoRibbonRemote demoRibbonRemote;

    @RequestMapping("/clientdemo/{param1}/{param2}")
    public Map demo1(@PathVariable("param1") String param1, @PathVariable("param2") String param2){
        return demoRemote.demo1(param1,param2);
    }

    @RequestMapping("/zuulurldemo/{param1}/{param2}/{accesstoken}")
    public Map zuulurldemo(@PathVariable("param1") String param1, @PathVariable("param2") String param2,@PathVariable("accesstoken") String accesstoken){
        return demoZuulRemote.demo1(param1,param2,accesstoken);
    }
    @RequestMapping("/zuulsiddemo/{param1}/{param2}/{accesstoken}")
    public Map zuulsiddemo(@PathVariable("param1") String param1, @PathVariable("param2") String param2,@PathVariable("accesstoken") String accesstoken){
        return demoZuulRemote.demo2(param1,param2,accesstoken);
    }
    @RequestMapping("/zuulsidmdemo/{param1}/{param2}/{accesstoken}")
    public Map zuulsidmdemo(@PathVariable("param1") String param1, @PathVariable("param2") String param2,@PathVariable("accesstoken") String accesstoken){
        return demoZuulRemote.demo3(param1,param2,accesstoken);
    }

    @RequestMapping("/zuullocaldemo/{param1}/{param2}/{accesstoken}")
    public Map zuullocaldemo(@PathVariable("param1") String param1, @PathVariable("param2") String param2,@PathVariable("accesstoken") String accesstoken){
        return demoZuulRemote.demo4(param1,param2,accesstoken);
    }

    @RequestMapping("/ribbondemo/{param1}/{param2}")
    public Map ribbondemo(@PathVariable("param1") String param1, @PathVariable("param2") String param2){
        return demoRibbonRemote.demo1(param1,param2);
    }

    @RequestMapping("/zuulribbondemo/{param1}/{param2}/{accesstoken}")
    public Map ribbondemo(@PathVariable("param1") String param1, @PathVariable("param2") String param2,@PathVariable("accesstoken") String accesstoken){
        return demoRibbonRemote.demo2(param1,param2,accesstoken);
    }

}
