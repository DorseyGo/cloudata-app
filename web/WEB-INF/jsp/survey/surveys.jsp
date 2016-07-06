<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.cloudata.app.views.SurveyView" %><%--
  Created by IntelliJ IDEA.
  User: DORSEy
  Date: 6/30/16
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Survey List</title>
    <%
        String contextPath = request.getContextPath();
    %>
    <link rel="stylesheet" href="<%=contextPath %>/css/jquery-ui.css" />
    <script type="text/javascript" src="<%=contextPath %>/js/jquery.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/js/jquery-ui.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            // define the settings of dialog
            $("#createSurveyDialog").dialog({
                modal: true,
                autoOpen: false,
                width: 400,
                buttons: [
                    {
                        text: "create",
                        click: function() {
                            // submit the form
                            $("#surveyCreationForm").submit();
                        }
                    },
                    {
                        text: "cancel",
                        click: function() {
                            // close the dialog
                            $(this).dialog('close');
                        }
                    }
                ]
            });

            $("#aCreateSurvey").click(function(){
                $("#createSurveyDialog").dialog('open');
                return false;
            });
        });
    </script>
</head>
<body>
<h1>The available surveys</h1>
<div>
    <div>
        <span id="aCreateSurvey">create a survey</span>
    </div>
    <div id="createSurveyDialog" title="create a survey" style="display: none">
        <form action="<%=contextPath %>/survey/createSurvey" method="post" id="surveyCreationForm">
            <p>
                <span>survey name:</span> &nbsp; <input type="text" name="surveyName" size="20" />
            </p>
        </form>
    </div>
    <table>
        <tr>
            <th>Title</th>
            <th>Owner</th>
            <th>CreatedTime</th>
            <th>Operations</th>
        </tr>
        <%
            List<SurveyView> views = new ArrayList<SurveyView>();
            Object attr = request.getAttribute("surveys");
            if (attr != null) {
                views = (List<SurveyView>) attr;
            }

            for (SurveyView view : views) {
        %>
        <tr>
            <td><%=view.getSurveyTitle() %>
            </td>
            <td><%=view.getOwner() %>
            </td>
            <td><%=view.getCreatedTime() %>
            </td>
            <td>
                <a href="javascript:void();">delete</a>
                <a href="javascript:void();">update</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
