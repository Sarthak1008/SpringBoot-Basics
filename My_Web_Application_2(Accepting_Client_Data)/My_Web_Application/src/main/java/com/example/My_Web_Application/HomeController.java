package com.example.My_Web_Application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping("home")
    public String home(HttpServletRequest req,HttpServletResponse res)
	{
		HttpSession session = req.getSession();
		String name=req.getParameter("name");
		System.out.println("hi" + name);
		session.setAttribute("name",name);
		return "home";
	}
    }

