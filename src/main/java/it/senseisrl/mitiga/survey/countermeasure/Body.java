package it.senseisrl.mitiga.survey.countermeasure;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Body {
	private String bodyQuestions;
	private Countermeasure countermeasure;
	private String visibility;
	
	public String getBodyQestions() {
		return bodyQuestions;
	}
	public void setBodyQestions(String bodyQestions) {
		this.bodyQuestions = bodyQestions;
	}
	public Body(String bodyQestions, Countermeasure countermeasure, String visibility) {
		super();
		this.visibility = visibility;
		this.bodyQuestions = bodyQestions;
		this.countermeasure = countermeasure;
	}
	public Body() {
		super();
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	@Override
	public String toString() {
		return "Body [bodyQuestions=" + bodyQuestions + ", countermeasure=" + countermeasure + ", visibility="
				+ visibility + "]";
	}
	
	
}
