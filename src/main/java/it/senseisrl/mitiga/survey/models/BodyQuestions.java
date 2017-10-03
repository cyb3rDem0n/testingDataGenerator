package it.senseisrl.mitiga.survey.models;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"processId",
"state",
"createdOn",
"createdById",
"createdByName",
"ownerId",
"ownerName",
"delegatedOn",
"delegatedUserId",
"delegatedUserName",
"systemOwnerId",
"systemOwnerName",
"assetId",
"assetName",
"probabilities",
"assetTypeName",
"applicationValues",
"defaultMutualExclusiveAnswer"
})
public class BodyQuestions{

@JsonProperty("processId")
public String processId;
@JsonProperty("state")
public String state;
@JsonProperty("createdOn")
public Integer createdOn;
@JsonProperty("createdById")
public String createdById;
@JsonProperty("createdByName")
public String createdByName;
@JsonProperty("ownerId")
public String ownerId;
@JsonProperty("ownerName")
public String ownerName;
@JsonProperty("delegatedOn")
public Object delegatedOn;
@JsonProperty("delegatedUserId")
public Object delegatedUserId;
@JsonProperty("delegatedUserName")
public Object delegatedUserName;
@JsonProperty("systemOwnerId")
public String systemOwnerId;
@JsonProperty("systemOwnerName")
public String systemOwnerName;
@JsonProperty("assetId")
public String assetId;
@JsonProperty("assetName")
public String assetName;
@JsonProperty("probabilities")
public List<Probability> probabilities = null;
@JsonProperty("assetTypeName")
public String assetTypeName;
@JsonProperty("applicationValues")
public String applicationValues;
@JsonProperty("defaultMutualExclusiveAnswer")
public String defaultMutualExclusiveAnswer;

}