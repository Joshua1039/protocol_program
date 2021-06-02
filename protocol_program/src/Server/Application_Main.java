package Server;

import java.util.Properties;

import Logger.Logger;
public class Application_Main {

	public static void main(String[] args) {

		Logger.InitLogger(Application_Main.class);
		Logger.Write.info("LOG4J 사용 >  Logger.InitLogger(Application_Main.class);");

		Properties p; // properties 선언
		Logger.Write.info("Properties 사용 >  Properties p; ");
		
		
		
		p = MainUtil.createProperties("config.xml");
		
	}

}
