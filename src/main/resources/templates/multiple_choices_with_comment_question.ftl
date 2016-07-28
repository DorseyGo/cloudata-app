<?xml version="1.0" encoding="UTF-8"?>
<document>
    <LimeSurveyDocType>Question</LimeSurveyDocType>
    <DBVersion>257</DBVersion>
    <languages>
        <language><![CDATA[${question.language}]]></language>
    </languages>
    <questions>
        <fields>
            <fieldname>qid</fieldname>
            <fieldname>parent_qid</fieldname>
            <fieldname>sid</fieldname>
            <fieldname>gid</fieldname>
            <fieldname>type</fieldname>
            <fieldname>title</fieldname>
            <fieldname>question</fieldname>
            <fieldname>mandatory</fieldname>
            <fieldname>question_order</fieldname>
            <fieldname>language</fieldname>
            <!-- <fieldname>relevance</fieldname> -->
        </fields>
        <rows>
            <row>
                <qid><![CDATA[${question.questionId}]]></qid>
                <parent_qid><![CDATA[${question.parentQuestionId}]]></parent_qid>
                <sid><![CDATA[${question.surveyId}]]></sid>
                <gid><![CDATA[${question.groupId}]]></gid>
                <type><![CDATA[${question.type}]]></type>
                <title><![CDATA[${question.questionTitle}]]></title>
                <question><![CDATA[${question.question}]]></question>
                <mandatory><![CDATA[${question.mandatory}]]></mandatory>
                <question_order><![CDATA[${question.questionOrder}]]></question_order>
                <language><![CDATA[${question.language}]]></language>
                <!-- <relevance><![CDATA[]]></relevance> -->
            </row>
        </rows>
    </questions>
    <subquestions>
        <fields>
            <fieldname>qid</fieldname>
            <fieldname>parent_qid</fieldname>
            <fieldname>sid</fieldname>
            <fieldname>gid</fieldname>
            <fieldname>type</fieldname>
            <fieldname>title</fieldname>
            <fieldname>question</fieldname>
            <fieldname>question_order</fieldname>
            <fieldname>language</fieldname>
            <!-- <fieldname>relevance</fieldname> -->
        </fields>
        <rows>
        <#list question.answers as answer>
            <row>
                <qid><![CDATA[${answer.questionId}]]></qid>
                <parent_qid><![CDATA[${question.parentQuestionId}]]></parent_qid>
                <sid><![CDATA[${question.surveyId}]]></sid>
                <gid><![CDATA[${question.groupId}]]></gid>
                <type><![CDATA[${answer.answerType}]]></type>
                <title><![CDATA[${answer.code}]]></title>
                <question><![CDATA[${answer.answer}]]></question>
                <question_order><![CDATA[${answer.order}]]></question_order>
                <language><![CDATA[${question.language}]]></language>
                <!--<relevance><![CDATA[]]></relevance> -->
            </row>
        </#list>
        </rows>
    </subquestions>
</document>
