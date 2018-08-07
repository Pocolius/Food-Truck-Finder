package launchcode.com.ftf.controllers;

import launchcode.com.ftf.models.user;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "")
public class LandingController {

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "Food Truck Finder");

        return "landing/index";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String DisplayRegisterForm(Model model) {

        model.addAttribute(new user());
        model.addAttribute("title", "Food Truck Finder");

        return "register";
    }
}