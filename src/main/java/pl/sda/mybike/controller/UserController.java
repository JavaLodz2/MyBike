package pl.sda.mybike.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.mybike.model.User;
import pl.sda.mybike.service.UserService;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class UserController {


    @Resource
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(Model model) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView getLoginPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        model.addObject("error", "Incorrect login or password");
        return model;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logoutPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @RequestMapping(value = "/registerUserForm", method = RequestMethod.GET)
    public ModelAndView registerUser() {

        ModelAndView model = new ModelAndView();
        model.addObject("user", new User());
        model.setViewName("registerUserForm");

        return model;
    }

    @RequestMapping(value = "/registerUserForm", method = RequestMethod.POST)
    public ModelAndView registerUserForm(@Valid @ModelAttribute User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("registerUserForm");
        } else {
            userService.addUser(user);
            ModelAndView model = new ModelAndView();
            return model;
        }


    }

}
