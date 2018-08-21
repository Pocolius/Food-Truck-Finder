package launchcode.com.ftf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="search")
public class SearchController {

    @RequestMapping(value="")
    public String searchForm (Model model) {
        model.addAttribute("title", "Search");

        return "search/search";
    }

    @RequestMapping(value = "results", method = RequestMethod.GET)
    public String searchResults (Model model) {
        model.addAttribute("title", "Search");

        return "search/results";
    }


}

