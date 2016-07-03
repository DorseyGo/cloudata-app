/**
 * File name: SurveyController Author: Dorsey Q F TANG Date: 6/30/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.app.controller;

import com.cloudata.app.utils.ServletUtils;
import com.cloudata.app.views.SurveyView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * Author: DORSEy
 */
@Controller
@RequestMapping("/survey")
public class SurveyController {


    /**
     * Retrieves all available surveys.
     *
     */
    @RequestMapping("/getSurveys")
    public String getSurveys() {
        // code goes here to retrieve corresponding surveys
        return "/survey/surveys";
    }

    @RequestMapping("/createSurvey")
    public ModelAndView createSurvey(final HttpServletRequest request) throws ServletException {
        String surveyName = ServletUtils.getParam(request, SurveyConstants.REQ_SURVEY_NAME, "");
        if (surveyName.isEmpty()) {
            throw new ServletException(SurveyConstants.REQ_SURVEY_NAME + " with no value");
        }

        SurveyView view = new SurveyView();
        view.setSurveyTitle(surveyName);
        view.setSurveyId(1);

        return new ModelAndView("/survey/questions/questions", "survey", view);
    }
}
