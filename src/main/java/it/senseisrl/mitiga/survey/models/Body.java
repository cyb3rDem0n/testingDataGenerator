package it.senseisrl.mitiga.survey.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"bodyQuestions",
"bodyAnswers",
"visibility"
})
public class Body{

@JsonProperty("bodyQuestions")
public BodyQuestions bodyQuestions;
@JsonProperty("bodyAnswers")
public BodyAnswers bodyAnswers;
@JsonProperty("visibility")
public String visibility;

}