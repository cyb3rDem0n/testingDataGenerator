package it.senseisrl.mitiga.survey.countermeasure;

/**
 * Serialize a Countermeasure from a JSON response file The JSON response file
 * contain a collection of countermeasures
 *
 * @author Giuseppe D'Agostino
 */

public class Countermeasure extends Body {

	private String mitigation;
	private String application;
	private String note;
	private String userName;
	private String validationNote;
	private String probabilityControlId;
	private String counterMeasureId;
	private String userId;

	public Countermeasure() {
	}

	public Countermeasure(String mitigation, String application, String note, String userName, String validationNote,
			String probabilityControlId, String counterMeasureId, String userId) {
		this.mitigation = mitigation;
		this.application = application;
		this.note = note;
		this.userName = userName;
		this.validationNote = validationNote;
		this.probabilityControlId = probabilityControlId;
		this.counterMeasureId = counterMeasureId;
		this.userId = userId;
	}

	public String getMitigation() {
		return mitigation;
	}

	public void setMitigation(String mitigation) {
		this.mitigation = mitigation;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getValidationNote() {
		return validationNote;
	}

	public void setValidationNote(String validationNote) {
		this.validationNote = validationNote;
	}

	public String getProbabilityControlId() {
		return probabilityControlId;
	}

	public void setProbabilityControlId(String probabilityControlId) {
		this.probabilityControlId = probabilityControlId;
	}

	public String getCounterMeasureId() {
		return counterMeasureId;
	}

	public void setCounterMeasureId(String counterMeasureId) {
		this.counterMeasureId = counterMeasureId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
    public String toString() {
        return  "\n ==>> Countermeasure: " +
                "\n ==>> mitigation=" + mitigation +
                "\n ==>> application=" + application +
                "\n ==>> note='" + note +
                "\n ==>> userName=" + userName +
                "\n ==>> validationNote=" + validationNote +
                "\n ==>> probabilityControlId=" + probabilityControlId +
                "\n ==>> counterMeasureId='" + counterMeasureId +
                "\n ==>> userId=" + userId + " \n";
    }
	
}