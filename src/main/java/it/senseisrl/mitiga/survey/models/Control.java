package it.senseisrl.mitiga.survey.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"probabilityControlId",
"questionText",
"singleChoice",
"noteMinValue",
"filterOperator",
"filterValues",
"mitigations"
})
public class Control{

@JsonProperty("probabilityControlId")
public String probabilityControlId;
@JsonProperty("questionText")
public String questionText;
@JsonProperty("singleChoice")
public Boolean singleChoice;
@JsonProperty("noteMinValue")
public Float noteMinValue;
@JsonProperty("filterOperator")
public String filterOperator;
@JsonProperty("filterValues")
public List<Object> filterValues = null;
@JsonProperty("mitigations")
public List<Mitigation> mitigations = null;

}
