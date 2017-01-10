package com.divakaran.controller;

import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.servlet.application.ApplicationResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Divakaran Jeyachandran
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld(HttpServletRequest req) {
        Application app = ApplicationResolver.INSTANCE.getApplication(req);
        System.out.println("Hello, " + app.getName());
        return "index";
    }
}
