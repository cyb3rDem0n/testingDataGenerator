package it.senseisrl.mitiga.survey.plugin;

public class PluginFactory {

	/**
	 * Create a Factory to generate object of concrete class based on given
	 * information.
	 */
	public static AnswerType create(String classPath) {
		AnswerType answerType;

		if (classPath.equals("it.senseisrl.mitiga.survey.plugin.ApplicationAnswerType")) {
			answerType = new ApplicationAnswerType();
		} else {
			if (classPath.equals("it.senseisrl.mitiga.survey.plugin.OtherAnswerType")) {
				answerType = new OtherAnswerType();
			} else
				answerType = null;
			System.out.println("answerType NOT FOUND");
		}
		return answerType;
	}

}
