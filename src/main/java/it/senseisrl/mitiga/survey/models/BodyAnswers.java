package it.senseisrl.mitiga.survey.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"threatResponses"
})
public class BodyAnswers {

@JsonProperty("threatResponses")
public List<ThreatResponse> threatResponses = null;

}