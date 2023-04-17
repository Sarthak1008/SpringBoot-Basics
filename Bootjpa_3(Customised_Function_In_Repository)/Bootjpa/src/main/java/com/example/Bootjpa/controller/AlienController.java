package com.example.Bootjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.Bootjpa.dao.AlienRepo;
import com.example.Bootjpa.model.Alien;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AlienController {

    @Autowired
    AlienRepo repo;

    @RequestMapping("/")
    public String home()
    {
        return "home.jsp";
    }
    
    @RequestMapping("/addAlien")
    public String addAlien(Alien alien)
    {
        repo.save(alien);
        return "home.jsp";
    }

    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int aid) {
        ModelAndView mv = new ModelAndView("showAlien.jsp");
        Alien alien = repo.findById(aid).orElse(new Alien());
        //System.out.println(repo.findByTech("Java"));
        System.out.println(repo.findByAidGreaterThan(3));
        System.out.println(repo.findByTechSorted("Java"));
        mv.addObject(alien);
        return mv;
    }

    @RequestMapping("/getTech")
    public ModelAndView getTech(@RequestParam String tech) {
        ModelAndView mv = new ModelAndView("getTechnology.jsp");
        Alien alien = repo.findByTech(tech);
        mv.addObject(alien);
        return mv;
    }

    

    }
    
