<%@ page import="com.cloudata.app.views.SurveyView" %><%--
  Created by IntelliJ IDEA.
  User: DORSEy
  Date: 7/3/16
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String context = request.getContextPath();
%>
<head>
    <title>Question creation</title>
    <link rel="stylesheet" href="<%=context %>/css/jquery-ui.css"/>
    <script type="text/javascript" src="<%=context %>/js/jquery.js"></script>
    <script type="text/javascript" src="<%=context %>/js/jquery-ui.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            // the count of answers
            // should display one at initialized
            var count = $("#answersParaElem").children("p").length;

            // define the settings.
            $("#createQuestionDialog").dialog({
                modal: true,
                autoOpen: false,
                width: 800,
                buttons: [
                    {
                        text: "continue",
                        click: function () {
                            // submit the form and continue the next loop
                            $("#addQuestionForm").submit();
                        }
                    },
                    {
                        text: "cancel",
                        click: function () {
                            $(this).dialog('close');
                        }
                    }
                ]
            });

            $("#addQuestionElem").click(function () {
                $("#createQuestionDialog").dialog('open');

                // do initialization
                initPreview(count);
            });

            // click event bind to "one more" button on answer
            $(document).on("click", ".oneMoreElem", function () {
                var parentElement = $(this).parent();
                var grandpaElement = parentElement.parent();

                // count increased
                count++;
                addOneMoreAnswerInput(count - 1, grandpaElement);

                // add one answer in the preview list
                addOneMoreAnswerInPreviewList(count - 1);
            });

            // click event bind to "remove" button on answer
            $(document).on("click", ".removeElem", function () {
                var parentElement = $(this).parent();
                var siblingInputElement = $(this).siblings("input[type='text']");
                var inputName = siblingInputElement.attr("name");
                var pos = inputName.substr("answer".length, inputName.length);

                var grandpaElement = parentElement.parent();
                var elementInPreview2BeRemoved = $("#A" + pos).parent();

                removeElement(grandpaElement);
                removeElement(elementInPreview2BeRemoved);

                // no need to decrease count for avoiding conflict
            });


            $("#questionTypeChoseElem").change(function () {
                var selectElement = $(this).children("option:selected");
                var typeOfQuestion = "";
                var selectedOptionValue = selectElement.val();

                if ("L" == selectedOptionValue) {
                    typeOfQuestion = "single";
                } else {
                    typeOfQuestion = "multiple";
                }

                var questionTypeHtml = "[" + typeOfQuestion + "]";
                $("#typeOfQuestionId").html(questionTypeHtml);

                // as it changed, then recount
                count = $("#answersParaElem").children("p").length;
                initPreview(count);
            });

            function addOneMoreAnswerInPreviewList(index) {
                var html = "<p><span id='A"+ index + "'>answer " + (index + 1) + "</span></p>";
                var latestPElement = $("#preview p:last");
                var genPElement = $(html);

                genPElement.insertAfter(latestPElement);
            }

            function addOneMoreAnswerInput(index, element) {
                var html = "<p><span>";
                html += "<input type='text' value='input ur answer' size='20' name='answer"+index+"' /> &nbsp;";
                html += "<input type='button' value='one more' class='oneMoreElem' /> &nbsp;";
                html += "<input type='button' value='remove' class='removeElem' />";
                html += "</span></p>";

                var genPElement = $(html);
                genPElement.insertAfter(element);
            }

            function initPreview(len) {
                for (var index = 0; index < len; index++) {
                    addOneMoreAnswerInPreviewList(index);
                }
            }

            function removeElement(element) {
                element.remove();
            }
        });
    </script>
</head>
<body>
<div id="createQuestionDialog" style="display: none;" title="add question">
    <div>
        <form action="<%=context %>/survey/question/addQuestion" method="post" id="addQuestionForm">
            <p>
                <span>
                    Enter your question: &nbsp;
                    <input type="text" size="20" name="question"/> &nbsp;
                    Choose the type:
                    <select id="questionTypeChoseElem">
                        <option value="L" selected="selected">single chosen</option>
                        <option value="M">multiple chosen</option>
                    </select>
                </span>
            </p>
            <p>
                <span>
                    Enter your answers: &nbsp;
                </span>
            </p>
            <div id="answersParaElem">
                <p>
                        <span>
                            <input type="text" size="20" value="input ur answer" name="answer0"/> &nbsp;
                            <input type="button" value="one more" class="oneMoreElem"/>
                        </span>
                </p>
            </div>
        </form>
    </div>
    <div id="preview">
        <p>
            <span>preview of the creating question</span>
        </p>
        <p>
            <span id="questionTitleId">the title of question<span id="typeOfQuestionId"></span></span>
        </p>
    </div>
</div>

<div>
    <p>
        <%
            SurveyView view = (SurveyView) request.getAttribute("survey");
        %>
        <%=view.getSurveyTitle() %>
    </p>
</div>

<div>
        <span style="font-stretch: ultra-condensed" id="addQuestionElem">
            add question
        </span>

</div>
</body>
</html>
