package launchcode.com.ftf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "landing")
public class LandingController {

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "Landing");

        return "landing/index";
    }
}