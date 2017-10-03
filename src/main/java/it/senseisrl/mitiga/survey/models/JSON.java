package it.senseisrl.mitiga.survey.models;

public class JSON {
	private AssetAttr assetAttr;
	private Body body;
	private BodyAnswers bodyAnswers;
	private BodyQuestions bodyQuestions;
	private CommonAttr commonAttr;
	private Control control;
	private Countermeasure countermeasure ;
	private CounterMeasureAttr counterMeasureAttr;
	private Header header;
	private Header_ header_;
	private HeaderQuestions headerQuestion;
	private LogItem logItem;
	private Mitigation mitigation;
	private Probability probability;
	private SurveyLog surveyLog;
	private ThreatResponse threatResponse;
	public AssetAttr getAssetAttr() {
		return assetAttr;
	}
	public void setAssetAttr(AssetAttr assetAttr) {
		this.assetAttr = assetAttr;
	}
	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		this.body = body;
	}
	public BodyAnswers getBodyAnswers() {
		return bodyAnswers;
	}
	public void setBodyAnswers(BodyAnswers bodyAnswers) {
		this.bodyAnswers = bodyAnswers;
	}
	public BodyQuestions getBodyQuestions() {
		return bodyQuestions;
	}
	public void setBodyQuestions(BodyQuestions bodyQuestions) {
		this.bodyQuestions = bodyQuestions;
	}
	public CommonAttr getCommonAttr() {
		return commonAttr;
	}
	public void setCommonAttr(CommonAttr commonAttr) {
		this.commonAttr = commonAttr;
	}
	public Control getControl() {
		return control;
	}
	public void setControl(Control control) {
		this.control = control;
	}
	public Countermeasure getCountermeasure() {
		return countermeasure;
	}
	public void setCountermeasure(Countermeasure countermeasure) {
		this.countermeasure = countermeasure;
	}
	public CounterMeasureAttr getCounterMeasureAttr() {
		return counterMeasureAttr;
	}
	public void setCounterMeasureAttr(CounterMeasureAttr counterMeasureAttr) {
		this.counterMeasureAttr = counterMeasureAttr;
	}
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	public Header_ getHeader_() {
		return header_;
	}
	public void setHeader_(Header_ header_) {
		this.header_ = header_;
	}
	public HeaderQuestions getHeaderQuestion() {
		return headerQuestion;
	}
	public void setHeaderQuestion(HeaderQuestions headerQuestion) {
		this.headerQuestion = headerQuestion;
	}
	public LogItem getLogItem() {
		return logItem;
	}
	public void setLogItem(LogItem logItem) {
		this.logItem = logItem;
	}
	public Mitigation getMitigation() {
		return mitigation;
	}
	public void setMitigation(Mitigation mitigation) {
		this.mitigation = mitigation;
	}
	public Probability getProbability() {
		return probability;
	}
	public void setProbability(Probability probability) {
		this.probability = probability;
	}
	public SurveyLog getSurveyLog() {
		return surveyLog;
	}
	public void setSurveyLog(SurveyLog surveyLog) {
		this.surveyLog = surveyLog;
	}
	public ThreatResponse getThreatResponse() {
		return threatResponse;
	}
	public void setThreatResponse(ThreatResponse threatResponse) {
		this.threatResponse = threatResponse;
	}
	public JSON() {
		super();
	}
	@Override
	public String toString() {
		return "JSON [assetAttr=" + assetAttr + ", body=" + body + ", bodyAnswers=" + bodyAnswers + ", bodyQuestions="
				+ bodyQuestions + ", commonAttr=" + commonAttr + ", control=" + control + ", countermeasure="
				+ countermeasure + ", counterMeasureAttr=" + counterMeasureAttr + ", header=" + header + ", header_="
				+ header_ + ", headerQuestion=" + headerQuestion + ", logItem=" + logItem + ", mitigation=" + mitigation
				+ ", probability=" + probability + ", surveyLog=" + surveyLog + ", threatResponse=" + threatResponse
				+ "]";
	}
	
}
