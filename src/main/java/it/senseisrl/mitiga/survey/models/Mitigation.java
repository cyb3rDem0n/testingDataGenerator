package it.senseisrl.mitiga.survey.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"counterMeasureId",
"counterMeasureName",
"mitigation",
"application"
})
public class Mitigation{

@JsonProperty("counterMeasureId")
public String counterMeasureId;
@JsonProperty("counterMeasureName")
public String counterMeasureName;
@JsonProperty("mitigation")
public Float mitigation;
@JsonProperty("application")
public Float application;

}