package com.example.exam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExamController {

    /* Exercice2 */
    /* Q1 */
    @GetMapping("/greeting1")
    @ResponseBody
    public String showHelloWorld(@RequestParam(name = "to", defaultValue = "World", required = false) String name,
            Model model) {
        model.addAttribute("name", name);
        return "Hello, " + name + "!";
    }

    /* Q2 */
    @GetMapping("/greeting2")
    @ResponseBody
    public String home(@RequestParam(name = "who", defaultValue = "World", required = false) String name,
            @RequestParam(name = "ent", defaultValue = "ESME", required = false) String ent) {
        return "Hello, " + name + " ! Welcome to " + ent;
    }
}