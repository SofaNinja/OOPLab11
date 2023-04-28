package com.example.ooplab11.controller;

import com.example.ooplab11.processor.Processor;
import com.example.ooplab11.data.Point;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WebController {

    @RequestMapping("/tabulating")
    public String Processor(@RequestParam double start, @RequestParam double finish, @RequestParam double step, Model model) {
        Processor processor = new Processor(start, finish, step);
        List<Point> points = processor.tabulating(start,finish,step);
        model.addAttribute("tabulating", processor);
        model.addAttribute("points", points);
        return "tabulating";
    }
}
