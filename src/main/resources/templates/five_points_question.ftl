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
            </row>
        </rows>
    </questions>
</document>