package launchcode.com.ftf.controllers;

import launchcode.com.ftf.models.data.UserDao;
import launchcode.com.ftf.models.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.*;

@Controller
@RequestMapping(value = "")
public class LandingController {

    @Autowired
    private UserDao userDao;

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

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String ProcessRegisterForm(@ModelAttribute @Valid user user, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Food Truck Finder");
            return "register";
        }
        userDao.save(user);
        return "landing/index";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String DisplayLoginForm(Model model) {
        model.addAttribute(new user());
        model.addAttribute("title", "Food Truck Finder");

        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String ProcessLoginform(@ModelAttribute @Valid user user, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute(user);
            model.addAttribute("title", "Food Truck Finder");
            return "login";
        } else {
            return "index";
        //Integer userId = user.getId();
        //if (dbpass.equals(userpass)) {
        //    return "landing/index";
        //} else {
        //    model.addAttribute(user);
        //    model.addAttribute("title", "Food Truck Finder");
        //    return "login";
        //}
        }
    }
}