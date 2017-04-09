package com.aobin.messenger.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MvcController
{
    private static int count=1;

    @RequestMapping("/hello")
    public String test(HttpSession session)
    {
        System.out.println(session.getId()+"  "+session.getAttribute("name"));
        session.setAttribute("name","hello "+(++count));
        return "hello";
    }
}
