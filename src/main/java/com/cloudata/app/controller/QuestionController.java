/**
 * File name: QuestionController Author: Dorsey Q F TANG Date: 7/3/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The controller to handle request to manipulate question.
 *
 * Author: DORSEy
 */
@Controller
@RequestMapping("/survey/question")
public class QuestionController {

    @RequestMapping("/questionCreation")
    public String questionCreation() {
        return "/survey/questions/questions";
    }

    @RequestMapping("/addQuestion")
    public String addQuestion() {
        return "redirect:/survey/getSurveys";
    }
}
