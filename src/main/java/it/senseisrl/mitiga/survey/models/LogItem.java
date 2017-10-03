package it.senseisrl.mitiga.survey.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"counterMeasureIncluded",
"mitigationName",
"counterMeasureAttrs",
"commonAttrs",
"assetAttrs",
"expression",
"note"
})
public class LogItem{

@JsonProperty("counterMeasureIncluded")
public Boolean counterMeasureIncluded;
@JsonProperty("mitigationName")
public String mitigationName;
@JsonProperty("counterMeasureAttrs")
public List<CounterMeasureAttr> counterMeasureAttrs = null;
@JsonProperty("commonAttrs")
public List<CommonAttr> commonAttrs = null;
@JsonProperty("assetAttrs")
public List<AssetAttr> assetAttrs = null;
@JsonProperty("expression")
public String expression;
@JsonProperty("note")
public String note;
}
