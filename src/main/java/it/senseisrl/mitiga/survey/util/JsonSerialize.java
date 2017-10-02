package it.senseisrl.mitiga.survey.util;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "note", "mitigation", "probabilityControlId", "counterMeasureId", "application", "validationNote",
		"userName", "userId" })
public class JsonSerialize implements Serializable {

	@JsonProperty("note")
	private String note;
	@JsonProperty("mitigation")
	private double mitigation;
	@JsonProperty("probabilityControlId")
	private String probabilityControlId;
	@JsonProperty("counterMeasureId")
	private String counterMeasureId;
	@JsonProperty("application")
	private double application;
	@JsonProperty("validationNote")
	private String validationNote;
	@JsonProperty("userName")
	private String userName;
	@JsonProperty("userId")
	private String userId;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 1149703199425647846L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public JsonSerialize() {
	}

	/**
	 * 
	 * @param application
	 * @param mitigation
	 * @param userId
	 * @param userName
	 * @param probabilityControlId
	 * @param note
	 * @param validationNote
	 * @param counterMeasureId
	 */
	public JsonSerialize(String note, double mitigation, String probabilityControlId, String counterMeasureId,
			double application, String validationNote, String userName, String userId) {
		super();
		this.note = note;
		this.mitigation = mitigation;
		this.probabilityControlId = probabilityControlId;
		this.counterMeasureId = counterMeasureId;
		this.application = application;
		this.validationNote = validationNote;
		this.userName = userName;
		this.userId = userId;
	}

	@JsonProperty("note")
	public String getNote() {
		return note;
	}

	@JsonProperty("note")
	public void setNote(String note) {
		this.note = note;
	}

	public JsonSerialize withNote(String note) {
		this.note = note;
		return this;
	}

	@JsonProperty("mitigation")
	public double getMitigation() {
		return mitigation;
	}

	@JsonProperty("mitigation")
	public void setMitigation(double mitigation) {
		this.mitigation = mitigation;
	}

	public JsonSerialize withMitigation(double mitigation) {
		this.mitigation = mitigation;
		return this;
	}

	@JsonProperty("probabilityControlId")
	public String getProbabilityControlId() {
		return probabilityControlId;
	}

	@JsonProperty("probabilityControlId")
	public void setProbabilityControlId(String probabilityControlId) {
		this.probabilityControlId = probabilityControlId;
	}

	public JsonSerialize withProbabilityControlId(String probabilityControlId) {
		this.probabilityControlId = probabilityControlId;
		return this;
	}

	@JsonProperty("counterMeasureId")
	public String getCounterMeasureId() {
		return counterMeasureId;
	}

	@JsonProperty("counterMeasureId")
	public void setCounterMeasureId(String counterMeasureId) {
		this.counterMeasureId = counterMeasureId;
	}

	public JsonSerialize withCounterMeasureId(String counterMeasureId) {
		this.counterMeasureId = counterMeasureId;
		return this;
	}

	@JsonProperty("application")
	public double getApplication() {
		return application;
	}

	@JsonProperty("application")
	public void setApplication(double application) {
		this.application = application;
	}

	public JsonSerialize withApplication(double application) {
		this.application = application;
		return this;
	}

	@JsonProperty("validationNote")
	public String getValidationNote() {
		return validationNote;
	}

	@JsonProperty("validationNote")
	public void setValidationNote(String validationNote) {
		this.validationNote = validationNote;
	}

	public JsonSerialize withValidationNote(String validationNote) {
		this.validationNote = validationNote;
		return this;
	}

	@JsonProperty("userName")
	public String getUserName() {
		return userName;
	}

	@JsonProperty("userName")
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public JsonSerialize withUserName(String userName) {
		this.userName = userName;
		return this;
	}

	@JsonProperty("userId")
	public String getUserId() {
		return userId;
	}

	@JsonProperty("userId")
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public JsonSerialize withUserId(String userId) {
		this.userId = userId;
		return this;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public JsonSerialize withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}
}
