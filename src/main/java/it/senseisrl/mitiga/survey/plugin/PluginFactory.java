package it.senseisrl.mitiga.survey.plugin;

public class PluginFactory {

		/**
		 * 	Create a Factory to generate object of concrete 
		 * class based on given information.
		 */
		public static AnswerType create(String classPath) {
			if(classPath.equals(null)) {
				return null;
			}
			if(classPath.equals(ApplicationAnswerType.name_)){
				return new ApplicationAnswerType();
			}
			if(classPath.equals(OtherAnswerType.name_)) {
				return new OtherAnswerType();
			}
			
			return null;  //modifica
		}	
		
}
