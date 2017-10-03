package it.senseisrl.mitiga.survey.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"mitigation",
"application",
"note",
"userName",
"validationNote",
"probabilityControlId",
"counterMeasureId",
"userId"
})
public class Countermeasure{

@JsonProperty("mitigation")
public Float mitigation;
@JsonProperty("application")
public Float application;
@JsonProperty("note")
public String note;
@JsonProperty("userName")
public String userName;
@JsonProperty("validationNote")
public String validationNote;
@JsonProperty("probabilityControlId")
public String probabilityControlId;
@JsonProperty("counterMeasureId")
public String counterMeasureId;
@JsonProperty("userId")
public String userId;

}