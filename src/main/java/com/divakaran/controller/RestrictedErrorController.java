package com.divakaran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Divakaran Jeyachandran - djeyachandran@expedia.com
 */
@Controller
public class RestrictedErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    private ErrorAttributes errorAttributes;

    @Autowired
    public RestrictedErrorController(ErrorAttributes errorAttributes) {
        Assert.notNull(errorAttributes);
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(value = ERROR_PATH, method = RequestMethod.GET)
    public String error(HttpServletRequest request, Model model) {
        Map<String, Object> errorMap = errorAttributes.getErrorAttributes(new ServletRequestAttributes(request), false);
        model.addAttribute("errors", errorMap);
        return "error";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
