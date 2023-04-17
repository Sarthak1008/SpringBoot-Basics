package com.example.Bootjpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/aliens")
    public Alien addAlien(@RequestBody Alien alien)
    {
        repo.save(alien);
        return alien;
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

    @GetMapping("/aliens")
    //@ResponseBody
    public List<Alien> getAliens(){
        return repo.findAll();
    }
    
    @RequestMapping("/aliens/{aid}")
    //@ResponseBody
    public Optional<Alien> getAlienId(@PathVariable("aid") int aid){
        return repo.findById(aid);
    }

    @DeleteMapping("/aliens/{aid}")
    public String deleteAlien(@PathVariable int aid)
    {
        Alien a = repo.getReferenceById(aid);
        repo.delete(a);
        return "deleted";
    }

    @PutMapping("/aliens")
    public Alien saveOrUpdatAlien(@RequestBody Alien alien)
    {
        repo.save(alien);
        return alien;
    }

    }
    
