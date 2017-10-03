package it.senseisrl.mitiga.survey.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"countermeasures",
"probabilityId",
"threatId"
})
public class ThreatResponse{

@JsonProperty("countermeasures")
public List<Countermeasure> countermeasures = null;
@JsonProperty("probabilityId")
public String probabilityId;
@JsonProperty("threatId")
public String threatId;

}
