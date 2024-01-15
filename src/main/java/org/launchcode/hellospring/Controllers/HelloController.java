package org.launchcode.hellospring.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {


    //handle requests of the form http://localhost:8080/hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, Model model){
        String agreeting = "Hello, " + name + "!";
        model.addAttribute("Greeting",agreeting);
        return "hello";
    }

    //handle requests of the form http://localhost:8080/hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name,Model model){
        model.addAttribute("Greeting","Hello, " + name + "!");
        return "hello";    }
    @GetMapping("form")
    public String helloForm() {
      return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String>names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names",names);
        return "hello-list";
    }

}



















