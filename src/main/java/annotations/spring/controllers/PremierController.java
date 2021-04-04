package annotations.spring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import annotations.spring.model.User;

import javax.validation.Valid;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/testuser")
public class PremierController {


    @ModelAttribute("allDepartments")
    public List<String> populateDepartments()
    {
        ArrayList<String> departments = new ArrayList<String>();
        departments.add("Loire");
        departments.add("Haute Loire");
        departments.add("Loire Atlantique");
        departments.add("Loiret");
        return departments;
    }


    @RequestMapping(value="/",method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        System.out.println("Home Page Requested, locale = " + locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        model.addAttribute("user",new User());

        return "home";
    }

    @RequestMapping(value="/user")
    public String user(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "home";
        }

        model.addAttribute("userName", user.getLogin());
        return "user";
    }

    @GetMapping(value = "/essaiparam")
    @ResponseBody
    public String essaiParam(@RequestParam String param) {
        return ("le param vaut : " + param);
    }
}

