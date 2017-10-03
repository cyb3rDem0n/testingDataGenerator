package it.senseisrl.mitiga.survey.models;


import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"attrFieldId",
"name",
"type",
"multiValues",
"answers",
"tailoring",
"readOnly",
"singleValue"
})
public class HeaderQuestions{

@JsonProperty("attrFieldId")
public String attrFieldId;
@JsonProperty("name")
public String name;
@JsonProperty("type")
public String type;
@JsonProperty("multiValues")
public List<String> multiValues = null;
@JsonProperty("answers")
public List<String> answers = null;
@JsonProperty("tailoring")
public Boolean tailoring;
@JsonProperty("readOnly")
public Boolean readOnly;
@JsonProperty("singleValue")
public Boolean singleValue;

}