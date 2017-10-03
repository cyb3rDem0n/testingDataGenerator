package it.senseisrl.mitiga.survey.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"logItems",
"visibility"
})
public class SurveyLog{

@JsonProperty("logItems")
public List<LogItem> logItems = null;
@JsonProperty("visibility")
public String visibility;

}
