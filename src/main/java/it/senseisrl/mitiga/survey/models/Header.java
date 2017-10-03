package it.senseisrl.mitiga.survey.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"header",
"body",
"surveyLog"
})
public class Header{

@JsonProperty("header")
public Header_ header;
@JsonProperty("body")
public Body body;
@JsonProperty("surveyLog")
public SurveyLog surveyLog;
}