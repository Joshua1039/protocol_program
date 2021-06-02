package Server;

import org.apache.log4j.PropertyConfigurator;
import Logger.Logger;
public class Application_Main {

	public static void main(String[] args) {

		
		Logger.InitLogger(Application_Main.class);
		Logger.Write.info("LOG4J 사용을 위한 Logger.InitLogger(Application_Main.class)");
	}

}
