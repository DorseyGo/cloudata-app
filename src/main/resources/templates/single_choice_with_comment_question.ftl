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
            <fieldname>language</fieldname>
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
                <language><![CDATA[${question.language}]]></language>
            </row>
        </rows>
    </questions>
    <answers>
        <fields>
            <fieldname>qid</fieldname>
            <fieldname>code</fieldname>
            <fieldname>answer</fieldname>
            <fieldname>language</fieldname>
        </fields>
        <rows>
        <#list question.answers as answer>
            <row>
                <qid><![CDATA[${question.questionId}]]></qid>
                <code><![CDATA[${answer.code}]]></code>
                <answer><![CDATA[${answer.answer}]]></answer>
                <language><![CDATA[${question.language}]]></language>
            </row>
        </#list>
        </rows>
    </answers>
    <defaultvalues>
        <fields>
            <fieldname>qid</fieldname>
            <fieldname>language</fieldname>
            <fieldname>defaultvalue</fieldname>
        </fields>
        <rows>
        <#list question.answers as answer>
            <#if answer.default>
                <row>
                    <qid><![CDATA[${question.questionId}]]></qid>
                    <language><![CDATA[${question.language}]]></language>
                    <defaultvalue><![CDATA[${answer.code}]]></defaultvalue>
                </row>
            </#if>
        </#list>
        </rows>
    </defaultvalues>
</document>
