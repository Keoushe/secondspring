package org.launchcode.hellospring2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@ResponseBody
//@RequestMapping("hello")

public class HelloController {
    //
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }
//        /hello/goodbye
    @GetMapping("goodbye")

    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // handls request of form /hello?name=LaunchCode

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
//    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    //handles request of the form hello/LaunchCode

    @GetMapping("{name}")
//    @ResponseBody
    public String helloWithPathParam(@PathVariable String name, Model model){
//        String greeting = "Hello, " + name + "!";
        model.addAttribute("Greeting", "Hello, " + name + "!");
        return "Hello";
    }

    //hello/form
    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names",names);
        return "hello-list";
    }

}
