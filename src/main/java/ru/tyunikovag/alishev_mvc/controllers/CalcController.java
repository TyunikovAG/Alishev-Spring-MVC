package ru.tyunikovag.alishev_mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {

    @GetMapping("/calc")
    public String calculate(@RequestParam(value = "arg1", required = false) String arg1,
                            @RequestParam(value = "arg2", required = false) String arg2,
                            @RequestParam(value = "act", required = false) String action,
                            Model model) {
        model.addAttribute("arg1", arg1);
        model.addAttribute("arg2", arg2);
        model.addAttribute("action", action);

        String result = "";

        try {
            double d1 = Double.parseDouble(arg1);
            double d2 = Double.parseDouble(arg2);
            switch (action) {
                case "plus":
                    result = String.valueOf(d1 + d2);
                    break;
                case "minus":
                    result = String.valueOf(d1 - d2);
                    break;
                case "multi" :
                    result = String.valueOf(d1 * d2);
                    break;
                case "div" :
                    result = String.valueOf(d1 / d2);
                    break;
                default: result = "Error";
            }
        } catch (Exception e){
            result = "Error";
        }
        model.addAttribute("result", result);
        return "calc/out";
    }
}
