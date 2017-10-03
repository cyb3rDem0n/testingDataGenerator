package it.senseisrl.mitiga.survey.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"headerQuestions",
"visibility"
})
public class Header_{

@JsonProperty("headerQuestions")
public List<HeaderQuestions> headerQuestions = null;
@JsonProperty("visibility")
public String visibility;

}