package com.wys.redislearn.controller;

import com.wys.redislearn.config.NotIncludeSwagger;
import com.wys.redislearn.entity.NewTable;
import com.wys.redislearn.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@Api(tags = {"myDemo"})//description = "DemoController描述"
@RequestMapping("/test")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @NotIncludeSwagger//@ApiIgnore是内置注解功能一样
    @RequestMapping("/test")
    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<String> list=(List<String>) request.getSession().getAttribute("list1");

        if(list == null){
            list=new ArrayList<>();
            request.getSession().setAttribute("list1",list);
        }
        list.add("xxx");
        request.getSession().setAttribute("list1",list);//**
        response.getWriter().println("sessionId"+request.getSession().getId());
        response.getWriter().println("counts"+list.size());
    }

    @RequestMapping("/getAccountById")
    @ResponseBody
    @ApiOperation(value = "接口描述", notes = "提示信息")
    //@ApiImplicitParam(name = "id",value = "个人id",required = true,paramType = "query",dataType = "int"),@ApiImplicitParam(),....
    public NewTable getAccountById(@ApiParam(value = "个人id 这个是参数描述", required = true)int id){//requires是否必须
        NewTable newTable=accountService.getNewTableById(id);
        System.out.println(newTable);
        return  newTable;
    }
}
