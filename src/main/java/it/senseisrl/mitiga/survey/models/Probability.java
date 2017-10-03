package it.senseisrl.mitiga.survey.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"probabilityId",
"typeId",
"typeName",
"threatId",
"threatName",
"probability",
"controls"
})
public class Probability{

@JsonProperty("probabilityId")
public String probabilityId;
@JsonProperty("typeId")
public String typeId;
@JsonProperty("typeName")
public String typeName;
@JsonProperty("threatId")
public String threatId;
@JsonProperty("threatName")
public String threatName;
@JsonProperty("probability")
public Float probability;
@JsonProperty("controls")
public List<Control> controls = null;
}