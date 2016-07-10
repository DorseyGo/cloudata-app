<%@ page import="com.cloudata.app.views.SurveyView" %><%--
  Created by IntelliJ IDEA.
  User: liujt
  Date: 7/10/16
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String context = request.getContextPath();
%>
<head>
    <title>创建问卷</title>
    <link rel="stylesheet" href="<%=context %>/css/bootstrap.min.css" />
    <link rel="stylesheet" href="<%=context %>/css/custombox.min.css" />
    <link rel="stylesheet" href="<%=context %>/css/question.css" />
    <script type="text/javascript" src="<%=context %>/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="<%=context %>/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=context %>/js/custombox.min.js"></script>
    <script type="text/javascript" src="<%=context %>/js/jquery.horizontalNav.js"></script>
    <script type="text/javascript" src="<%=context %>/js/handlebars-v4.0.5.js"></script>
    <script type="text/javascript" src="<%=context %>/js/legacy.min.js"></script>
    <script type="text/javascript">
        var q_num = 1;
        var current_question_answer_num=1;
        var data={};
        var handlebars_each=[];
        $(document).ready(function() {

            $('.full-width').horizontalNav({});
            $('#single_type').on('click', function (e) {

                var first_answerId= "q_"+q_num+"_a_1_id";
                $('.first_answer').attr("id",first_answerId);
                Custombox.open({
                    target: '#single',
                    effect: 'fadein',
                    overlayColor: "#000",
                    zIndex: 1
                });
                e.preventDefault();
            });

            $("#submit").on('click', function () {
                var preview_ul_html="<div><ul style='list-style: none;text-align: left;'  id='question_preview'><li><h4 style='display: inline-block;'>Q{{current_num}}:</h4>{{subject}}</li>";

                for(var i=1;i<=current_question_answer_num;i++)
                {
                    handlebars_each[i]=i;
                    var preview_answer_id="answer"+i;
                    var li_html="<li><input type='radio' />"+"{{"+preview_answer_id+"}}"+"</li>";
                    preview_ul_html+=li_html;
                }
                preview_ul_html+="</ul></div>";
                var subject = $("#subject").val();
                data["current_num"]=q_num;
                data["subject"]=subject;
                var template = Handlebars.compile(preview_ul_html);
                var html = template(data);
                $("#result").append(html);
                q_num=q_num+1;
                resetCreateQuestiongModal();
            });

            function resetCreateQuestiongModal(){
                $("#subject").val("");
                $(".add_answers").remove();
                $(".first_answer").val("");
            }


            $('#addAnswer').on('click',function(){
                current_question_answer_num=current_question_answer_num+1;
                var answerId="q_"+q_num+"_a_"+current_question_answer_num+"_id";
                var answer_html ="<li class='add_answers'>答案"+current_question_answer_num+":<input id='"+answerId+"' type='text' class='form-control' placeholder='请输入答案' /></li>";
               $("#question ul").append(answer_html);

            });

            $("#question ul li input").live('blur',function(e){
                var content = $(this).val();
                var elementId =$(this).attr("id");
                //filter subject input
                if(!(elementId=='subject'))
                {
                    var answer_num = elementId.split("_")[3];
                    var preview_answer_id="answer"+answer_num;
                    data[preview_answer_id]=$(this).val();
                }
            });
        });
    </script>
</head>
<body>
<h1>设计您的问卷: <%
    SurveyView view = (SurveyView) request.getAttribute("survey");
%>
    <%=view.getSurveyTitle() %></h1>

<div class="demo">
    <h2>基本题型</h2>
    <div class="horizontal-nav horizontalNav-notprocessed clearfix">
        <ul>
            <li><a href="#" id="single_type">单选题</a></li>
            <li><a href="#">多选题</a></li>
            <li><a href="#">填空题</a></li>
            <li><a href="#">打分题</a></li>
            <li><a href="#">文字说明</a></li>
        </ul>
    </div>

    <h2>快速题型</h2>
    <div class="horizontal-nav full-width horizontalNav-notprocessed">
        <ul>
            <li><a href="#" target="_blank">姓名</a></li>
            <li><a href="#">性别</a></li>
            <li><a href="#">生日</a></li>
            <li><a href="#">城市</a></li>
            <li><a href="#">邮箱</a></li>
            <li><a href="#">手机</a></li>
            <li><a href="#">颜色</a></li>
        </ul>
    </div>
</div>


<style type="text/css">
    h1 { text-align: center;}

    .demo { padding:0 10%; font-size: 14px;}
    .demo li a { text-decoration: none;}

    .explanation { width: 708px; margin: 100px auto 0; padding: 10px; line-height: 20px; border: 1px solid #ccc; font-size: 12px;}
    .explanation h2 { margin: 0; padding: 0; font-size: 12px;}
    .explanation p { margin: 0; padding: 0;}

    .vad a { display:inline-block; margin:0 5px; padding:5px 10px; font-size:14px; text-align:center; color:#eee; text-decoration:none; background-color:#222;}
    .vad a:hover { color:#fff; background-color:#000;}

    #preview ul li{
        list-style: none;;
    }
</style>

<div class="explanation">
    <h2>说明:</h2>
    <p>点击上方选择题型，编辑题型来创建您的问题！</p>
    <div id="result">
        <h3>您的问卷:</h3>
    </div>
</div>

<div id="single" style="display: none;background-color: #fff;border:1px solid #0e7079;height: 500px;width: 500px;">
    <div class="title">
        <button type="button" class="close" onclick="Custombox.close();" style="float: right;">
            <span>×</span><span class="sr-only">Close</span>
        </button>
        <h5 style="display: inline-block;">问卷设计面板</h5>
    </div>
    <div id="question">
        <ul style="list-style: none;text-align: left;">
            <li><h4 style="display: inline-block;">题目:</h4><input id="subject" type="text" class="form-control" placeholder="请输入题目" /></li>
            <li><h4>答案:</h4></li>
            <li>答案1:<input class="first_answer form-control" id="" type="text" placeholder="请输入答案"  /></li>
        </ul>
    </div>
    <div style="text-align: left;margin-left: 40px;">
        <a id="addAnswer" class="btn btn-primary btn-sm">新增答案</a>
    </div>
    <a id="submit" class="btn btn-primary btn-sm">继续</a>
    <a id="cancel" class="btn btn-default btn-sm">完成</a>

</div>


<div id="single_template" style="display: none;">
    <ul style="list-style: none;text-align: left;" id="question_preview">
        <li><h4 style="display: inline-block;">Q{{current_num}}:</h4>{{subject}}</li>
    </ul>
</div>


</div>
</body>
</html>
