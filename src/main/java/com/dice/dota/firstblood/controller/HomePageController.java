package com.dice.dota.firstblood.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomePageController {
    final private Logger logger = LoggerFactory.getLogger(HomePageController.class);
    @RequestMapping(value = "/",method = RequestMethod.GET)
    String homePage(){
        logger.info("Someone visited homePage");
        return "homepage";
    }

    @RequestMapping(value = "/game_predata.do",method = RequestMethod.POST)
    @ResponseBody Map<String,String> recvGamePreData(HttpServletRequest request, @RequestBody String gamePreData){
        System.out.println(gamePreData);
        Map<String,String> res = new HashMap();
        res.put("message","正在开发中");
        return res;
    }


    @RequestMapping(value = "/api/query",method = RequestMethod.GET)
    @ResponseBody String query(HttpServletRequest request){
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        //...
        StringBuilder res = new StringBuilder();
        if (!StringUtils.isEmpty(a)){
            //do something
        }else if (!StringUtils.isEmpty(b)){
            //do something
        }else if (!StringUtils.isEmpty(c)){
            //do something
        }
        if (!StringUtils.isEmpty(a)&&!StringUtils.isEmpty(b)){
            //do something
        }
        //...
        return res.toString();
    }
}
