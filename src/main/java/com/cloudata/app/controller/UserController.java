/**
 * File name: UserController Author: Dorsey Q F TANG Date: 6/29/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: DORSEy
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(final HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // code goes here to check validity
        if ("admin".equalsIgnoreCase(username) && "admin".equalsIgnoreCase(password)) {
            return "redirect:/survey/getSurveys";
        } else {
            return "redirect:/user/login";
        }
    }
}
