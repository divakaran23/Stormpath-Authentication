package com.divakaran.controller;

import com.divakaran.service.RestrictedService;
import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.servlet.account.AccountResolver;
import com.stormpath.sdk.servlet.application.ApplicationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Divakaran Jeyachandran
 */
@Controller
public class HomeController {

    @Autowired
    private RestrictedService restrictedService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld(HttpServletRequest req) {
        Application app = ApplicationResolver.INSTANCE.getApplication(req);
        System.out.println("Hello, " + app.getName());
        return "index";
    }

    @RequestMapping(value = "/restricted", method = RequestMethod.GET)
    public String restricted(HttpServletRequest request, Model model) {
        if(AccountResolver.INSTANCE.getAccount(request) != null) {
            model.addAttribute("accountName", AccountResolver.INSTANCE.getAccount(request).getFullName());
            return "restricted";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "api/restrict", method = RequestMethod.GET)
    public String getApi(HttpServletRequest request, Model model) {
        String message = restrictedService.validateUser(AccountResolver.INSTANCE.getAccount(request));
        model.addAttribute("message", message);
        return "hello";
    }

}
